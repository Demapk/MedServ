package ru.kpfu.itis.medservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.medservice.demo.entity.Role;

@Repository()
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRole(String role);

}