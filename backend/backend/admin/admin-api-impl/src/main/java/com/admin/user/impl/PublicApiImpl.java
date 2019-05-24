package com.admin.user.impl;

import com.admin.user.api.PublicApi;
import com.admin.user.dto.publicapi.PublicBingDayPicDTO;
import com.admin.user.repository.base.service.PublicService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@Api(value = "PublicApi", description = "外部Api管理")
@RestController
@RequestMapping("public")
public class PublicApiImpl implements PublicApi {
//    // 文件上传路径
//    @Value("${boke.fileuploadPath}")
//    private String fileuploadPath;
//
//    // 文件读取路径
//    @Value("${boke.httpPath}")
//    private String httpPath;

    @Autowired
    PublicService publicService;

    private static final String appId = "wx02e940e83a91dcc9";
    private static final String secret = "027cfdedb223f01f54b9b88c3f0033c4";
    private static final String grant_type = "client_credential";

    @Override
    @IgnoreToken
    @RequestMapping(value = "/getBingDayPic", method = RequestMethod.GET)
    public Object getBingDayPic() throws MalformedURLException, ParseException {

        PublicBingDayPicDTO dto = new PublicBingDayPicDTO();
        URL url = new URL("http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1");
        List<Map<String, Object>> list = (List<Map<String, Object>>) getUrlWithMap(url).get("images");

        Map<String, Object> json = list.get(0);

        dto.setUrl(json.get("url").toString());
//        url = new URL("https://cn.bing.com/cnhp/coverstory");
//        json = getUrlWithObject(url);
//        dto.setTitle(json.get("title").toString());
//        dto.setDesc(json.get("para1").toString());

//        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
//        dto.setCreateTime(sdf.parse(json.get("date").toString()));
        return dto;
    }

//    @Override
//    @RequestMapping(value = "/getBrushTicket", method = RequestMethod.GET)
//    public Object getBrushTicket() throws MalformedURLException {
////        int num = 0;
////        for (int i=1;i<100000;i++){
////            URL url = new URL("http://47.93.242.136:8686/index.php?m=toupiao&c=index&a=add_form&id="+i);
////            Map<String,String>map = new HashMap<>();
////            map.put("X-Forwarded-For", IpUtil.getRandomIp());
////            String ret = getRet(url,map);
////            if (ret.equals("0"))num++;
////        }
//        return 0;
//    }
    @Override
    @IgnoreToken
    @RequestMapping(value = "getWxConfig",method = RequestMethod.GET)
    public Object getWxConfig(@RequestParam(value = "url") String url) throws MalformedURLException {
        //获得access_token
        StringBuffer urlAccStr = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=");
        urlAccStr.append(grant_type);
        urlAccStr.append("&appid=");
        urlAccStr.append(appId);
        urlAccStr.append("&secret=");
        urlAccStr.append(secret);
        URL urlAccUrl = new URL(urlAccStr.toString());
        String accessToken = getUrlWithObject(urlAccUrl,"access_token");

        //获取jsapi_ticket
        StringBuffer urlJsapiStr = new StringBuffer("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=");
        urlJsapiStr.append(accessToken);
        urlJsapiStr.append("&type=jsapi");
        URL urlJsapiUrl = new URL(urlJsapiStr.toString());
        String jsapiTicket = getUrlWithObject(urlJsapiUrl,"ticket");

        Map<String, String> ret = sign(jsapiTicket, url);
        ret.put("appId", appId);
        ret.put("jsApiList", appId);

        return ret;
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

    private String getUrlWithObject(URL murl, String param) {
        String ret = getRet(murl);
        Map<String, Object> map = null;
        if (!"".equals(ret)) {
            map = JSONUtils.parse(ret, HashMap.class);
        }
        return (String) map.get(param);
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

    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
