

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter out=response.getWriter();
			String accStr=request.getParameter("t1");
			int accno=Integer.parseInt(accStr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/athadb1","root","W7301@jqir#");
			
			PreparedStatement pst=con.prepareStatement("Select * from account where Accno=?");
			
			pst.setInt(1,accno);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				request.setAttribute("accno", accno);
                request.setAttribute("accnm", rs.getString(2));  
                request.setAttribute("balance", rs.getInt(3));
                
                RequestDispatcher rd=request.getRequestDispatcher("./DisplayBalanceServlet");
                rd.forward(request, response);
			}
			else
			{
				out.println("Invalid Account Number!!!!");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			//con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
