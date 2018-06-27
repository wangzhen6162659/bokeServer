package com.file.user.util.ueditor.upload;

import com.file.user.util.ueditor.PathFormat;
import com.file.user.util.ueditor.define.BaseState;
import com.file.user.util.ueditor.define.FileType;
import com.file.user.util.ueditor.define.State;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.file.user.util.ueditor.define.AppInfo.MAX_SIZE;

public final class Base64Uploader {
    static Logger logger = LoggerFactory.getLogger(Base64Uploader.class);
	public static State save(String content, Map<String, Object> conf) {
		
		byte[] data = decode(content);

		long maxSize = ((Long) conf.get("maxSize")).longValue();

		if (!validSize(data, maxSize)) {
			return new BaseState(false, MAX_SIZE);
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"),
				(String) conf.get("filename"));
		String localSavePathPrefix = PathFormat.parse((String) conf.get("localSavePathPrefix"),
                (String) conf.get("filename"));
		savePath = savePath + suffix;
		localSavePathPrefix = localSavePathPrefix + suffix;
		String physicalPath = localSavePathPrefix;
		logger.info("Base64Uploader physicalPath:{},savePath:{}",localSavePathPrefix,savePath);
		State storageState = StorageManager.saveBinaryFile(data, physicalPath);

		if (storageState.isSuccess()) {
			storageState.putInfo("url", PathFormat.format(savePath));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
		}

		return storageState;
	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(StringUtils.getBytesUtf8(content));
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}
	
}