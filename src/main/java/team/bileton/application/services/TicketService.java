package team.bileton.application.services;

import team.bileton.application.repositories.TicketRepository;
import team.bileton.application.services.interfaces.Service;

public class TicketService implements Service<TicketService, TicketRepository> {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
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
    public TicketRepository repository() {
        return repository;
    }

}
