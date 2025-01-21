package team.bileton.application.services;

import team.bileton.application.repositories.CinemaRepository;
import team.bileton.application.repositories.UserRepository;
import team.bileton.application.services.interfaces.Service;

public class CinemaService implements Service<CinemaService, CinemaRepository> {

    private final CinemaRepository repository = new CinemaRepository();

    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public CinemaRepository repository() {
        return repository;
    }

}
