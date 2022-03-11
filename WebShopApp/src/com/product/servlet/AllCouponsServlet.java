package com.product.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.service.CouponService;
import com.product.service.CouponServiceImplementation;


@WebServlet("/AllCouponsServlet")
public class AllCouponsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CouponService couponService;
       
    public AllCouponsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	couponService = new CouponServiceImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jsonCouponList = couponService.getAllCoupons();
		
		response.setContentType("application/json");
		response.getWriter().write(jsonCouponList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
