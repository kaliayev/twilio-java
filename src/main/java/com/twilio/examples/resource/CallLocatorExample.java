package com.twilio.examples.resource;

import com.twilio.sdk.Twilio;
import com.twilio.sdk.locators.CallLocator;
import com.twilio.sdk.resources.Call;

public class CallLocatorExample {

    public static void main(String[] args) {
        Twilio.init("AC123", "AUTH TOKEN");

        String callSid = "CAa4df5c8404a784212bc026f48c497219";

        Call call = new CallLocator().buildBySid(callSid);

        System.out.println(call.getSid());
        System.out.println(call.getTo());

    }
}
