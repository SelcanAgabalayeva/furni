package az.edu.itbrains.furni.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private String imageUrl;
    private String name;
    private Double price;
    private Long productId;
    private int quantity;
    public double getTotal() {
        return quantity * price;
    }
}
