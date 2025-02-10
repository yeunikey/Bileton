package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class User extends BObject {

    private String username;
    private String password;

    private Map<String, Ticket> tickets = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(UUID uniqueId, String username, String password, Map<String, Ticket> tickets) {
        super(uniqueId);
        this.username = username;
        this.password = password;
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
