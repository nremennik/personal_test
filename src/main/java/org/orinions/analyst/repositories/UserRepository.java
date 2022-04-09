package org.orinions.analyst.repositories;

import org.orinions.analyst.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    // При необходимости можно использовать аннотацию Query над методом и писать запросы на HQL или SQL (нужно добавить nativeQuery = true).
    // @Query(value = "SELECT nextval(pg_get_serial_sequence('t_user', 'id'))", nativeQuery = true)
    //    Long getNextId();
   // User findByUserLogin(String login);
}
