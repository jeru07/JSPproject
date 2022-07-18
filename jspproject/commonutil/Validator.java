package com.chainsys.jspproject.commonutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean checkNumberForParseInt(String data) throws InvalidInputDataException{
        boolean result = false;
        int len = data.length();
        for (int index = 0; index < len; index++) {
        int asc = (int) data.charAt(index);
        if (asc > 47 && asc < 58)
        result = true;
        else
        throw new InvalidInputDataException("Please enter the Integer");
        }

// if data is invalid throw new InvalidInputDataException ("The value in String
        // must contain only numbers")
        return result;
    }

    	public static boolean CheckNumberForGreaterThanZero(int data) throws InvalidInputDataException {
    		if (data < 0) {
    			throw new InvalidInputDataException(" number must be greater than zero");
    		}
			return false;
    	

    	}

    	public static void checklengthOfString(String data) throws InvalidInputDataException {

    		int len = data.length();
    		if (len < 15 && len > 3)
    			;
    		else
    			throw new InvalidInputDataException("length does meet required length");

    	}

    	public static void checkStringOnly(String data) throws InvalidInputDataException {
    		boolean result = false;
    		String pattern = "^[a-zA-Z]+(\\\\s[a-zA-Z]+)?$";
    		Pattern patt = Pattern.compile(pattern);
    		Matcher match = patt.matcher(data);
    		result = match.matches();
    		if (!result)
    			throw new InvalidInputDataException("please enter character only");
    	}

    	public static void CheckNumberForGreaterThanZero(float data) throws InvalidInputDataException {
    		if (data < 0)
    			throw new InvalidInputDataException("please enter value greater than zero");

    	}

    	public static void checkEmail(String data) throws InvalidInputDataException {
    		boolean result = false;
    		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
    				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    		Pattern patt = Pattern.compile(regexPattern);
    		Matcher match = patt.matcher(data);
    		result = match.matches();
    		if (!result)
    			throw new InvalidInputDataException("your email does not meet required length or complex");
    	}

    	public static void checkJobId(String data) throws InvalidInputDataException {
    		boolean result = false;
    		String pattern = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    		Pattern patt = Pattern.compile(pattern);
    		Matcher match = patt.matcher(data);
    		result = match.matches();
    		if (!result)
    			throw new InvalidInputDataException("wrong pattern for job id");
    	}
    

   
    public static boolean checkStringForGreaterThanZero1(float fees) throws InvalidInputDataException{
        boolean result = false;
        
        if(fees >0){
            return true;
        }
        //if data is invalid throw new InvalidInputDataException("The  value must be greater than zero"); 
        return result;
        
    }
    public static boolean checkDateFormat(String data) throws InvalidInputDataException {
        boolean result = false;
        int len = data.length();
        String[] data1 = data.split("/");
        //for (int i = 0; i < data1.length; i++)
            //System.out.println(data1[i]);
        int date = Integer.parseInt(data1[0]);
        int mon = Integer.parseInt(data1[1]);
        int yrs = Integer.parseInt(data1[2]);
        for (int index = 0; index < len; index++) {
            int asc = (int) data.charAt(index);
            if ((asc < 46) || (asc > 58))// || (asc != 47))
                throw new InvalidInputDataException("Enter date in correct format ");
        }

        // TODO
        // date before 1/1/1985

        if (yrs > 1984 && yrs <= 2022) {
            if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)
                if (date > 0 && date <= 31)
                    result = true;
                else
                    throw new InvalidInputDataException("enter valid date");
            else if (mon == 2 || mon == 4 || mon == 6 || mon == 9 || mon == 11)
                if (date > 0 && date <= 30)
                    result = true;
                else
                    throw new InvalidInputDataException("enter valid date");
            else
                throw new InvalidInputDataException("enter valid month");
        } else
            throw new InvalidInputDataException("enter valid year");
//        if(date.before(calender.getI);

        return result;

    }
    }
    