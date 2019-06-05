package org.swdprm.dmdziennik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swdprm.dmdziennik.model.Role;
import org.swdprm.dmdziennik.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        role.setName("ROLE_" + role.getName().toUpperCase());
        return roleRepository.save(role);
    }
}
