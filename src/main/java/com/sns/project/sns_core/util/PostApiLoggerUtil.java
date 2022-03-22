package com.sns.project.sns_core.util;

import org.slf4j.Logger;

import java.sql.Timestamp;

public class PostApiLoggerUtil {
    /**
     *  log methods info
     */
    public static void logMethod(Logger logger, String userName,String serviceName, String methodName  ,Timestamp startTime, Timestamp endTime){
        //difference in miliseconds
        double  timeTaken =  ( endTime.getTime() - startTime.getTime() ) / 1000.0;
        String logInfo = " Username : " + userName + " | " +
                " User-Agent: " + //TODO: NEED OT ADD USER AGENT
                " ServiceName : " + serviceName + " | " +
                " MethodName : "+ methodName + " | " +
                " Call Received Time: " + startTime + " | " +
                " ResponseTime in milisecond : " + timeTaken;
        logger.info(logInfo);
    }
}
