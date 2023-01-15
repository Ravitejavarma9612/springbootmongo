package com.example.demomongo.noobcoderravivarma.Exceptions;

import org.apache.logging.log4j.message.Message;

import java.util.function.Supplier;

public class UserNotFoundException extends Exception  {
    public UserNotFoundException(String message) {
        super(message);
        System.out.println(message.toUpperCase());
    }

}