package team.bileton.application.services;

import team.bileton.application.repositories.CinemaRepository;
import team.bileton.application.repositories.UserRepository;
import team.bileton.application.services.interfaces.Service;

public class CinemaService implements Service<CinemaService, CinemaRepository> {

    private final CinemaRepository repository;

    public CinemaService(CinemaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onLoad() {
        repository.init();
    }

    @Override
    public void onUnload() {

    }

    @Override
    public CinemaRepository repository() {
        return repository;
    }

}
