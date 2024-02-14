package lk.ijse.accountManager.embeddad;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NameIdentifier {
    private String fistName;
    private String lastName;
}

