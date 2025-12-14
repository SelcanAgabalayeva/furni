package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
