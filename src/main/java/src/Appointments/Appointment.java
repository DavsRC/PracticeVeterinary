package src.Appointments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    protected String clinicNumber;
    protected Type type;
    protected ApointmentStatus apointmentStatus;
    protected LocalDateTime date;

}
