package com.admin.user.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.MalformedURLException;
import java.text.ParseException;

public interface PublicApi {
    @RequestMapping(value = "/public/getBingDayPic",method = RequestMethod.GET)
    Object getBingDayPic() throws MalformedURLException, ParseException;

    @RequestMapping(value = "/public/getBrushTicket",method = RequestMethod.GET)
    Object getBrushTicket() throws MalformedURLException;
}
