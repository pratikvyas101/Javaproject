package com.pratik.mqttapp.mqttapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pratik.mqttapp.mqttapp.model.VehicleData;
import com.pratik.mqttapp.mqttapp.service.MqttSubscriberService;

@Controller
public class VehicleController {

    @Autowired
    private MqttSubscriberService mqttSubscriberService;

    @GetMapping("/vehicle")
    public String getVehicleDashboard(Model model) {
        // Initialize with placeholder data
        model.addAttribute("vehicleData", new VehicleData());
        mqttSubscriberService.start(); // Start the MQTT subscriber
        return "vehicle-dashboard"; // Thymeleaf template name
    }
}

