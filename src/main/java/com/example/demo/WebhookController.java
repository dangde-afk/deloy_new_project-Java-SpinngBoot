package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
public class WebhookController {

    @GetMapping("/")
    public String home() {
        return "Hello CI/CD";
    }

    @PostMapping("/github-webhook")
    public String webhook(@RequestBody String payload) {
        System.out.println("Received webhook: " + payload);
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "deploy.sh");
            pb.inheritIO();
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Webhook received";
    }
}
