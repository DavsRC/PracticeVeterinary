package src.Patient;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    private String clinicNumber;
    private String name;
    private String breed;
    private String pet;
    private Owner owners;
    private boolean isVaccinated;
    private Date dewormingDate;
}
