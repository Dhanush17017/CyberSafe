package com.cybersafe.cybersafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

    @GetMapping("/quiz")
    public String quizPage() {
        return "quiz"; // Thymeleaf will render quiz.html from templates folder
    }
}

