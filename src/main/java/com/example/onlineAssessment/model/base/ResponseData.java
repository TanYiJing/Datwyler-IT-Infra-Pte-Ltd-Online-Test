package com.example.onlineAssessment.model.base;
import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ResponseData<T> {
    private int code;
    private String message;
    private T data;
    private String timestamp;

    public ResponseData(int code, String message) {
        Date date = new Date();
        this.code = code;
        this.message = message;
        this.timestamp = String.valueOf(new Timestamp(date.getTime()));

    }

    public ResponseData() {
        Date date = new Date();
        this.timestamp = String.valueOf(new Timestamp(date.getTime()));

    }

    public static <T> ResponseData<T> success(T data) {
        Date date = new Date();
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setCode(0);
        resultData.setMessage("SUCCESS");
        resultData.setData(data);
        resultData.setTimestamp(String.valueOf(new Timestamp(date.getTime())));
        return resultData;
    }

    public static <T> ResponseData<T> fail(ErrorCodeEnum errorCodeEnum) {
        Date date = new Date();
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setCode(errorCodeEnum.getCode());
        resultData.setMessage(errorCodeEnum.getErrorMessage());
        resultData.setTimestamp(String.valueOf(new Timestamp(date.getTime())));
        return resultData;
    }

    public static <T> ResponseData<T> fail(ErrorCodeEnum errorCodeEnum, String message) {
        Date date = new Date();
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setCode(errorCodeEnum.getCode());
        resultData.setMessage(message);
        resultData.setTimestamp(String.valueOf(new Timestamp(date.getTime())));
        return resultData;
    }
}
