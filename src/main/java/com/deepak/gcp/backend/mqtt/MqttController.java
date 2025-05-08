package com.deepak.gcp.backend.mqtt;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    private final MqttPublisher mqttPublisher;

    public MqttController(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
    }

    @GetMapping("/send-hi")
    public String sendHi() {
        mqttPublisher.sendHi();
        return "Sent: Hi";
    }

    @GetMapping("/send")
    public String send(@RequestParam String message){
        mqttPublisher.sendString(message);
        return "you message has been deliverd";
    }
}
