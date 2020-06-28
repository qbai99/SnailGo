package com.demo.springboot.helloworld.common.domain;

import java.util.logging.Logger;

public class LogerUtil {
    private static Logger logger = Logger.getLogger(String.valueOf(LogerUtil.class));

    public static void  log(Class<?> clazz, String str, Exception e){
        logger.info(clazz.getSimpleName()+":"+str+","+e);
    }
}
