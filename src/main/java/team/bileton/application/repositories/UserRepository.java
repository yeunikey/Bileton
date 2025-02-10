package team.bileton.application.repositories;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import com.wiring.api.entity.result.WiringResult;
import team.bileton.application.models.Ticket;
import team.bileton.application.models.User;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.*;

public class UserRepository implements CrudRepositories<User, String> {

    private final WiringAPI api;
    private final TicketRepository ticketRepository;

    public UserRepository(WiringAPI api, TicketRepository ticketRepository) {
        this.api = api;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void init() {
        api.createTable("users")
                .column(new Column("uniqueId", "varchar(255)").primaryKey().notNull())
                .column(new Column("username", "varchar(255)"))
                .column(new Column("password", "varchar(255)"))
                .column(new Column("tickets", "text"))
                .execute();
    }

    public User getUser(WiringResult result) {

        if (result.getResult().isEmpty()) {
            return null;
        }

        Map<String, Ticket> tickets = new HashMap<>();

        if (result.get("tickets") != null) {
            for (String ticketId : result.get("tickets").toString().split(";")) {

                Ticket ticket = ticketRepository.findById(ticketId);

                if (ticket == null) {
                    continue;
                }

                tickets.put(ticketId, ticket);
            }
        }

        return new User(
                UUID.fromString(result.get("uniqueId").toString()),
                result.get("username").toString(),
                result.get("password").toString(),
                tickets
        );
    }

    public User findByUsername(String s) {
        return getUser(api.select("users")
                .key("username")
                .value(s)
                .execute());
    }

    @Override
    public User findById(String s) {
        return getUser(api.select("users")
                .key("uniqueId")
                .value(s)
                .execute());
    }

    @Override
    public List<User> findAll() {
        return api.selectAll("users")
                .execute()
                .stream()
                .map(this::getUser)
                .toList();
    }

    @Override
    public void save(User user) {

        String tickets = null;

        if (!user.getTickets().isEmpty()) {
            StringBuilder sb = new StringBuilder();

            for (Ticket ticket : user.getTickets().values()) {
                sb.append(ticket.getUniqueId().toString()).append(";");
            }

            tickets = sb.toString();
        }

        api.insert("users")
                .column("uniqueId", user.getUniqueId().toString())
                .column("username", user.getUsername())
                .column("password", user.getPassword())
                .column("tickets", tickets)
                .execute();
    }

    @Override
    public void delete(String s) {
        api.delete("users")
                .key("uniqueId")
                .value(s)
                .execute();
    }

}
