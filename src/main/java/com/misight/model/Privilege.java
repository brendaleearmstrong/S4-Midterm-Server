package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int privilegeId;

    @Column(nullable = false, unique = true)
    private String privilegeName;

    @ManyToMany(mappedBy = "privileges")
    private Set<User> users = new HashSet<>();

    public Privilege() {}

    public Privilege(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
        user.getPrivileges().add(this);
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.getPrivileges().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Privilege)) return false;
        Privilege privilege = (Privilege) o;
        return privilegeId == privilege.privilegeId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(privilegeId);
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilegeId=" + privilegeId +
                ", privilegeName='" + privilegeName + '\'' +
                '}';
    }
}
