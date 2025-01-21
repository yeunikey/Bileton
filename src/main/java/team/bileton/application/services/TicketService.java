package team.bileton.application.services;

import team.bileton.application.repositories.TicketRepository;
import team.bileton.application.services.interfaces.Service;

public class TicketService implements Service<TicketService, TicketRepository> {

    private final TicketRepository repository = new TicketRepository();

    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public TicketRepository repository() {
        return repository;
    }

}
