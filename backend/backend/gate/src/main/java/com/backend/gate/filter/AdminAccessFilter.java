package com.backend.gate.filter;

import com.backend.gate.config.GateIgnoreProperties;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.utils.JSONUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.List;

@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter {
    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Autowired
    private IUserToken userToken;
    @Autowired
    private GateIgnoreProperties gateIgnoreProperties;
    /**
     * 为zuul设置一个公共的前缀
     */
    @Value("${boke.context-path.gate}")
    private String zuulPrefix;

    /**
     * 给 userService 接口添加拦截器，每次调用userService 接口的方法，都自动在请求头中添加
     * auth-client-token 和 auth-user-token
     */
    @PostConstruct
    public void init() {
        //InstanceInfo prodSvcInfo = discoveryClient.getNextServerFromEureka("GXQPT-ADMIN-SERVER", false);
        //ServiceFeignInterceptor serviceFeignInterceptor = new ServiceFeignInterceptor();
        //serviceFeignInterceptor.setServiceAuthConfig(serviceAuthConfig);
        //serviceFeignInterceptor.setServiceAuthUtil(serviceAuthUtil);
        //serviceFeignInterceptor.setUserAuthConfig(appAuthConfig);
        //this.userService = Feign.builder().encoder(new JacksonEncoder())
        //        .decoder(new JacksonDecoder())
        //        .requestInterceptor(serviceFeignInterceptor)
        //        .target(UserService.class, prodSvcInfo.getHomePageUrl());
    }

    /**
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        // 前置过滤器
        return "pre";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        // 数字越大，优先级越低
        /**
         * 一定要在 {@link org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter} 过滤器之后执行，因为这个过滤器做了路由  而我们需要这个路由信息来鉴权
         * 这个过滤器会将很多我们鉴权需要的信息放置在请求上下文中。故一定要在此过滤器之后执行
         */
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        /**
         * 在过滤器中抛出异常后，会被   {@link org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter}重定向到错误界面，然而在重定向的过程中，依然会经过一次
         * 这些过滤器，而我们需要忽略这种情况。故我们不过滤那种错误重定向的请求
         */
        return ctx.getThrowable() == null;
    }

    /**
     * 过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
     * 不对其进行路由，然后通过ctx.setResponseStatusCode(200)设置了其返回的错误码
     *
     * @return
     */

    @Override
    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
//
//        BaseContextHandler.setToken(null);
//        // 不进行拦截的地址
//        if (isStartWith(requestUri)) {
//            return null;
//        }
//
//        List<String> userInfo = null;
//        String token = getTokenFromRequest(request);
//
//        try {
//            if (token == null) {
//                return null;
//            }
//            userInfo = getUserToken(token);
//
//            BaseContextHandler.setAdminId(Long.valueOf(userToken.getUserId(userInfo)));
//            BaseContextHandler.setName(userToken.getUserName(userInfo));
//        } catch (BizException e) {
//            errorResponse(e.getMessage(), e.getCode(), 200);
//            return null;
//        } catch (Exception e) {
//            errorResponse("验证token出错", Result.FAIL, 500);
//            return null;
//        }
//
//        log.info(Thread.currentThread().getName());
        return null;
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String authToken = request.getHeader("token");
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter("token");
        }
        return authToken;
    }

    private List<String> getUserToken(String token) {

        try {
            token = URLDecoder.decode(token, "utf-8");
            return userToken.uncoder(token);
        } catch (Exception e) {
            //不是标准的userToken   说明是appToken
        }
        return null;
    }

    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        // 返回错误码
        ctx.setResponseStatusCode(code);
        ctx.addZuulResponseHeader("Content-Type", "application/json;charset=UTF-8");
        if (ctx.getResponseBody() == null) {
            // 返回错误内容
            ctx.setResponseBody(body);
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
        }
    }

    private void errorResponse(String errMsg, int errCode, int httpStatusCode) {
        Result tokenError = Result.fail(errCode, errMsg);
        setFailedRequest(JSONUtils.toJsonString(tokenError), httpStatusCode);
    }

    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        if (gateIgnoreProperties == null || gateIgnoreProperties.getStartWithList().isEmpty()) {
            return false;
        }
        for (String s : gateIgnoreProperties.getStartWithList()) {
            if (requestUri.startsWith(s) || PATH_MATCHER.match(s, requestUri)) {
                return true;
            }
        }
        return false;
    }
}
