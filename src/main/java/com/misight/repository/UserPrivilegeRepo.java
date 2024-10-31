package com.misight.repository;

import com.misight.model.UserPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepo extends JpaRepository<UserPrivilege, Integer> {
    void deleteByUserIdAndPrivilegeId(int userId, int privilegeId);
}