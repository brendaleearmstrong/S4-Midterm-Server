package com.misight.service;

import com.misight.model.UserPrivilege;
import java.util.List;

public interface UserPrivilegeService {
    UserPrivilege assignPrivilege(UserPrivilege userPrivilege);
    void removePrivilege(int userId, int privilegeId);
    List<UserPrivilege> getUserPrivileges(int userId);
}