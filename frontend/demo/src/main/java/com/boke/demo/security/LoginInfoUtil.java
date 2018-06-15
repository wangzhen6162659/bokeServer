package com.boke.demo.security;

import com.admin.user.dto.UserResDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInfoUtil {

	public final static String login_user_in_session = "l_u_i_s";
	public static void addLoginUser(UserResDTO ssLoginUser, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute(login_user_in_session, ssLoginUser);
	}

	public static UserResDTO getLoginUser(HttpServletRequest request) {
		return (UserResDTO) request.getSession().getAttribute(login_user_in_session);
	}
	/**
	 * 实现自动登录，在未登录的情况下面实现登录    在已经登录的时候，就不管了
	 * @param request
	 * @return
	 */
	public static UserResDTO getAutoLoginUser(HttpServletRequest request) {

		if(getLoginUser(request) != null) {
			return (UserResDTO) request.getSession().getAttribute(login_user_in_session);
		}
//		GxqptWebappConfig gxqptWebappConfig = SpringUtil.getBean(GxqptWebappConfig.class);
//		String token = TokenCache.of(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).get().get();
		UserResDTO ssLoginUser = new UserResDTO();
		ssLoginUser.setAccount("admin");
		ssLoginUser.setId(1L);
		ssLoginUser.setName("管理员");
		addLoginUser(ssLoginUser , request, null);
		return ssLoginUser;
	}
}
