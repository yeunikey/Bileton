package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Ticket extends BObject {

    private UUID userId;
    private Film film;

    private int row;
    private int col;

    public Ticket(UUID uniqueId, UUID userId, Film film, int row, int col) {
        super(uniqueId);
        this.userId = userId;
        this.film = film;
        this.row = row;
        this.col = col;
    }

}
