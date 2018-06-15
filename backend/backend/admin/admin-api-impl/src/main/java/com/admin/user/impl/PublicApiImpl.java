package com.admin.user.impl;

import com.admin.user.api.PublicApi;
import com.admin.user.dto.publicapi.PublicBingDayPicDTO;
import com.admin.user.repository.base.service.PublicService;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    PublicService publicService;

    @Override
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
}
