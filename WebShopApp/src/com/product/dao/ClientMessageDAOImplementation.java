package com.product.dao;

import java.sql.*;

import com.product.model.ClientMessage;

public class ClientMessageDAOImplementation implements ClientMessageDAO{
	
	private Connection conn;

	@Override
	public void insertClientMessageToDB(ClientMessage clientMessage) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web-shop","hbstudent","hbstudent");
			//Insert data to Student table from student object:
			String query = "INSERT INTO client_msg(clientName, clientLastName, clientPhoneNumber, clientEmail, clientMsg) VALUES(?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(query);
			ps.setString(1, clientMessage.getClientName());
			ps.setString(2, clientMessage.getClientLastName());
			ps.setString(3, clientMessage.getClientPhoneNumber());
			ps.setString(4, clientMessage.getClientEmail());
			ps.setString(5, clientMessage.getClientMsg());
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		}
		
	}

}
