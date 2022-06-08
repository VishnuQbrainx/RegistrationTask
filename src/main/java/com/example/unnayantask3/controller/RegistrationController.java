package com.example.unnayantask3.controller;

import com.example.unnayantask3.dto.RegistrationDto;
import com.example.unnayantask3.entity.Registration;
import com.example.unnayantask3.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/save")
    public String saveData(@RequestBody Registration registration){
       registrationService.save(registration);
       return "Data Added in DB";
    }


    @PutMapping("/update")
    public String updateData(Registration registration){
        registrationService.updatedData(registration);
        return "DATA UPDATED";
    }

    @DeleteMapping("/delete")
    public RegistrationDto deleteData(@RequestParam Long id){
        return registrationService.deletedData(id);

    }


}
