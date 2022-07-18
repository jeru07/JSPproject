package com.chainsys.jspproject.commonutil;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LogManager {
	public static void logException(Exception ex,String source,String exMessage)
	{
		Calendar vCalendar=Calendar.getInstance();
		String logDate=vCalendar.get(vCalendar.DATE)+"_"+(Calendar.MONTH)+1+"_"+(vCalendar.YEAR)+"_";
		String logDateTime=logDate+" "+vCalendar.get(vCalendar.HOUR)+" "+vCalendar.get(Calendar.MINUTE);
		if(source==null)
		{
			source="SOURCE NOT PROVIDED";
		}
		
		if(exMessage==null)
		{
			exMessage="CUSTOM MESSAGE  NOT PROVIDED";
		}
		
		String message="EXCEPTION: "+logDateTime+"MESSAGE: "+ex.getMessage();
		message += "\n SOURCE: "+source+"CUSTOM MESSAGE: "+exMessage;
		String fileName="ExceptionMessages"+logDate+".log";
		writeToFile(fileName,message);
	}
	public static void logException(Exception ex,String source)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH mm");
		Calendar vCalendar = Calendar.getInstance();
		String logDate=vCalendar.get(vCalendar.DATE)+"_"+(Calendar.MONTH)+1+"_"+(vCalendar.YEAR)+"_";
		String logDateTime=logDate+" "+vCalendar.get(vCalendar.HOUR)+" "+vCalendar.get(Calendar.MINUTE);
		if(source==null)
		{
			source="SOURCE NOT PROVIDED";
		}
		String message="EXCEPTION: "+logDateTime+"MESSAGE: "+ex.getMessage();
		message += "\n SOURCE: "+source;
		String fileName="ExceptionMessages"+logDate+".log";
		writeToFile(fileName,message);
	}
	private static void writeToFile(String fileName,String message)
	{
		
		fileName="D://log manager//"+fileName+".txt";
		FileWriter fileWriter=null;
		
		try {
			fileWriter = new FileWriter(fileName,true);
			fileWriter.write(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileWriter.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}	
		
	}
}
