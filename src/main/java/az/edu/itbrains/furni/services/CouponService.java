package az.edu.itbrains.furni.services;

import az.edu.itbrains.furni.dtos.CouponDto;

import java.util.Optional;

public interface CouponService {
    Optional<CouponDto> validateCoupon(String couponCode);

}
