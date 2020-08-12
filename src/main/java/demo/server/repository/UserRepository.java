package demo.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.server.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{

/* --------------------------------------------------------------------------------------------- */

    public User findByUsername(String username);

/* --------------------------------------------------------------------------------------------- */

}
