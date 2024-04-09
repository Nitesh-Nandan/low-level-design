package models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingTimings {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
