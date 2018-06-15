package com.admin.user.repository.base.service.impl;

import com.admin.user.repository.base.service.PublicService;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicServiceImpl implements PublicService{
    @Autowired
    DozerUtils dozerUtils;

    @Override
    public Object dozerTrans(Class clazz,Object object) {
        return null;
    }
}
