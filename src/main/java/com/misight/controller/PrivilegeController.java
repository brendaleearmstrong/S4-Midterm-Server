package com.misight.controller;

import com.misight.model.Privilege;
import com.misight.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/privileges")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping
    public ResponseEntity<Privilege> addPrivilege(@RequestBody Privilege privilege) {
        return new ResponseEntity<>(privilegeService.addPrivilege(privilege), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Privilege> getPrivilegeById(@PathVariable int id) {
        Optional<Privilege> privilege = privilegeService.getPrivilegeById(id);
        return privilege.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Privilege> updatePrivilege(@PathVariable int id, @RequestBody Privilege privilege) {
        return new ResponseEntity<>(privilegeService.updatePrivilege(id, privilege), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivilege(@PathVariable int id) {
        boolean deleted = privilegeService.deletePrivilege(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
