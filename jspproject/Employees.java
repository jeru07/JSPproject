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
@WebServlet("/Employees")
public class Employees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out=response.getWriter();
		List<Employee> emplist =EmployeeDao.getAllEmployee();
//		Iterator<Employee> empItr=emplist.iterator();
//		while(empItr.hasNext()) {
//			Employee emp=empItr.next();
//			out.println("</p>");
//			out.println("emp id:"+emp.getEmp_id()+"name :"+emp.getFirst_name()+"last name"+emp.getLast_name()+"mail"+emp.getEmail()+"date"+emp.getHire_date()+"salary"+emp.getSalary()+"job id"+emp.getJob_id());
//			
//		}
		request.setAttribute("emplist",emplist );
		RequestDispatcher rd=request.getRequestDispatcher("/viewemployee.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}}
