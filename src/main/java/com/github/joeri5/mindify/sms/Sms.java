package com.github.joeri5.mindify.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sms {

    private String recipient;

    private String sender;

    private String messageBody;

}
