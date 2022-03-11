package com.product.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.service.ClientMessageService;
import com.product.service.ClientMessageServiceImplementation;

/**
 * Servlet implementation class ClienMessageServlet
 */
@WebServlet("/ClienMessageServlet")
public class ClienMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientMessageService clientMessageService;
	
    public ClienMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	clientMessageService = new ClientMessageServiceImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	        buffer.append(System.lineSeparator());
	    }
	    
	    String data = buffer.toString();
	    		
	    System.out.println("What have we received in request: " + data);
	    clientMessageService.insertClientMessage(data);
	}

}
