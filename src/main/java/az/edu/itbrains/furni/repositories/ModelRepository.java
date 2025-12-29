package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.models.Coupon;
import az.edu.itbrains.furni.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
