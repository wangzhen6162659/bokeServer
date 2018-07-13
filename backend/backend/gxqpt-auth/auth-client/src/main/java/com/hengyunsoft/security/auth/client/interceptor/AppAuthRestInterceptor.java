//package com.hengyunsoft.security.auth.client.interceptor;
//
//import com.hengyunsoft.commons.context.BaseContextHandler;
//import com.hengyunsoft.exception.BizException;
//import com.hengyunsoft.platform.commons.sec.IUserToken;
//import com.hengyunsoft.security.auth.client.annotation.AppToken;
//import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
//import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
//import com.hengyunsoft.security.auth.client.config.ServiceAuthConfig;
////import com.hengyunsoft.security.auth.client.jwt.ServiceAuthUtil;
//import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.UnsupportedEncodingException;
//import java.lang.annotation.Annotation;
//import java.net.URLDecoder;
//import java.util.List;
//
///**
// * 验证第三方外部请求
// * Created by tangyh on 2017/9/10.
// *
// * @author tyh
// */
//public class AppAuthRestInterceptor extends HandlerInterceptorAdapter {
//    private static final Logger log = LoggerFactory.getLogger(AppAuthRestInterceptor.class);
//    //@Autowired
//    //private AppAuthUtil appAuthUtil;
//    //
//    //@Autowired
//    //private AppAuthConfig appAuthConfig;
//
//    @Autowired
//    private ServiceAuthUtil serviceAuthUtil;
//
//    @Autowired
//    private ServiceAuthConfig serviceAuthConfig;
//
//    @Autowired
//    private IUserToken userToken;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//        if(isIgnoreToken(handlerMethod)) {
//        	return true;
//        }
//        String clazzName = handlerMethod.getBeanType().getName();
//        try {
//
//            List<String> userInfo = null;
//            String appToken = null;
//            IJWTInfo infoFromToken = null;
//            try {
//            	//默认都使用用户级token进行访问
//            	userInfo = getUserToken(request);
//            	if(userInfo != null) {
//
//            		appToken = userToken.getAppToken(userInfo);
//                    BaseContextHandler.setName(userToken.getUserName(userInfo));
//                    BaseContextHandler.setAdminId(Long.valueOf(userToken.getUserId(userInfo)));
//
//            	} else if(clazzName.indexOf(".open.") >= 0 || isAppTokenAnnotation(handlerMethod)) {
//            		// 项目中约定open包中的controller都是可以对外的，对外就代表可以通过应用级token来进行访问。有时候也希望不再open包中的有些controller 方法也可以被应用级token访问，所以这类操作
//            		// 需要在方法级别上面增加 @AppToken注解            只要满足这两个条件中的一个，就可以以应用级token进行访问
//            		appToken = getTokenFromRequest(request);
//            	}
//            	infoFromToken = serviceAuthUtil.getInfoFromToken(appToken);
//            } catch (BizException e) {
//            	throw e;
//            } catch (Exception e) {
//            	throw e;
//            }
//
//
//            BaseContextHandler.setAppId(infoFromToken.getAppId());
//            BaseContextHandler.setAppName(infoFromToken.getAppName());
//
//            BaseContextHandler.setToken(getTokenFromRequest(request));
//        } catch (Exception e) {
//            log.error("拦截器异常:{}", e);
//            //return false;
//            if (e instanceof BizException) {
//                throw (BizException) e;
//            }
//            throw new BizException(-1, e.getMessage());
//        }
//        return super.preHandle(request, response, handler);
//    }
//
//    private boolean isAppTokenAnnotation(HandlerMethod handlerMethod) {
//    	Annotation annotation = handlerMethod.getBeanType().getAnnotation(AppToken.class);
//        if (annotation == null) {
//        	annotation = handlerMethod.getMethodAnnotation(AppToken.class);
//        }
//		return annotation != null;
//	}
//
//    private boolean isIgnoreToken(HandlerMethod handlerMethod) {
//    	Annotation annotation = handlerMethod.getBeanType().getAnnotation(IgnoreAppToken.class);
//
//    	if (annotation == null) {
//    	    annotation = handlerMethod.getBeanType().getAnnotation(IgnoreToken.class);
//    	}
//        if (annotation == null) {
//            annotation = handlerMethod.getMethodAnnotation(IgnoreAppToken.class);
//        }
//
//        if (annotation == null) {
//        	annotation = handlerMethod.getMethodAnnotation(IgnoreToken.class);
//        }
//
//		return annotation != null;
//	}
//
//	@Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        BaseContextHandler.remove();
//        super.afterCompletion(request, response, handler, ex);
//    }
//
//	private List<String> getUserToken(HttpServletRequest request) throws UnsupportedEncodingException {
//
//		String authToken = getTokenFromRequest(request);
//		authToken = URLDecoder.decode(authToken, "utf-8");
//		try {
//			return userToken.uncoder(authToken);
//		} catch (Exception e) {
//			//不是标准的userToken   说明是appToken
//		}
//		return null;
//	}
//
//	private String getTokenFromRequest(HttpServletRequest request) {
//
//		String token = request.getHeader(serviceAuthConfig.getTokenHeader());
//        if (StringUtils.isEmpty(token)) {
//            token = request.getParameter(serviceAuthConfig.getTokenHeader());
//        }
//        return token;
//	}
//}
