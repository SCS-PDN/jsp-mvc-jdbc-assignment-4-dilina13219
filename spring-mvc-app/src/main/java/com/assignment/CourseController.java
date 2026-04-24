package com.assignment; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   
    @GetMapping("/courses")
    public String showCourses(Model model) {
        String sql = "SELECT * FROM courses";
        List<Map<String, Object>> courseList = jdbcTemplate.queryForList(sql);
        
      
        model.addAttribute("courses", courseList); 
        return "courses";
    }

    
    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable("courseId") int courseId) {
        
      
        int studentId = 1; 

        try {
          
            String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
            jdbcTemplate.update(sql, studentId, courseId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        

        return "success"; 
    }
}