package com.file.user.util.ueditor.upload;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;

/**
 * 把文件保存到阿里云OSS，返回文件访问路径
 *
 * @author linhongcun
 */
@Component
public class OssUploader {
    public static String getFileUrl(MultipartFile fileupload, String path, OssContext ossContext) throws OSSException, ClientException, IOException {
        // 获取文件后缀名
        String suffix = getSuffix(fileupload);
        // 填自己的帐号信息
        String endpoint = ossContext.getEndpoint();
        String accessKeyId = ossContext.getAccessKeyId();
        String accessKeySecret = ossContext.getAccessKeySecret();
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 文件桶
        String bucketName = ossContext.getBucketName();
        // 文件名格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        // 该桶中的文件key
        String dateString = sdf.format(new Date()) + "." + suffix; // 20180322010634.jpg
        // 上传文件
        path = path.substring(1, path.length()-1) + "/" + dateString;
        ossClient.putObject(bucketName, path, new ByteArrayInputStream(fileupload.getBytes()));
        // 设置URL过期时间为100年，默认这里是int型，转换为long型即可
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 100);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, path, expiration);
        return url.toString();
    }

    // 获取文 MultipartFile 文件后缀名工具
    public static String getSuffix(MultipartFile fileupload) {
        String originalFilename = fileupload.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println(suffix);
        return suffix;
    }

}