package com.declaration.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();  // Invalidate the session to log out the user
        redirectAttributes.addFlashAttribute("message", "You have been logged out successfully.");
        return "redirect:/login";  // Redirect to the login page after logout
    }
}
