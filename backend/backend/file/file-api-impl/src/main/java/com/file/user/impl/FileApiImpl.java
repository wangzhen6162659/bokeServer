package com.file.user.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.file.user.api.FileApi;
import com.file.user.config.FileProperties;
import com.file.user.dto.FileResDTO;
import com.file.user.entity.po.File;
import com.file.user.repository.base.example.FileExample;
import com.file.user.repository.base.service.FileService;
import com.file.user.util.UploadUtil;
import com.file.user.util.ueditor.ActionEnter;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;


@RestController
@Slf4j
public class FileApiImpl implements FileApi {
    @Autowired
    DozerUtils dozerUtils;
    @Autowired
    FileService fileService;
    @Autowired
    FileProperties fileProperties;

    @Override
    public FileResDTO get(@RequestParam(value = "id") Long id) {
        FileExample example = new FileExample();
        example.createCriteria().andIdEqualTo(id);

        FileResDTO res = dozerUtils.map(fileService.getUnique(example), FileResDTO.class);
        return res;
    }

    @Override
    @ApiOperation(value = "文件秒传", notes = "文件秒传   ")
    public Result<FileResDTO> upload(@RequestBody MultipartFile file) throws IOException {
        Long userId = BaseContextHandler.getAdminId();

        String realName = fileService.genId().toString();
        String prefix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);// 后缀名
        UploadUtil.write(file.getInputStream(), fileProperties, realName + "." + prefix);
        String url =  fileProperties.getRemoteUriPrefix() + "file/" + realName + "." + prefix;
        FileResDTO res = new FileResDTO();
        res.setFileName(file.getOriginalFilename());
        res.setRealName(realName);
        res.setPath(fileProperties.getUploadPathPrefix() + "/" + realName + "." + prefix);
        res.setExt(prefix);
        res.setMime(file.getContentType());
        res.setSize(String.valueOf(file.getSize()));
        res.setUrl(url);
        res.setUpdateTime(new Date());
        res.setCreateTime(new Date());
        res.setCreateUser(userId);
        res.setUpdateUser(userId);
        res.setUserId(userId);

        return Result.success(dozerUtils.map(fileService.save(dozerUtils.map(res,File.class)),FileResDTO.class));
    }

    @Override
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getRealPath("/");
        String exec = new ActionEnter(request, rootPath).exec();
        if (!request.getParameter("action").equals("config")) {
            JSONObject jsonObject = JSON.parseObject(exec);
            File file = new File();
            file.setRealName(jsonObject.get("realname").toString());
            file.setFileName(jsonObject.get("original").toString());
            file.setExt(jsonObject.get("type").toString());
            file.setMime(jsonObject.get("mime").toString());
            file.setPath(jsonObject.get("filePath").toString());
            file.setSize(jsonObject.get("size").toString());
            file.setUrl(jsonObject.get("url").toString());
            file.setUserId(BaseContextHandler.getAdminId());
            fileService.save(file);

        }
        return exec;
    }
}
