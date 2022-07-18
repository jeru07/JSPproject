package com.chainsys.jspproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.jspproject.commonutil.ExceptionManager;
import com.chainsys.jspproject.commonutil.InvalidInputDataException;
import com.chainsys.jspproject.commonutil.Validator;
import com.chainsys.jspproject.dao.EmployeeDao;
import com.chainsys.jspproject.pojo.Employee;


/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String source="DeleteEmployee";
	String message="<h1>Error while "+source+"</h1>";
	PrintWriter out = response.getWriter();
	DeleteEmployee newemp = null;
	int result = 0;
	String empid = null;
	try {
	    empid=request.getParameter("id");
		Validator.checkNumberForParseInt(empid);
	}
	catch(InvalidInputDataException err) {
		message +=" Error in Employee Id : </p>";
		String errorPage=ExceptionManager.handleException(err, source, message);
		out.print(errorPage);
		return;
	}
	int emp_id=Integer.parseInt(empid);
	result = EmployeeDao.deleteEmployee(emp_id);
    request.setAttribute("deleteemp", result);
    RequestDispatcher rd = request.getRequestDispatcher("/deleteemp.jsp");
    rd.forward(request, response);
	
}}
