package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Ticket extends BObject {

    private User user;
    private Film film;

    private int row;
    private int col;

}
