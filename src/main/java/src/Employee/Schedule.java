package src.Employee;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Schedule {

    private DayOfWeek day;
    private boolean Status;
    private LocalTime InTime;
    private LocalTime OutTime;

    public Schedule(DayOfWeek day, boolean status, LocalTime inTime, LocalTime outTime) {
        this.day = day;
        Status = status;
        InTime = inTime;
        OutTime = outTime;
    }

}
