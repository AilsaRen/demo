package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * <p>Title: GlobalExceptionHandler</p >
 * <p>Description: </p >
 * <p>Company: www.h-visions.com</p >
 * <p>create date: 2022/7/24</p >
 *
 * @author :xtren
 * @version :1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BindException.class})
    public ResponseEntity<ResultVo> exceptionListener(org.springframework.validation.BindException e) {
        return this.handlerNotValidException(e);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultVo> handlerArgumentNotValidException(MethodArgumentNotValidException exception) {
        return handlerNotValidException(exception);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResultVo> handlerArgumentNotValidException(SQLIntegrityConstraintViolationException exception) {
        return handlerNotValidException(exception);
    }


    public ResponseEntity<ResultVo> handlerNotValidException(Exception e) {
        log.debug("begin resolve argument exception");
        BindingResult result;
        ResultVo<Object> objectResultVo = new ResultVo<>();

        if (e instanceof SQLIntegrityConstraintViolationException) {
            SQLIntegrityConstraintViolationException sqlException = (SQLIntegrityConstraintViolationException) e;
            String message = sqlException.getMessage();
            objectResultVo.setMessage(message);
            objectResultVo.setCode(500);
            return ResponseEntity.status(500).body(objectResultVo);
        }

        if (e instanceof BindException) {
            BindException exception = (BindException) e;
            result = exception.getBindingResult();
        } else {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            result = exception.getBindingResult();
        }

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (int i = 0; i < fieldErrors.size(); i++) {
                objectResultVo.setMessage(String.format("%s%s",fieldErrors.get(i).getField(),fieldErrors.get(i).getDefaultMessage()));
                objectResultVo.setCode(500);
                break;
            }
        }
       return ResponseEntity.status(500).body(objectResultVo);
    }


}