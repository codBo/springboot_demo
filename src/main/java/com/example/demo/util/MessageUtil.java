package com.example.demo.util;

import com.example.demo.dto.ResponseMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageUtil {

    private static volatile ResponseMessage<String> successMessage;

    public static ResponseMessage getSuccessMessage() {

        if (successMessage == null) {
            synchronized (MessageUtil.class) {
                successMessage = new ResponseMessage<>();
                successMessage.setData("");
                successMessage.setMessage("成功");
                successMessage.setCode(200);
            }
        }
        return successMessage;
    }

    public static <T> ResponseMessage getSuccessMessage(T data) {

        ResponseMessage<T> successMessage = new ResponseMessage<>();
        successMessage.setCode(200);
        successMessage.setMessage("成功");
        successMessage.setData(data);
        return successMessage;
    }

//    private volatile static int count = 0;
    private  static int count = 0;

    public static Integer getCount() throws InterruptedException {

//        int localValue = count;
//        ++ count;
//        Thread.sleep(10000);
//        return count;
        int local_value = count;
        while ( local_value < 5){
            if( local_value!= count){
                log.info("Got Change for count : {}", count);
                local_value= count;
            }
        }
        return null;
    }
    public static Integer getCountV2() {

//        return+ ++ count;
        int local_value = count;
        while (count <5){
            log.info("Incrementing count to {}", local_value+1);
            count = ++local_value;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
        return null;
    }
}
