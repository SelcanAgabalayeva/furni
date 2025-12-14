package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.models.Testimonials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialsRepository extends JpaRepository<Testimonials,Long> {
}
