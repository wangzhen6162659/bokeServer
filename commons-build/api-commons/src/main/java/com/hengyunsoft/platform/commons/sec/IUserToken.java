package com.hengyunsoft.platform.commons.sec;

import java.util.List;

public interface IUserToken {

	
	/**
	 * 加密     通过应用级别的token + 用户信息  得到用户级别的token
	 * @param appToken  应用级的toekn
	 * @param id 用户id  不允许为null
	 * @param name  用户名字   不允许为null
	 * @param extJson 扩展json串，用于加入更多的用户信息  允许为null
	 * @return 用户级别的token
	 */
	public String encoder(String appToken, String userId, String userName, String extJson);
	
	
	/**
	 * 反解密        通过用户级别的token获取到加密前的数据
	 * @param userToken
	 * @return 顺序是： appToken  id   name   extJson
	 * 即使你在加入的时候 extjson是null   返回的是"" 空字符串
	 * 所以返回的集合大小为4     若集合大小不等于4； 将会返回null
	 */
	public List<String> uncoder(String userToken);
	
	public String getAppToken(List<String> uncoderInfo);
	
	public String getUserId(List<String> uncoderInfo);
	
	public String getUserName(List<String> uncoderInfo);
	
	public String getExtJson(List<String> uncoderInfo);
}
