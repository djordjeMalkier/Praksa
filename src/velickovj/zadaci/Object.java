package velickovj.zadaci;

import java.time.LocalDateTime;

public class Object {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Object() {

    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Object(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
