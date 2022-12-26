package com.app.util;

import com.app.SomeServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

@Configurable
public class MyResourceBundle extends ResourceBundle  {

    @Autowired
    private  SomeServiceTest someServiceTest;

    public MyResourceBundle() {
    }

    @Override
    protected Object handleGetObject(String key) {
        if(key.equals("test"))
            return someServiceTest.testMethod();
        return null;
    }

    @Override
    public Enumeration<String> getKeys() {
        return null;
    }

    public void callToPostConstruct(){
//        someServiceTest.someInit();
    }
}
