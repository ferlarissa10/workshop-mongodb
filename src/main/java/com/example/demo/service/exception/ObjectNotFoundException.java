package com.example.demo.service.exception;

/**
 * Created by Fernanda on 11/06/2018.
 */
public class ObjectNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
