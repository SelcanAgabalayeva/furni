package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    Optional<Coupon> findByCodeAndActiveTrue(String couponCode);
}
