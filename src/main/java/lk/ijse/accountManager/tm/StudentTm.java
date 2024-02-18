package lk.ijse.accountManager.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentTm {
    private String firstName;
    private String lastName;
    private LocalDate date;
    private String mobileNum;
}

