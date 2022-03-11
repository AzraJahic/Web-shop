package com.product.service;

import com.product.dao.ClientMessageDAO;
import com.product.dao.ClientMessageDAOImplementation;
import com.product.model.ClientMessage;

public class ClientMessageServiceImplementation implements ClientMessageService{

	@Override
	public void insertClientMessage(String jsonClientMessage) {
		
		ClientMessageDAO clientMessageDAO = new ClientMessageDAOImplementation();
		
		ClientMessage clientMessage = JsonUtil.convertJSONtoClientMessage(jsonClientMessage);
		clientMessageDAO.insertClientMessageToDB(clientMessage);
		
	}

}
