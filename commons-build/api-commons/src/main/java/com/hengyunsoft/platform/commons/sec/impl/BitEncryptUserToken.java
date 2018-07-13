package com.hengyunsoft.platform.commons.sec.impl;

import com.hengyunsoft.platform.commons.sec.BitEncrypt;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BitEncryptUserToken implements IUserToken {

	private final static  char  separator = '_'; 
	@Override
	public String encoder(String appToken,String id,String name,String extJson) {
		
		List<String> userInfos = new ArrayList<>(3);
		userInfos.add(id);
		userInfos.add(name);
		userInfos.add(extJson == null?"":extJson);
		String text = getText(appToken, userInfos );

		return BitEncrypt.encoding(text);
	}

	@Override
	public List<String> uncoder(String userToken) {
		
		String text = BitEncrypt.unencoding(userToken);
		
		List<String> content = getContent(text);
		if(content.size() != 4) {
			return null;
		}
		return content;
	}

	/**
	 * 在编码加密之前，将要编码的内容进行组织成字符串。
	 * 在组织成字符串的时候，遇到一个问题。怎么进行反解回来呢？
	 * 通常使用某个不可能出现在加密字符串中的字符串来作为分割符。在反解的时候，来作为依据；就可以回到原来的样子
	 * 
	 * 但是这样对调用方不透明，调用方需要避开我们的分隔字符串。
	 * 
	 * 故我采用的方式是：
	 * 
	 * 总共有多少字符串_appToken长度_appToken第一个userInfos字符串长度_第一个userInfos字符串
	 * @param appToken
	 * @param userInfos
	 * @return
	 */
	private static String getText(String appToken, List<String> userInfos) {
		StringBuilder text = new StringBuilder();
		//总共有多少字符串  appToekn是一个     +  userInfos.size
		//后期解密通过这个值来得到数组长度
		text.append(userInfos.size()+1);
		text.append(separator);
		
		//放入appToken信息，
		text.append(appToken.length());
		text.append(separator);
		text.append(appToken);
		
		//放入用户信息
		for (String userInfo : userInfos) {
			text.append(userInfo.length());
			text.append(separator);
			text.append(userInfo);
		}
		return text.toString();
	}

	private List<String> getContent(String text) {
		
		
		//第一个参数是要解析的大小
		Integer size = Integer.valueOf(text.substring(0, text.indexOf(separator)));
		if(size< 1 || size > 50) {
			throw new IllegalArgumentException("错误的userToken");
		}
		List<String> content = new ArrayList<>(size);
		//将appToken和所有的用户信息到解析出来。
		int nextStartIndex = text.indexOf(separator) + 1;
		for (int i = 0; i < size; i++) {
		    
			int curStartIndex = text.indexOf(separator,nextStartIndex);
			Integer length = Integer.valueOf(text.substring(nextStartIndex, curStartIndex));
			nextStartIndex = curStartIndex+length+1;
			content.add(text.substring(curStartIndex+1, nextStartIndex));
		}
		return content;
	}

	@Override
	public String getAppToken(List<String> uncoderInfo) {
		return uncoderInfo.get(0);
	}

	@Override
	public String getUserId(List<String> uncoderInfo) {
		// TODO Auto-generated method stub
		return uncoderInfo.get(1);
	}

	@Override
	public String getUserName(List<String> uncoderInfo) {
		// TODO Auto-generated method stub
		return uncoderInfo.get(2);
	}

	@Override
	public String getExtJson(List<String> uncoderInfo) {
		// TODO Auto-generated method stub
		return uncoderInfo.get(3);
	}
}
