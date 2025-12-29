package az.edu.itbrains.furni.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {


    private String code;
    private double discountPercentage;

    private boolean active;
}
