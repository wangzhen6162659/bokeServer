package com.file.user.util.ueditor.upload;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static com.file.user.util.ueditor.upload.OssContext.OSS_PREFIX;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = OSS_PREFIX)
public class OssContext {
    public static final String OSS_PREFIX = "boke.oss";
    /*节点*/
    private String endpoint;
    /*主用户Key*/
    private String accessKeyId;
    /*主用户秘钥*/
    private String accessKeySecret;
    /*桶*/
    private String bucketName;
}
