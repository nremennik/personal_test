package org.opinions.analyst.repositories;

import org.opinions.analyst.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
}