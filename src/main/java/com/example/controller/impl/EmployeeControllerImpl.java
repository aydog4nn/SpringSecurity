package com.example.controller.impl;

import com.example.controller.IEmployeeController;
import com.example.dto.DtoEmployee;
import com.example.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping(path = "/list/{id}")
    @Override
    public DtoEmployee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }
}
