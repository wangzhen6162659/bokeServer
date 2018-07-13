package com.file.user.api;

import com.file.user.dto.FileResDTO;
import com.hengyunsoft.base.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public interface FileApi {
    @RequestMapping(value = "/file/get",method = RequestMethod.GET)
    FileResDTO get(@RequestParam(value = "id")Long id);

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    Result<FileResDTO> upload(@RequestBody MultipartFile file) throws IOException;

    @RequestMapping(value = "/file/exec",method = RequestMethod.POST)
    String exec(HttpServletRequest request) throws UnsupportedEncodingException;
}
