package team.bileton.application.services;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import com.wiring.api.entity.result.WiringResult;
import team.bileton.application.Bileton;
import team.bileton.application.repositories.CinemaRepository;
import team.bileton.application.repositories.FilmRepository;
import team.bileton.application.services.interfaces.Service;

public class FilmService implements Service<FilmService, FilmRepository> {

    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
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
    public FilmRepository repository() {
        return repository;
    }

}
