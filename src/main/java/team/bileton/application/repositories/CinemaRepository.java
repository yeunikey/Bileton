package team.bileton.application.repositories;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import com.wiring.api.entity.result.WiringResult;
import team.bileton.application.models.Cinema;
import team.bileton.application.models.Film;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CinemaRepository implements CrudRepositories<Cinema, String> {

    private final WiringAPI api;
    private final FilmRepository filmRepository;

    public CinemaRepository(WiringAPI api, FilmRepository filmRepository) {
        this.api = api;
        this.filmRepository = filmRepository;
    }

    @Override
    public void init() {
        api.createTable("cinemas")
                .column(new Column("uniqueId", "varchar(255)").primaryKey().notNull())
                .column(new Column("name", "varchar(255)"))
                .column(new Column("rows", "varchar(255)"))
                .column(new Column("cols", "varchar(255)"))
                .column(new Column("films", "text"))
                .execute();
    }

    public Cinema getCinema(WiringResult result) {

        if (result.getResult().isEmpty()) {
            return null;
        }

        Map<String, Film> films = new HashMap<>();

        if (result.get("films") != null) {
            String formattedFilms = result.get("films").toString();
            if (formattedFilms != null) {
                for (String filmId : formattedFilms.split(";")) {
                    Film film = filmRepository.findById(filmId);
                    if (film == null) {
                        continue;
                    }
                    films.put(filmId, film);
                }
            }
        }

        return new Cinema(
                UUID.fromString(result.get("uniqueId").toString()),
                result.get("name").toString(),
                Integer.parseInt(result.get("rows").toString()),
                Integer.parseInt(result.get("cols").toString()),
                films
        );
    }

    @Override
    public Cinema findById(String s) {
        return getCinema(
                api.select("cinemas")
                        .key("uniqueId")
                        .value(s)
                        .execute()
        );
    }

    @Override
    public List<Cinema> findAll() {
        return api.selectAll("cinemas")
                .execute()
                .stream()
                .map(this::getCinema)
                .toList();
    }

    @Override
    public void save(Cinema cinema) {

        String films = null;

        if (!cinema.getFilms().isEmpty()) {
            StringBuilder sb = new StringBuilder();

            for (Film film : cinema.getFilms().values()) {
                sb.append(film.getUniqueId().toString()).append(";");
            }

            films = sb.toString();
        }

        api.insert("cinemas")
                .column("uniqueId", cinema.getUniqueId().toString())
                .column("name", cinema.getName())
                .column("rows", cinema.getRows())
                .column("cols", cinema.getCols())
                .column("films", films)
                .execute();
    }

    @Override
    public void delete(String s) {
        api.delete("cinemas")
                .key("uniqueId")
                .value(s)
                .execute();
    }
}
