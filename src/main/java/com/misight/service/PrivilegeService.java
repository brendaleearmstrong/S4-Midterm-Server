package com.misight.service;

import com.misight.model.Privilege;
import com.misight.repository.PrivilegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepo privilegeRepo;

    public Privilege addPrivilege(Privilege privilege) {
        return privilegeRepo.save(privilege);
    }

    public Optional<Privilege> getPrivilegeById(int id) {
        return privilegeRepo.findById(id);
    }

    public Privilege updatePrivilege(int id, Privilege updatedPrivilege) {
        return privilegeRepo.findById(id).map(privilege -> {
            privilege.setPrivilegeName(updatedPrivilege.getPrivilegeName());
            return privilegeRepo.save(privilege);
        }).orElseThrow(() -> new RuntimeException("Privilege not found"));
    }

    public boolean deletePrivilege(int id) {
        if (privilegeRepo.existsById(id)) {
            privilegeRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
