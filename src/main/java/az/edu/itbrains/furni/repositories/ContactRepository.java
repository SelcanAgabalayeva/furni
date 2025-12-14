package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
