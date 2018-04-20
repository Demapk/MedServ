package ru.kpfu.itis.medservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.medservice.demo.entity.Patient;


@Repository("PatientRepository")
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
}