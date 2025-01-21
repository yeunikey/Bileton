package team.bileton.application;

import lombok.Getter;
import team.bileton.application.models.Cinema;
import team.bileton.application.services.CinemaService;
import team.bileton.application.services.FilmService;
import team.bileton.application.services.TicketService;
import team.bileton.application.services.UserService;
import team.bileton.application.services.interfaces.Service;

@Getter
public class Services {

    private final UserService userService = register(new UserService());
    private final TicketService ticketService = register(new TicketService());
    private final FilmService filmService = register(new FilmService());
    private final CinemaService cinemaService = register(new CinemaService());

    public void setup() {

    }

    public <T extends Service<?, ?>> T register(T service) {
        service.onLoad();
        return service;
    }

    public <T extends Service<?, ?>> T unregister(T service) {
        service.onUnload();
        return service;
    }

}
