package com.admin.user.impl;

import com.admin.user.api.ArticleApi;
import com.admin.user.content.ArticleContent;
import com.admin.user.dto.ArticleReqDTO;
import com.admin.user.dto.ArticleResDTO;
import com.admin.user.repository.base.example.ArticleExample;
import com.admin.user.repository.base.service.ArticleService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "ArticleApi", description = "文章管理")
@RestController
@RequestMapping("article")
public class ArticleApiImpl implements ArticleApi{
    @Autowired
    private ArticleService articleService;

    @Autowired
    private DozerUtils dozerUtils;

    @Override
    @RequestMapping(value = "/findTypeByUser",method = RequestMethod.GET)
    public Result<List<String>> findTypeByUser(@RequestParam(value = "id") Long id) {
        List list = articleService.findTypeByUser(id);

        return Result.success(list);
    }

    @Override
    @RequestMapping(value = "/pageByUser",method = RequestMethod.POST)
    public Result<List<ArticleResDTO>> pageByUser(@RequestBody ArticleReqDTO articleReqDTO) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause(ArticleContent.ORDER_BY.getValue().toString());
        example.createCriteria().andUserIdEqualTo(articleReqDTO.getUserId())
                .andTypeEqualTo(articleReqDTO.getType());

        List list = articleService.find(example);

        return Result.success(dozerUtils.mapList(list,ArticleResDTO.class));
    }

    @Override
    @RequestMapping(value = "/getArticle",method = RequestMethod.GET)
    public Result<ArticleResDTO> getArticle(@RequestParam(value = "id") Long id) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andIdEqualTo(id);

        ArticleResDTO dto = dozerUtils.map(articleService.getUnique(example),ArticleResDTO.class);
        return Result.success(dto);
    }
}
