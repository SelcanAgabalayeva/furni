package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.CouponDto;
import az.edu.itbrains.furni.models.Coupon;
import az.edu.itbrains.furni.repositories.CouponRepository;
import az.edu.itbrains.furni.services.CouponService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Optional<CouponDto> validateCoupon(String couponCode) {
        Optional<Coupon> couponOptional=couponRepository.findByCodeAndActiveTrue(couponCode);
        return couponOptional.map(coupon ->
                new CouponDto(
                        coupon.getCode(),
                        coupon.getDiscountPercentage(),
                        coupon.isActive()
                )
        );

    }
}
