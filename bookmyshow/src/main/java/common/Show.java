package common;

import models.Multiplex;
import models.Program;

import java.time.LocalDateTime;

public class Show {
    private String showId;
    private Screen playedAt;
    private Multiplex multiplex;
    private Program program;
    private String address;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
