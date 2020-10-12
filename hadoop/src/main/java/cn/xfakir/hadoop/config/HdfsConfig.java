package cn.xfakir.hadoop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HdfsConfig {
    @Value("${hdfs.path}")
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
