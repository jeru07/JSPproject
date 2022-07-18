package com.chainsys.jspproject.commonutil;

public class ExceptionManager
{
  public static String handleException(Exception err,String source,String message)
  {
	  LogManager.logException(err,source,message);
		message +=" message:"+err.getMessage();
		
		String errorPage=HTMLHelper.getHTMLTemplate("ERROR",message);
		return errorPage;
  }
}
