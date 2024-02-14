package lk.ijse.accountManager.entity;

import lk.ijse.accountManager.embeddad.NameIdentifier;
import lk.ijse.accountManager.embeddad.Numbers;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "student_id")
    private int studentId;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "student_name")
    private NameIdentifier name;

    @Column (name = "birthdate")
    private LocalDate birthdate;

    @ElementCollection
    @CollectionTable(name = "student_mobile_no",joinColumns = @JoinColumn(name = "student_id"))
    private List<Numbers> numbers;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Timestamp timestamp;


    public Student(String userName, String firstName, String lastName, String mobileNumber, String homeNumber, String password, LocalDate birthdate) {
        this.userName = userName;
        this.name =new NameIdentifier(firstName, lastName);
        this.numbers = List.of(new Numbers("mobile", mobileNumber), new Numbers("home", homeNumber));
        this.birthdate = birthdate;
        this.password = password;
    }
}

