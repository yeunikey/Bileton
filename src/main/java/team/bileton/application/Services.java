package team.bileton.application;

import com.wiring.api.WiringAPI;
import lombok.Getter;
import team.bileton.application.models.Cinema;
import team.bileton.application.repositories.CinemaRepository;
import team.bileton.application.repositories.FilmRepository;
import team.bileton.application.repositories.TicketRepository;
import team.bileton.application.repositories.UserRepository;
import team.bileton.application.services.CinemaService;
import team.bileton.application.services.FilmService;
import team.bileton.application.services.TicketService;
import team.bileton.application.services.UserService;
import team.bileton.application.services.interfaces.Service;

@Getter
public class Services {

    private final WiringAPI api;

    private UserService userService;
    private TicketService ticketService;
    private FilmService filmService;
    private CinemaService cinemaService;

    public Services(WiringAPI api) {
        this.api = api;
    }

    public void setup() {

        FilmRepository filmRepository = new FilmRepository(api);
        TicketRepository ticketRepository = new TicketRepository(api, filmRepository);
        UserRepository userRepository = new UserRepository(api, ticketRepository);
        CinemaRepository cinemaRepository = new CinemaRepository(api, filmRepository);

        userService = register(new UserService(userRepository));
        ticketService = register(new TicketService(ticketRepository));
        filmService = register(new FilmService(filmRepository));
        cinemaService = register(new CinemaService(cinemaRepository));

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
