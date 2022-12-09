package com.github.joeri5.mindify.sms;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sms")
@AllArgsConstructor
public class SmsController {

    @Autowired
    private SmsConfig smsConfig;

    @RequestMapping("/send")
    public String sendSms(@RequestBody Sms sms) {
        String status = smsConfig.sendSms(sms);

        return status;
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
