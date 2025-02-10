package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Film extends BObject {

    private String name;
    private Category category;
    private LocalDateTime date;

    public Film(UUID uniqueId, String name, Category category, LocalDateTime date) {
        super(uniqueId);
        this.name = name;
        this.category = category;
        this.date = date;
    }

}
