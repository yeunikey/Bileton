package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Cinema extends BObject {

    private String name;
    
    private int rows;
    private int cols;

    private Map<String, Film> films = new HashMap<>();

    public Cinema(String name, int rows, int cols) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
    }

    public Cinema(UUID uniqueId, String name, int rows, int cols, Map<String, Film> films) {
        super(uniqueId);
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.films = films;
    }

    public void addFilm(Film film) {
        films.put(film.getUniqueId().toString(), film);
    }

}
