package com.github.joeri5.mindify.sms;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements SmsConfig {

    @Value("${twilio.username}")
    private String username;

    @Value("${twilio.password}")
    private String password;

    public String sendSms(Sms sms) {
        Twilio.init(username, password);
        Message.creator(new PhoneNumber(sms.getRecipient()), new PhoneNumber("+16086803276"), sms.getMessageBody()).create();

        return "SMS sent";
    }
}
