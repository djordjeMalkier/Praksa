package tamara.zadaci.lista_objekata;

import java.time.LocalDateTime;

public class Objects {
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Objects(LocalDateTime startDate, LocalDateTime endDate) {
        this.startTime = startDate;
        this.endTime = endDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
