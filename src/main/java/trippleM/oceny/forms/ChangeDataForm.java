package trippleM.oceny.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter @Getter
@ToString
public class ChangeDataForm {

    @NotBlank@NotEmpty@Email
    private String email;
    @NotBlank@NotEmpty
    private String firstName;
//    @Size(min = 5, max = 10, message = "Nazwisko musi mieć od {min} do {max} znaków.")
    @NotBlank@NotEmpty
    private String lastName;
    @NotBlank@NotEmpty
    private String phoneNumber;
    @NotBlank@NotEmpty
    private String gitHub;
}
