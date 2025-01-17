package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Film {

    private String name;
    private Category category;
    private LocalDateTime date;

    private Map<String, Ticket> tickets = new HashMap<>();

}
