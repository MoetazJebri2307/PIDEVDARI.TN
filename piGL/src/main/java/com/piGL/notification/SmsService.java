package com.piGL.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component

public class SmsService {

	
	 private final String ACCOUNT_SID ="ACcc0a26093896ccc8da3e40b7f5596d3e";

	    private final String AUTH_TOKEN = "1488f468436c8de31942bfdd44f0df7b";

	    private final String FROM_NUMBER = "+16307934942";

	    public void send(Sms sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
