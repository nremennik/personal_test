package org.orinions.analyst.repositories;

import org.orinions.analyst.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
}