package trippleM.oceny.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter @Getter
@ToString(exclude = {"pass", "passRepeat", "oldPass"})
public class ChangePasswordForm {

    @NotBlank@NotEmpty
    private String oldPass;
    @NotBlank@NotEmpty
    private String pass;
    @NotBlank@NotEmpty
    private String passRepeat;

}
