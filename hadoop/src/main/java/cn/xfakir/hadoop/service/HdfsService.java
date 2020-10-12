package cn.xfakir.hadoop.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HdfsService {
    @Value("${hdfs.path}")
    private String path;
    @Value("${hdfs.username}")
    private String username;

    private static String hdfsPath;
    private static String hdfsName;
    private static final int bufferSize = 1024 * 1024 * 64;

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);
        return configuration;
    }

    public static FileSystem getFileSystem() throws Exception {
        // 客户端去操作hdfs时是有一个用户身份的，默认情况下hdfs客户端api会从jvm中获取一个参数作为自己的用户身份
        // DHADOOP_USER_NAME=hadoop
        // 也可以在构造客户端fs对象时，通过参数传递进去
        FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), getConfiguration(), hdfsName);
        return fileSystem;
    }

    public static boolean mkdir(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        if (existFile(path)) {
            return true;
        }
        FileSystem fs = getFileSystem();
        // 目标路径
        Path srcPath = new Path(path);
        boolean isOk = fs.mkdirs(srcPath);
        fs.close();
        return isOk;
    }

    public static boolean existFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        FileSystem fs = getFileSystem();
        Path srcPath = new Path(path);
        boolean isExists = fs.exists(srcPath);
        return isExists;
    }

    public static void createFile(String path, MultipartFile file) throws Exception {
        if (StringUtils.isEmpty(path) || null == file.getBytes()) {
            return;
        }
        String fileName = file.getOriginalFilename();
        FileSystem fs = getFileSystem();
        // 上传时默认当前目录，后面自动拼接文件的目录
        Path newPath = new Path(path + "/" + fileName);
        // 打开一个输出流
        FSDataOutputStream outputStream = fs.create(newPath);
        outputStream.write(file.getBytes());
        outputStream.close();
        fs.close();
    }

    public static List<Map<String, String>> listFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        if (!existFile(path)) {
            return null;
        }

        FileSystem fs = getFileSystem();
        // 目标路径
        Path srcPath = new Path(path);
        // 递归找到所有文件
        RemoteIterator<LocatedFileStatus> filesList = fs.listFiles(srcPath, true);
        List<Map<String, String>> returnList = new ArrayList<>();
        while (filesList.hasNext()) {
            LocatedFileStatus next = filesList.next();
            String fileName = next.getPath().getName();
            Path filePath = next.getPath();
            Map<String, String> map = new HashMap<>();
            map.put("fileName", fileName);
            map.put("filePath", filePath.toString());
            returnList.add(map);
        }
        fs.close();
        return returnList;
    }

    public static boolean deleteFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        if (!existFile(path)) {
            return false;
        }
        FileSystem fs = getFileSystem();
        Path srcPath = new Path(path);
        boolean isOk = fs.deleteOnExit(srcPath);
        fs.close();
        return isOk;
    }

    public static void uploadFile(String path, String uploadPath) throws Exception {
        if (StringUtils.isEmpty(path) || StringUtils.isEmpty(uploadPath)) {
            return;
        }
        FileSystem fs = getFileSystem();
        // 上传路径
        Path clientPath = new Path(path);
        // 目标路径
        Path serverPath = new Path(uploadPath);

        // 调用文件系统的文件复制方法，第一个参数是否删除原文件true为删除，默认为false
        fs.copyFromLocalFile(false, clientPath, serverPath);
        fs.close();
    }


    @PostConstruct
    public void getPath() {
        hdfsPath = this.path;
    }

    @PostConstruct
    public void getName() {
        hdfsName = this.username;
    }

    public static String getHdfsPath() {
        return hdfsPath;
    }

    public String getUsername() {
        return username;
    }

}
