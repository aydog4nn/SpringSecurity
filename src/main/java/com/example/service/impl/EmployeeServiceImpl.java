package com.example.service.impl;

import com.example.dto.DtoEmployee;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    //dont break the chain
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public DtoEmployee findEmployeeById(Long id) {

        DtoEmployee dtoEmployee = new DtoEmployee();
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isEmpty()){
            return null;
        }

        Employee dbEmployee = optional.get();
        BeanUtils.copyProperties(dbEmployee,dtoEmployee);
        return  dtoEmployee;
    }
}
