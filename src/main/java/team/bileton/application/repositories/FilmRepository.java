package team.bileton.application.repositories;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import com.wiring.api.entity.result.WiringResult;
import team.bileton.application.models.Category;
import team.bileton.application.models.Film;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class FilmRepository implements CrudRepositories<Film, String> {

    private final WiringAPI api;

    public FilmRepository(WiringAPI api) {
        this.api = api;
    }

    @Override
    public void init() {
        api.createTable("films")
                .column(new Column("uniqueId", "varchar(255)").notNull().primaryKey())
                .column(new Column("name", "varchar(255)"))
                .column(new Column("category", "varchar(255)"))
                .column(new Column("date", "varchar(255)"))
                .execute();
    }

    public Film getFilm(WiringResult result) {
        return new Film(
                UUID.fromString(result.get("uniqueId").toString()),
                result.get("name").toString(),
                Category.valueOf(result.get("category").toString().toUpperCase()),
                LocalDateTime.parse(result.get("date").toString())
        );
    }

    @Override
    public Film findById(String s) {
        return getFilm(api.select("films")
                .key("uniqueId")
                .value(s)
                .execute()
        );
    }

    @Override
    public List<Film> findAll() {
        return api.selectAll("films")
                .execute()
                .stream()
                .map(this::getFilm)
                .toList();
    }

    @Override
    public void save(Film film) {
        api.insert("films")
                .column("uniqueId", film.getUniqueId().toString())
                .column("name", film.getName())
                .column("category", film.getCategory().toString())
                .column("date", film.getDate().toString())
                .execute();
    }

    @Override
    public void delete(String s) {
        api.delete("films")
                .key("uniqueId")
                .value(s)
                .execute();
    }

}
