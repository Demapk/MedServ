package ru.kpfu.itis.medservice.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ru.kpfu.itis.medservice.demo.entity.MyUserDetail;
import ru.kpfu.itis.medservice.demo.entity.Patient;
import ru.kpfu.itis.medservice.demo.entity.Role;
import ru.kpfu.itis.medservice.demo.repository.PatientRepository;
import ru.kpfu.itis.medservice.demo.repository.RoleRepository;

@Service("PatientService")
public class PatientService implements UserDetailsService{

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public void savePatient(Patient patient) {
        patient.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
//        patient.setRole(userRole);
        patientRepository.save(patient);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new MyUserDetail(patientRepository.findByEmail(s));
    }
}