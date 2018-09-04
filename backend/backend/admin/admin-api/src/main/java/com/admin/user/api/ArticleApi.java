package com.admin.user.api;

import com.admin.user.dto.ArticleReqDTO;
import com.admin.user.dto.ArticleResDTO;
import com.admin.user.dto.articletype.ArticleSaveReqDTO;
import com.admin.user.dto.articletype.ArticleTypeResDTO;
import com.hengyunsoft.base.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArticleApi {
    @RequestMapping(value = "/article/findTypeByUser",method = RequestMethod.GET)
    Result<List<ArticleTypeResDTO>> findTypeByUser(@RequestParam(value = "id") Long id);

    @RequestMapping(value = "/article/pageByUser",method = RequestMethod.POST)
    Result<List<ArticleResDTO>> pageByUser(@RequestBody ArticleReqDTO articleReqDTO);

    @RequestMapping(value = "/article/getArticle",method = RequestMethod.GET)
    Result<ArticleResDTO> getArticle(@RequestParam(value = "id") Long id);

    @RequestMapping(value = "/article/saveArticleType",method = RequestMethod.POST)
    Result<Boolean> saveArticleType(@RequestBody ArticleTypeResDTO dto);

    @RequestMapping(value = "/article/saveArticle",method = RequestMethod.POST)
    Result<Boolean> saveArticle(@RequestBody ArticleSaveReqDTO dto);

    @RequestMapping(value = "/article/deleteArticle",method = RequestMethod.GET)
    Result<Boolean> deleteArticle(@RequestParam(value = "id") Long id);

    @RequestMapping(value = "/article/deleteArticleType",method = RequestMethod.GET)
    Result<Boolean> deleteArticleType(@RequestParam(value = "id") Long id);
}
