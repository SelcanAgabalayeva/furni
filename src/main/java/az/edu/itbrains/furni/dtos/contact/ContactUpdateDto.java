package az.edu.itbrains.furni.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactUpdateDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}
