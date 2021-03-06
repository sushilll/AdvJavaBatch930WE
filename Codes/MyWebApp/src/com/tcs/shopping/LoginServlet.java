package com.tcs.shopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("userid");
		String password = request.getParameter("password");
		if(uid.equals(password)){
			// Create a New Session Here
			HttpSession session = request.getSession(true);
			//HttpSession session = request.getSession();
			//if(session.isNew()){
			session.setAttribute("userid", uid);
			//session.setMaxInactiveInterval(60*10);
			//}
			response.setHeader("Expires", "0");

			  // Set standard HTTP/1.1 no-cache headers.
			  response.setHeader("Cache-Control"
					  , "no-store, no-cache, must-revalidate");

			  // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
			  response.addHeader("Cache-Control",
					  "post-check=0, pre-check=0");

			  // Set standard HTTP/1.0 no-cache header.
			  response.setHeader("Pragma",
					  "no-cache");
			String urlWithSessionID = response
					.encodeRedirectURL("welcome");
			response.sendRedirect(urlWithSessionID);  
			//response.sendRedirect("welcome");
			//response.sendRedirect("welcome?uid="+uid); //URL Rewriting
			// sendRedirect - 
			//used to redirect from one page to another page
			// sendRedirect doesn't carry the same request/response
			//out.println("Welcome "+uid);
		}
		else
		{
			out.println("Invalid Userid or Password !");
		}
	}

}
