package models;

import common.Show;
import lombok.Data;

import java.util.List;

@Data
public class Multiplex {
    private String name;
    private String mulitpexId;
    private List<Show> showsList;
    private String address;
}
