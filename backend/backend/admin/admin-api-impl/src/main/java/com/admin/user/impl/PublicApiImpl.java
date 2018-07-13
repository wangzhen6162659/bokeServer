package com.admin.user.impl;

import com.admin.user.api.PublicApi;
import com.admin.user.dto.publicapi.PublicBingDayPicDTO;
import com.admin.user.repository.base.service.PublicService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Api(value = "PublicApi", description = "外部Api管理")
@RestController
@RequestMapping("public")
public class PublicApiImpl implements PublicApi {
    // 文件上传路径
    @Value("${boke.fileuploadPath}")
    private String fileuploadPath;

    // 文件读取路径
    @Value("${boke.httpPath}")
    private String httpPath;

    @Autowired
    PublicService publicService;

    @Override
    @IgnoreToken
    @RequestMapping(value = "/getBingDayPic", method = RequestMethod.GET)
    public Object getBingDayPic() throws MalformedURLException, ParseException {

        PublicBingDayPicDTO dto = new PublicBingDayPicDTO();
        URL url = new URL("http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1");
        List<Map<String, Object>> list = (List<Map<String, Object>>) getUrlWithMap(url).get("images");

        Map<String, Object> json = list.get(0);

        dto.setUrl(json.get("url").toString());
        url = new URL("https://cn.bing.com/cnhp/coverstory");
        json = getUrlWithObject(url);
        dto.setTitle(json.get("title").toString());
        dto.setDesc(json.get("para1").toString());

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
        dto.setCreateTime(sdf.parse(json.get("date").toString()));
        return dto;
    }

    @Override
    @RequestMapping(value = "/getBrushTicket", method = RequestMethod.GET)
    public Object getBrushTicket() throws MalformedURLException {
//        int num = 0;
//        for (int i=1;i<100000;i++){
//            URL url = new URL("http://47.93.242.136:8686/index.php?m=toupiao&c=index&a=add_form&id="+i);
//            Map<String,String>map = new HashMap<>();
//            map.put("X-Forwarded-For", IpUtil.getRandomIp());
//            String ret = getRet(url,map);
//            if (ret.equals("0"))num++;
//        }
        return 0;
    }

    private Map<String, Map<String, String>> getUrlWithMap(URL murl) {
        String ret = getRet(murl);
        Map<String, Map<String, String>> map = null;
        if (!"".equals(ret)) {
            map = JSONUtils.parse(ret, HashMap.class);
        }
        return map;
    }

    private Map<String, Object> getUrlWithObject(URL murl) {
        String ret = getRet(murl);
        Map<String, Object> map = null;
        if (!"".equals(ret)) {
            map = JSONUtils.parse(ret, HashMap.class);
        }
        return map;
    }

    private String getRet(URL url) {
        String ret = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String l = null;
            while ((l = br.readLine()) != null) {
                sb.append(l).append("/n");
            }
            ret = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private String getRet(URL url, Map<String, String> map) {
        String ret = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (map != null) {
                for (String key : map.keySet()) {
                    connection.setRequestProperty(key, map.get(key));
                }
            }
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String l = null;
            while ((l = br.readLine()) != null) {
                sb.append(l);
            }
            ret = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
