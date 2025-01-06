package com.example.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.demospringboot.service.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    // Endpoint to handle the sign-up form submission
    @SuppressWarnings("unlikely-arg-type")
	@PostMapping("/Signup")
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Model model) {
        // Call the signUp service and get the result message
        Boolean resultMessage = signUpService.signUp(username, password);

        // Add the result message to the model to display it in the view
        model.addAttribute("message", resultMessage);

        // If sign-up is successful, show the success page
        if (resultMessage.equals("Sign up successful")) {
            return "Beranda";  // Navigate to signup-success page
        } else {
            return "LogNasabah";   // Navigate to signup-failed page
        }
    }
}
