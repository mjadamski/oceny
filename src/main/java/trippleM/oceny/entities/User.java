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
    private String phoneNumber;
    private String gitHub;

    //oceny punktowo
    private int markOne;
    private int markTwo;
    private int markThree;
    //oceny opisowo
    private String markOneDesc;
    private String markTwoDesc;
    private String markThreeDesc;
    private Date added;

    @Column(name = "enabled")
    private Boolean active;

    @Column(columnDefinition = "VARCHAR(10) default 'ROLE_USER'")
    private String roleName;


}
