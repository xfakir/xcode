package cn.xfakir.hadoop.controller;

import cn.xfakir.hadoop.config.Result;
import cn.xfakir.hadoop.service.HdfsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hadoop")
public class HadoopControler {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("test","hello hadoop");
        return "index";
    }

    @RequestMapping(value = "mkdir", method = RequestMethod.POST)
    @ResponseBody
    public Result mkdir(@RequestParam("path") String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return new Result(Result.FAILURE, "请求参数为空");
        }
        // 创建空文件夹
        boolean isOk = HdfsService.mkdir(path);
        if (isOk) {
            return new Result(Result.SUCCESS, "文件夹创建成功");
        } else {
            return new Result(Result.FAILURE, "文件夹创建失败");
        }
    }

    @PostMapping("/listFile")
    public Result listFile(@RequestParam("path") String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return new Result(Result.FAILURE, "请求参数为空");
        }
        List<Map<String, String>> returnList = HdfsService.listFile(path);
        return new Result(Result.SUCCESS, "读取文件列表成功", returnList);
    }

    @PostMapping("/deleteFile")
    public Result deleteFile(@RequestParam("path") String path) throws Exception {
        boolean isOk = HdfsService.deleteFile(path);
        if (isOk) {
            return new Result(Result.SUCCESS, "delete file success");
        } else {
            return new Result(Result.FAILURE, "delete file fail");
        }
    }

    @PostMapping("/uploadFile")
    public Result uploadFile(@RequestParam("path") String path, @RequestParam("uploadPath") String uploadPath)
            throws Exception {
        HdfsService.uploadFile(path, uploadPath);
        return new Result(Result.SUCCESS, "upload file success");
    }

}
