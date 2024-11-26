package com.pratik.mqttapp.mqttapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pratik.mqttapp.mqttapp.service.MqttService;

@Controller
public class MqttController {

    private MqttService mqttService;
    
    @Autowired
    public MqttController(MqttService mqttService) {
    	this.mqttService = mqttService;
    }

    @GetMapping("/")
    public String home() {
        return "mqttHome";
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String topic, @RequestParam String message, Model model) {
        try {
            mqttService.publish(topic, message);
            model.addAttribute("status", "Message published successfully!");
        } catch (Exception e) {
            model.addAttribute("status", "Error: " + e.getMessage());
        }
        return "mqttHome";
    }
}

