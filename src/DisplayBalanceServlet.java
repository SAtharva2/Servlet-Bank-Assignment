

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayBalanceServlet")
public class DisplayBalanceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String accno=(String) request.getAttribute("accno");
		String accnm=(String) request.getAttribute("accnm");
		String balance=(String) request.getAttribute("balance");
		
		out.println("<html><body>");
		out.println("<h2>Welcome "+accnm+ " !</h2>");
		out.println("<p>Account No: "+accno +" </p>");
		out.println("<p>Balance "+balance +" </p>");
		
		out.println("<a href='CheckBalanceServlet'>Check Balance</a> <br>");
		out.println("<a href='Logout'>LogOut</a> <br>");
		out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
