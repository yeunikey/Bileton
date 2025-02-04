package team.bileton.application.repositories;

import team.bileton.application.models.Cinema;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.List;

public class CinemaRepository implements CrudRepositories<Cinema, String> {
    @Override
    public Cinema findById(String s) {
        return null;
    }

    @Override
    public List<Cinema> findAll() {
        return null;
    }

    @Override
    public void save(Cinema cinema) {

    }

    @Override
    public void delete(String s) {

    }
}
