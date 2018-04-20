package ru.kpfu.itis.medservice.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.kpfu.itis.medservice.demo.entity.Patient;
import ru.kpfu.itis.medservice.demo.service.PatientService;

@Controller
public class LoginController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Patient patient = new Patient();
        modelAndView.addObject("kek", patient);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Patient patient, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Patient patientExists = patientService.findPatientByEmail(patient.getEmail());
        if (patientExists != null) {
            bindingResult
                    .rejectValue("email", "error.kek",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            patientService.savePatient(patient);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Patient());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
}