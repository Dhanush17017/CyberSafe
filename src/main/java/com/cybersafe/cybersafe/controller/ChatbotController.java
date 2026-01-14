package com.cybersafe.cybersafe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChatbotController {

    @GetMapping("/chatbot")
    public String getChatbotReply(@RequestParam String message) {
        message = message.toLowerCase().trim();
        if(message.contains("phishing")) return "Phishing scams are fake emails or websites that trick you. Verify URLs before clicking.";
        else if(message.contains("ransomware")) return "Ransomware encrypts files. Backup regularly and avoid unknown attachments.";
        else if(message.contains("malware")) return "Malware can damage your system. Keep apps updated and scan regularly.";
        else if(message.contains("identity theft")) return "Identity theft happens when someone steals your info. Use strong passwords and 2FA.";
        else if(message.contains("wifi") || message.contains("network")) return "Avoid public Wi-Fi for sensitive logins. Use VPNs and secure networks.";
        else if(message.contains("password")) return "Use strong and unique passwords. Enable two-factor authentication.";
        else if(message.contains("tips") || message.contains("advice")) return "I can provide tips on phishing, ransomware, malware, identity theft, passwords, and secure Wi-Fi.";
        else if(message.contains("hello") || message.contains("hi")) return "Hello! I am your CyberSafe chatbot. Ask me anything about cyber threats!";
        else return "I can help with cyber threats like phishing, ransomware, malware, identity theft, passwords, and secure Wi-Fi. Ask me about any of these!";
    }
}


