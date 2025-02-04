package team.bileton.application.repositories;

import team.bileton.application.models.Film;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.List;

public class FilmRepository implements CrudRepositories<Film, String> {

    @Override
    public Film findById(String s) {
        return null;
    }

    @Override
    public List<Film> findAll() {
        return null;
    }

    @Override
    public void save(Film film) {

    }

    @Override
    public void delete(String s) {

    }

}
