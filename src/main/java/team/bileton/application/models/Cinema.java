package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Cinema {

    private String name;

    private int rows;
    private int cols;

    private Map<String, Film> films = new HashMap<>();

}
