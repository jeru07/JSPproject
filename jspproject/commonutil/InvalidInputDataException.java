package com.chainsys.jspproject.commonutil;

import com.chainsys.jspproject.commonutil.Validator;
public class InvalidInputDataException extends Exception
{ 
    public InvalidInputDataException()
    {
    	super("The Input Data is not valid ");
    }
    public InvalidInputDataException(String message) {
    	super(message);
    }
}



