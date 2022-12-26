package com.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SomeServiceTest {

    public String testMethod(){
        return "test here and complete";
    }

//    @PostConstruct
//    public void someInit(){
//        System.out.println("Init method called here......");
//    }
//
//    public String testReturnString(){
//        return "test";
//    }
}
