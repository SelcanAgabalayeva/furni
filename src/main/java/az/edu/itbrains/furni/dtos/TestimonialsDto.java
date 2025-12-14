package az.edu.itbrains.furni.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestimonialsDto {
    private Long id;
    private String description;
    private String imageUrl;
    private String job;
    private String name;
}
