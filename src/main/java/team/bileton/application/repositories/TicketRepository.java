package team.bileton.application.repositories;

import team.bileton.application.models.Ticket;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.List;

public class TicketRepository implements CrudRepositories<Ticket, String> {
    @Override
    public Ticket findById(String s) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void save(Ticket ticket) {

    }

    @Override
    public void delete(String s) {

    }
}
