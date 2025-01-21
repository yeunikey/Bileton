package team.bileton.application.services;

import team.bileton.application.repositories.CinemaRepository;
import team.bileton.application.repositories.FilmRepository;
import team.bileton.application.services.interfaces.Service;

public class FilmService implements Service<FilmService, FilmRepository> {

    private final FilmRepository repository = new FilmRepository();

    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public FilmRepository repository() {
        return repository;
    }

}
