package com.misight.service;

import com.misight.model.UserPrivilege;
import com.misight.repository.UserPrivilegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.misight.exception.ResourceNotFoundException;

@Service
@Transactional
public class UserPrivilegeServiceImpl implements UserPrivilegeService {

    @Autowired
    private UserPrivilegeRepo userPrivilegeRepo;

    @Override
    public UserPrivilege assignPrivilege(UserPrivilege userPrivilege) {
        return userPrivilegeRepo.save(userPrivilege);
    }

    @Override
    public void removePrivilege(int userId, int privilegeId) {
        userPrivilegeRepo.deleteByUserIdAndPrivilegeId(userId, privilegeId);
    }

    @Override
    public List<UserPrivilege> getUserPrivileges(int userId) {
        return userPrivilegeRepo.findAll().stream()
                .filter(up -> up.getUserId() == userId)
                .toList();
    }
}