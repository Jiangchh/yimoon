package com.yimoom.pplay.exception;

/**
 * Service层异常
 *
 * @version 1.0
 * @author jiangchenghua 2018-10-24
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = 6058294324031642376L;

    public ServiceException() {}

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }

}
