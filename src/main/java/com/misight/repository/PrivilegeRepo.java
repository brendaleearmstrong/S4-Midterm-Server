package com.misight.repository;

import com.misight.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepo extends JpaRepository<Privilege, Integer> {
    Privilege findByPrivilegeName(String privilegeName);
}
