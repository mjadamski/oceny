package trippleM.oceny.entities;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNummber;
    private String gitHub;

    //oceny punktowo
    private int markOne;
    private int markTwo;
    private int markThree;
    //oceny opisowo
    private int markOneDes;
    private int markTwooeDes;
    private int markThreeDes;




    private Date added;

    @Column(name = "enabled")
    private Boolean active;


}
