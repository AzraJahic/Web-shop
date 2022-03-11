package com.product.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.service.ProductService;
import com.product.service.ProductServiceImplementation;

/**
 * Servlet implementation class AllProductsServlet
 */
@WebServlet("/AllProductsServlet")
public class AllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService; 
       
    public AllProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	productService = new ProductServiceImplementation();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean onlyNewProducts = request.getParameter("onlyNewProducts") != null ?  request.getParameter("onlyNewProducts").equals("true") : false;
		System.out.println("AllProductsServlet :: doGet :: " + request.getParameter("onlyNewProducts"));
		String jsonProductsList = productService.getAllProducts(onlyNewProducts);
		
		response.setContentType("application/json");
		response.getWriter().write(jsonProductsList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
