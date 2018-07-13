package com.admin.user.impl;

import com.admin.user.api.ArticleApi;
import com.admin.user.content.ArticleContent;
import com.admin.user.dto.ArticleReqDTO;
import com.admin.user.dto.ArticleResDTO;
import com.admin.user.dto.articletype.ArticleSaveReqDTO;
import com.admin.user.dto.articletype.ArticleTypeResDTO;
import com.admin.user.entity.po.Article;
import com.admin.user.entity.po.ArticleType;
import com.admin.user.repository.base.example.ArticleExample;
import com.admin.user.repository.base.example.ArticleTypeExample;
import com.admin.user.repository.base.service.ArticleService;
import com.admin.user.repository.base.service.ArticleTypeService;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
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
public class ArticleApiImpl implements ArticleApi {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private DozerUtils dozerUtils;

    @Override
    @IgnoreToken
    @RequestMapping(value = "/findTypeByUser", method = RequestMethod.GET)
    public Result<List<ArticleTypeResDTO>> findTypeByUser(@RequestParam(value = "id") Long id) {
        ArticleTypeExample example = new ArticleTypeExample();
        example.createCriteria().andUseridEqualTo(id);
        List list = articleTypeService.find(example);

        return Result.success(dozerUtils.mapList(list, ArticleTypeResDTO.class));
    }

    @Override
    @IgnoreToken
    @RequestMapping(value = "/pageByUser", method = RequestMethod.POST)
    public Result<List<ArticleResDTO>> pageByUser(@RequestBody ArticleReqDTO articleReqDTO) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause(ArticleContent.ORDER_BY.getValue().toString());
        example.createCriteria().andUserIdEqualTo(articleReqDTO.getUserId())
                .andTypeEqualTo(articleReqDTO.getType());

        List list = articleService.find(example);

        return Result.success(dozerUtils.mapList(list, ArticleResDTO.class));
    }

    @Override
    @IgnoreToken
    @RequestMapping(value = "/getArticle", method = RequestMethod.GET)
    public Result<ArticleResDTO> getArticle(@RequestParam(value = "id") Long id) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andIdEqualTo(id);

        ArticleResDTO dto = dozerUtils.map(articleService.getUnique(example), ArticleResDTO.class);
        return Result.success(dto);
    }

    @Override
    @RequestMapping(value = "/saveArticleType", method = RequestMethod.POST)
    public Result<Boolean> saveArticleType(@RequestBody ArticleTypeResDTO dto) {
        Long userId = BaseContextHandler.getAdminId();

        ArticleType articleType = dozerUtils.map(dto, ArticleType.class);
        articleType.setUserid(userId);
        articleType.setCreateUser(userId);
        articleType.setUpdateUser(userId);

        if (articleTypeService.save(articleType) != null) {
            return Result.success(true);
        }
        return Result.fail("添加失败！");
    }

    @Override
    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public Result<Boolean> saveArticle(@RequestBody ArticleSaveReqDTO dto) {
        Long userId = BaseContextHandler.getAdminId();

        Article article = dozerUtils.map(dto, Article.class);
        article.setCreateUser(userId);
        article.setUpdateUser(userId);
        article.setFabulous(0);
        article.setUserId(userId);

        if (articleService.save(article)!=null){
            return Result.success(true);
        }
        return Result.fail("fail");
    }
}
