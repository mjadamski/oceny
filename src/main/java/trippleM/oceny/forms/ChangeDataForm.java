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
    @NotBlank@NotEmpty
    private String lastName;
    @NotBlank@NotEmpty
    private String phoneNumber;
    @NotBlank@NotEmpty
    private String gitHub;

    @NotBlank@Email
    private String newEmail;
    @NotBlank
    private String newFirstName;
    @NotBlank
    private String newLastName;
    @NotBlank
    private String newPhoneNumber;
    @NotBlank
    private String newGitHub;

}
