package az.edu.itbrains.furni.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}
