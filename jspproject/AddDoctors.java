package com.chainsys.jspproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.jspproject.commonutil.ExceptionManager;
import com.chainsys.jspproject.commonutil.InvalidInputDataException;
import com.chainsys.jspproject.commonutil.Validator;
import com.chainsys.jspproject.dao.DoctorDao;
import com.chainsys.jspproject.pojo.Doctor;




/**
 * Servlet implementation class Doctor
 */
public class AddDoctors extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctors() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		List<Doctor> allDoctor = DoctorDao.getAllDoctor();
		Iterator<Doctor> drIterator = allDoctor.iterator();
		while (drIterator.hasNext()) {
			Doctor dr = drIterator.next();
			out.println("</hr>");
			out.println(dr.getDOC_ID() + " " + dr.getDOC_NAME() + " " + dr.getDOB() + " " + dr.getSPECIALITY()
					+ " " + dr.getCITY() + " " + dr.getPHONE_NO() + " " + dr.getFEES());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source="AddNewDoctor";
	    String message="<h1>Error while "+source+"</h1>";
		PrintWriter out = response.getWriter();
		if(request.getParameter("click").equals("Add_doc")) {
		int result=0;
		Doctor newdoc=null;
		try {
			 newdoc = new Doctor();
			System.out.println("Enter Doctor_Id :");
			String id = request.getParameter("id");
			
			   try 
			   {
		            Validator.checkNumberForParseInt(id);
		        }catch(InvalidInputDataException err) 
			   {

					message +=" Error in Doctor Id : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
		        }
			   int Doc_id=Integer.parseInt(id);
			   try 
			   {
		            Validator.CheckNumberForGreaterThanZero(Doc_id);
		        }catch(InvalidInputDataException err) 
			   {

					message +=" Error in Doctor Id : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
		        }
			   newdoc.setDOC_ID(Doc_id);
			   
			System.out.println("Enter Name :");
			String name=request.getParameter("name");
			 try {
		            Validator.checkStringOnly(name);
		        }catch(InvalidInputDataException err) {

					message +=" Error in Doctor Name : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
		        }
			 newdoc.setDOC_NAME(name);		
			 
				SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
				String doc_dob = request.getParameter("dob");
				try {
					Validator.checkDateFormat(doc_dob);
				} catch (InvalidInputDataException err) {
					message +=" Error in Employee Hire date : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
				}
				Date newDate = null;
				newDate = hire_dateFormate.parse(doc_dob);
				newdoc.setDOB(newDate);
				
			System.out.println("Enter Speciality :");
			String spe=request.getParameter("speciality");
			try {
	            Validator.checkStringOnly(spe);
	        }catch(InvalidInputDataException err) {
	        	message +=" Error in Doctor Speciality : </p>";
				String errorPage=ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
	        }
		 newdoc.setSPECIALITY(spe);
			System.out.println("Enter City :");
			String city=request.getParameter("city");
			try {
	            Validator.checkStringOnly(city);
	        }catch(InvalidInputDataException err) {
	        	message +=" Error in Doctor City : </p>";
				String errorPage=ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
	        }
		     newdoc.setCITY(city);
			System.out.println("Enter Phone_Number");
		    String num=request.getParameter("num");
		    
			System.out.println("Enter Standard_Fees :");
			String fees = request.getParameter("fees");
			try {
				Validator.checkNumberForParseInt(fees);
			} catch (InvalidInputDataException err) {
				message +=" Error in Doctor Fees : </p>";
				String errorPage=ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
			}
			float fee=Float.parseFloat(fees);
			newdoc.setFEES(fee);
			
			 result = DoctorDao.insertDoctor(newdoc);
			  out.println(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<div> Add New Doctor:"+result+"</div>");
		}
		else if(request.getParameter("click").equals("update_doc")) {
			doPut(request, response);
			} else if(request.getParameter("click").equals("delete_doc")) {
				doDelete(request, response);
		
			}
		}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source="UpdateNewDoctor";
	    String message="<h1>Error while "+source+"</h1>";
		PrintWriter out = response.getWriter();
		int result=0;
		Doctor newdoc=null;
		try {
			 newdoc = new Doctor();
			System.out.println("Enter Doctor_Id :");
			String id = request.getParameter("id");
			
			   try 
			   {
		            Validator.checkNumberForParseInt(id);
		        }catch(InvalidInputDataException err) 
			   {
		        	message +=" Error in Doctor Id : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
		        }
			   int Doc_id=Integer.parseInt(id);
			   try 
			   {
		            Validator.CheckNumberForGreaterThanZero(Doc_id);
		        }catch(InvalidInputDataException err) 
			   {
		        	message +=" Error in Doctor Id : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
		        }
			   newdoc.setDOC_ID(Doc_id);
			System.out.println("Enter Name :");
			String name=request.getParameter("name");
			 try {
		            Validator.checkStringOnly(name);
		        }catch(InvalidInputDataException err) {
		        	message +=" Error in Doctor Name : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
		        }
			 newdoc.setDOC_NAME(name);		
			 
				SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
				String doc_dob = request.getParameter("dob");

				try {
					Validator.checkDateFormat(doc_dob);
				} catch (InvalidInputDataException err) {
					message +=" Error in Employee Hire date : </p>";
					String errorPage=ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
				}
				Date newDate = null;
				newDate = hire_dateFormate.parse(doc_dob);
				newdoc.setDOB(newDate);
				
				
			System.out.println("Enter Speciality :");
			String spe=request.getParameter("speciality");
			try {
	            Validator.checkStringOnly(spe);
	        }catch(InvalidInputDataException err) {
	        	message +=" Error in Doctor Speciality : </p>";
				String errorPage=ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
	        }
		 newdoc.setSPECIALITY(spe);
			System.out.println("Enter City :");
			String city=request.getParameter("city");
			try {
	            Validator.checkStringOnly(city);
	        }catch(InvalidInputDataException err) {
	        	message +=" Error in Doctor City : </p>";
				String errorPage=ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
	        }
		     newdoc.setCITY(city);
			System.out.println("Enter Phone_Number");
		    String num=request.getParameter("num");
		    
			System.out.println("Enter Standard_Fees :");
			String fees = request.getParameter("fees");
			try {
				Validator.checkNumberForParseInt(fees);
			} catch (InvalidInputDataException err) {
				message +=" Error in Doctor Fees : </p>";
				String errorPage=ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
			}
			float fee=Float.parseFloat(fees);
			newdoc.setFEES(fee);
			
			 result = DoctorDao.updateDoctor(newdoc);
			  out.println(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<div> Update New Doctor:"+result+"</div>");
		}


protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String source="DeleteDoctor";
    String message="<h1>Error while "+source+"</h1>";
	PrintWriter out = response.getWriter();
try {
	Doctor newdoc = new Doctor();
	System.out.println("Enter Doctor_Id :");
	String id = request.getParameter("id");
	try {
		Validator.checkNumberForParseInt(id);
	} catch (InvalidInputDataException err) {
		message +=" Error in Doctor Id : </p>";
		String errorPage=ExceptionManager.handleException(err, source, message);
		out.print(errorPage);
		return;
	}
	int docId = Integer.parseInt(id);
	
	try {
		Validator.CheckNumberForGreaterThanZero(docId);
	} catch (InvalidInputDataException err) {
		
	}
	newdoc.setDOC_ID(docId);
	Doctor doc = DoctorDao.getDoctorById(docId);

	if (doc == null) {
		System.out.println("Doctor Doesn't Exist For Id " + docId);
		return;
	}
	newdoc.setDOC_ID(docId);
	int result = DoctorDao.deleteDoctor(Integer.parseInt(id));
	out.println("row deleted"+result);
}
catch(Exception err)
{
	err.printStackTrace();
}
}
}
	
	














