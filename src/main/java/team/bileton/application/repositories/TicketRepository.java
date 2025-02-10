package team.bileton.application.repositories;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import com.wiring.api.entity.result.WiringResult;
import team.bileton.application.models.Ticket;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.List;
import java.util.UUID;

public class TicketRepository implements CrudRepositories<Ticket, String> {

    private final WiringAPI api;
    private final FilmRepository filmRepository;

    public TicketRepository(WiringAPI api, FilmRepository filmRepository) {
        this.api = api;
        this.filmRepository = filmRepository;
    }

    @Override
    public void init() {
        api.createTable("tickets")
                .column(new Column("uniqueId", "varchar(255)").primaryKey().notNull())
                .column(new Column("userId", "varchar(255)"))
                .column(new Column("film", "varchar(255)"))
                .column(new Column("row", "varchar(255)"))
                .column(new Column("col", "varchar(255)"))
                .execute();
    }

    public Ticket getTicket(WiringResult result) {
        return new Ticket(
                UUID.fromString(result.get("uniqueId").toString()),
                UUID.fromString(result.get("userId").toString()),
                filmRepository.findById(result.get("film").toString()),
                Integer.parseInt(result.get("row").toString()),
                Integer.parseInt(result.get("col").toString())
            );
    }

    public List<Ticket> findByFilm(String s) {
        return api.selectAll("tickets")
                .execute()
                .stream()
                .filter(result -> result.get("film").toString().equals(s))
                .map(this::getTicket)
                .toList();
    }

    public List<Ticket> findByUser(String s) {
        return api.selectAll("tickets")
                .execute()
                .stream()
                .filter(result -> result.get("userid").toString().equals(s))
                .map(this::getTicket)
                .toList();
    }

    @Override
    public Ticket findById(String s) {
        return getTicket(
                api.select("tickets")
                        .key("uniqueId")
                        .value(s)
                        .execute()
        );
    }

    @Override
    public List<Ticket> findAll() {
        return api.selectAll("tickets")
                .execute()
                .stream()
                .map(this::getTicket)
                .toList();
    }

    @Override
    public void save(Ticket ticket) {
        api.insert("tickets")
                .column("uniqueId", ticket.getUniqueId().toString())
                .column("userId", ticket.getUserId().toString())
                .column("film", ticket.getFilm().getUniqueId().toString())
                .column("row", ticket.getRow())
                .column("col", ticket.getCol())
                .execute();
    }

    @Override
    public void delete(String s) {
        api.delete("tickets")
                .key("uniqueId")
                .value(s)
                .execute();
    }
}
