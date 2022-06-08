package com.example.unnayantask3.service;

import com.example.unnayantask3.dto.RegistrationDto;
import com.example.unnayantask3.entity.Registration;
import com.example.unnayantask3.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;


    public RegistrationDto save(Registration registration){
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setName(registration.getName());
        registrationDto.setAction("Create");
        registrationDto.setCurrentStatus("Not In DB");
        registrationRepository.save(registration);
        return registrationDto;
    }

    public Registration updatedData(Registration registration) {
       return registrationRepository.saveAndFlush(registration);
    }

    public RegistrationDto deletedData(Long id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        RegistrationDto registrationDto=new RegistrationDto();
        registrationDto.setAction("Delete");
        if(registration.isEmpty()) {
            registrationDto.setCurrentStatus("Not In DB");
        }else {
            registrationDto.setCurrentStatus("In DB");
            registrationDto.setName(registration.get().getName());
            registrationRepository.deleteById(id);
        }

         return registrationDto;

    }

    public RegistrationDto updateData(Registration registration){
        Optional<Registration> registration1= registrationRepository.findById(registration.getId());

        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setAction("Update");
        if(registration1.isEmpty()){
            registrationDto.setCurrentStatus("Not In DB");
        }
        else{
            registrationDto.setCurrentStatus("IN DB");
            registrationDto.setName(registration.getName());
            registrationRepository.saveAndFlush(registration);
        }
        return registrationDto;
    }

}
