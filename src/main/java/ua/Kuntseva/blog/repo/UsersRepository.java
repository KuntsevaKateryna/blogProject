package ua.Kuntseva.blog.repo;

import org.springframework.data.repository.CrudRepository;
import ua.Kuntseva.blog.models.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
