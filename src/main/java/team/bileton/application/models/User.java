package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class User extends BObject {

    private String username;
    private String password;

    private Map<String, Ticket> tickets = new HashMap<>();

}
