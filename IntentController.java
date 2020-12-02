package com.voice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
/*import com.voice.jerry.dto.PNRStatusdto;
import com.voice.jerry.dto.PNRStatustoDisplaydto;
import com.voice.jerry.service.RailwayService;
import com.voice.jerry.config.RailwayConfig;
import com.voice.jerry.config.RailwayConfigHindi;*/
@Component

public class IntentController extends DialogflowApp {

		

		
		
			private static final Logger LOGGER = LoggerFactory.getLogger(GoogleActionMainController.class);
			@ForIntent("OrderStatus")
			public ActionResponse orderStatus(ActionRequest request) {
				ResponseBuilder rb = getResponseBuilder(request);
				rb.getConversationData().put("firstNum", request.getParameter("orderId"));
				double orderId1 = (Double) request.getParameter("orderId");
			String od = Double.toString(orderId1);
			String finalString = od.substring(0,od.indexOf("."));
				String responseForOrderStatus = "The payment of order ID " +finalString +" "
				+ "has been done using SBI card and it has been shipped to your address. Is there anything else I can help you with?";
			
		//SimpleResponse ssmlResponse = new SimpleResponse().setSsml(responseForOrderStatus);
		rb.add(responseForOrderStatus);
		return rb.build();
				
		}
			
			@ForIntent("OrderFeedback")
			public ActionResponse orderFeedback(ActionRequest request) {
				ResponseBuilder rb = getResponseBuilder(request);
				String responseForOrderStatus = "<speak>Please let me know, what would you like to post.</speak>";
			
		SimpleResponse ssmlResponse = new SimpleResponse().setSsml(responseForOrderStatus);
		rb.add(ssmlResponse);
		return rb.build();
		}
			 
			@ForIntent("CancelOrder")
			public ActionResponse cancelOrder(ActionRequest request) {
				ResponseBuilder rb = getResponseBuilder(request);
				rb.getConversationData().put("firstNum", request.getParameter("orderId"));
				double orderId1 = (Double) request.getParameter("orderId");
				String od = Double.toString(orderId1);
				String finalString = od.substring(0,od.indexOf("."));
				String responseForOrderStatus = "<speak>Your order " +finalString+ " "+"has been cancelled. For similar items you can visit our website, Happy shopping!.</speak>";
			
		SimpleResponse ssmlResponse = new SimpleResponse().setSsml(responseForOrderStatus);
		rb.add(ssmlResponse);
		return rb.build();
		}
			
			@ForIntent("Exchange")
			public ActionResponse exchange(ActionRequest request) {
				ResponseBuilder rb = getResponseBuilder(request);
				rb.getConversationData().put("firstNum", request.getParameter("orderId"));
				double orderId1 = (Double) request.getParameter("orderId");
				String od = Double.toString(orderId1);
				String finalString = od.substring(0,od.indexOf("."));
				String responseForOrderStatus = "<speak>Sure, The product is available in yellow, red and violet color. Which one should I order for you?</speak>";
			
		SimpleResponse ssmlResponse = new SimpleResponse().setSsml(responseForOrderStatus);
		rb.add(ssmlResponse);
		return rb.build();
		}
			
			@ForIntent("ExchangeCustomize")
			public ActionResponse exchangeCustomize(ActionRequest request) {
				ResponseBuilder rb = getResponseBuilder(request);
				rb.getConversationData().put("firstNum", request.getParameter("color"));
				String color1 = (String) request.getParameter("color");
				String  responseForOrderStatus = "<speak>I have booked the same product in </speak> " +color1 +" "+ "<speak> color. You can shop more by visiting our website. Have a nice day!</speak>";
			
		SimpleResponse ssmlResponse = new SimpleResponse().setSsml(responseForOrderStatus);
		rb.add(ssmlResponse);
		return rb.build();
		}
			
			
		}



	