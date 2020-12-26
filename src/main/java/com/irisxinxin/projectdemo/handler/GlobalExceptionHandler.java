package com.irisxinxin.projectdemo.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irisxinxin.projectdemo.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 做一个全局的异常处理
     * 1. 写一个全局的异常处理，相当于默认的处理机制
     * 2。 针对特定场景的异常， 比如数据校验异常，做定制化的处理机制
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e) {
        //1. 将错误日志记录下来
        logger.error(e.getMessage());
        // 如果是核心业务----有错误的话， 报警
        // 通知相关负责人
        //2. 给用户反馈
        return new ResultBean("success", "当前服务器繁忙，请稍后再试");
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException e) throws JsonProcessingException {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> result = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            log.error("[{}]:[{}]", field, message);
            result.put(field, message);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        // 将对象转换为json
        String json = objectMapper.writeValueAsString(result);
        return new ResultBean("failed", json);
    }
}
