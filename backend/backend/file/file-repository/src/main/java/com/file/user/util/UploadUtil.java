package com.file.user.util;

import com.file.user.config.FileProperties;
import com.file.user.constant.BaseFileModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author wz
 * @createTime 2018-01-23 22:14
 */
public class UploadUtil {
    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");
    /**
     * 创建文件价
     *
     * @param fileName
     */
    public static void mkFolder(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    /**
     * 写文件到服务器
     * @param inputStream
     * @param fileUploadPath
     * @param fileName
     * @return
     */
    public static boolean write(InputStream inputStream, FileProperties fileProperties, String fileName) {
        boolean ret = false;
        //File dir = new File(fileUploadPath);
        //if (!dir.exists()) {
        //    dir.mkdirs();
        //}
        BaseFileModel bfm = getBaseFileModel(fileProperties.getUploadPathPrefix(), fileName);
        String absolutePath = bfm.getAbsolutePath();
        String relativePath = bfm.getRelativePath();

        mkFolder(fileProperties.getUploadPathPrefix());

        File file = new File(fileProperties.getUploadPathPrefix() + File.separator + fileName);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            ret = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
    public static boolean write(InputStream inputStream, String path, String fileName) {
        boolean ret = false;
        //File dir = new File(fileUploadPath);
        //if (!dir.exists()) {
        //    dir.mkdirs();
        //}
        BaseFileModel bfm = getBaseFileModel(path, fileName);
        String absolutePath = bfm.getAbsolutePath();
        String relativePath = bfm.getRelativePath();

        mkFolder(path);

        File file = new File(path + File.separator + fileName);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            ret = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
    public static BaseFileModel getBaseFileModel(String uploadPathPrefix,  String submittedFileName){
        //后缀
        String suffix = FileUtils.getExtension(submittedFileName);
        //生成文件名
        String fileName = UUID.randomUUID().toString() + suffix;
        //日期文件夹
        String secDir = LocalDate.now().format(DTF);
        // /home/tyh/APP_ID/YYYY/MM
        String relativePath = Paths.get(secDir).toString();
        // web服务器存放的绝对路径
        String absolutePath = Paths.get(uploadPathPrefix, relativePath).toString();
        return new BaseFileModel(relativePath, absolutePath, fileName, suffix);
    }
}
