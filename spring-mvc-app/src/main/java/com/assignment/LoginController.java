package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }


    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email, 
                               @RequestParam("password") String password, 
                               Model model) {
        
        String sql = "SELECT COUNT(*) FROM students WHERE email = ? AND password = ?";
        
        @SuppressWarnings("deprecation")
        int count = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);

      
        if (count == 1) {
            return "redirect:/courses"; 
        } else {
            
            model.addAttribute("error", "Invalid Email or Password. Please try again!");
            return "login";
        }
    }

  
 
}