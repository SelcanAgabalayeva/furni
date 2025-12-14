package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
