package com.example.demo.util;

import com.example.demo.dto.ResponseMessage;

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

        ResponseMessage<T> successMessage = new ResponseMessage<T>();
        successMessage.setCode(200);
        successMessage.setMessage("成功");
        successMessage.setData(data);
        return successMessage;
    }
}
