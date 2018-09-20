package trippleM.oceny.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter @Getter
public class ChangePasswordForm {

    @NotBlank@NotEmpty
    private String newPass;
    @NotBlank@NotEmpty
    private String pass;
    @NotBlank@NotEmpty
    private String newPassRepeat;

}
