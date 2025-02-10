package team.bileton.application.gui;

import team.bileton.application.Services;
import team.bileton.application.models.Cinema;
import team.bileton.application.models.Film;
import team.bileton.application.models.Ticket;
import team.bileton.application.services.CinemaService;
import team.bileton.application.services.FilmService;
import team.bileton.application.services.TicketService;
import team.bileton.application.services.UserService;
import team.bileton.application.util.DateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainGui extends BaseGui {

    private final Services services = getApp().getServices();
    private final UserService userService = services.getUserService();
    private final CinemaService cinemaService = services.getCinemaService();
    private final FilmService filmService = services.getFilmService();
    private final TicketService ticketService = services.getTicketService();

    @Override
    public void onEnter() {
        menu();
    }

    public void menu() {

        System.out.println("==========- Menu -==========");

        System.out.println();
        System.out.println();
        System.out.println("  1. Show Films");
        System.out.println("  2. Order Ticket");
        System.out.println("  3. My Tickets");
        System.out.println();
        System.out.print("Select a option :/ ");

        int option = selectOption();

        switch (option) {
            case 1 -> {
                films();
                break;
            }
            case 2 -> {
                order();
                break;
            }
            case 3 -> {
                tickets();
                break;
            }
            default -> {
                System.out.println("[i] Option not found. Try again!");
                menu();
                break;
            }
        }

    }

    public void films() {

        System.out.println();
        System.out.println("==========- Films -==========");
        System.out.println();

        for (Cinema cinema : cinemaService.repository().findAll()) {

            System.out.println(cinema.getName() + ":");

            if (cinema.getFilms().isEmpty()) {
                System.out.println("  No films :(");
                System.out.println();
            } else {

                for (Film film : cinema.getFilms().values()) {
                    System.out.println("  " + film.getName());
                    System.out.println("  Category: " + film.getCategory().getName());
                    System.out.println("  Date: " + DateUtil.formatDate(film.getDate()));
                    System.out.println();
                }

            }

        }

        System.out.print("Write someting to exit :/ ");
        getScanner().next();

        menu();
    }

    public void order() {
        System.out.println();
        System.out.println("==========- Order -==========");
        System.out.println();

        List<Cinema> cinemas = cinemaService.repository().findAll();

        for (int i = 1; i <= cinemas.size(); i++) {
            System.out.println("  " + i + ". " + cinemas.get(i - 1).getName());
        }

        System.out.println();
        System.out.print("Select cinema :/ ");
        int cinemaOption = selectOption();

        System.out.println();

        if (cinemaOption == -1) {
            System.out.println();
            System.out.println("[x] Wrong option");
            menu();
            return;
        }

        Cinema cinema = cinemas.get(cinemaOption - 1);

        List<Film> films = cinema.getFilms().values().stream().toList();
        for (int i = 1; i <= films.size(); i++) {
            Film film = films.get(i - 1);
            System.out.println(" " + i + ". " + film.getName());
            System.out.println("    Category: " + film.getCategory().getName());
            System.out.println("    Date: " + DateUtil.formatDate(film.getDate()));
            System.out.println();
        }

        System.out.print("Select film :/ ");
        int filmOption = selectOption();

        System.out.println();

        if (filmOption == -1) {
            System.out.println();
            System.out.println("[x] Wrong option");
            menu();
            return;
        }

        Film film = films.get(filmOption - 1);

        Map<String, Ticket> tickets = new HashMap<>();
        for (Ticket ticket : ticketService.repository().findByFilm(film.getUniqueId().toString())) {
            tickets.put(ticket.getRow() + "-" + ticket.getCol(), ticket);
        }

        System.out.println("                                      Scene");

        System.out.print("    ");
        for (int c = 1; c <= cinema.getCols(); c++) {
            if (String.valueOf(c).length() == 2) {
                System.out.print(c + ". ");
            } else {
                System.out.print(c + ".  ");
            }
        }
        System.out.println();

        for (int r = 1; r <= cinema.getRows(); r++) {
            System.out.print(r + ". ");
            for (int c = 1; c <= cinema.getCols(); c++) {
                if (tickets.containsKey(r + "-" + c)) {
                    System.out.print(" [x]");
                } else {
                    System.out.print(" [ ]");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("Select a row :/ ");
        int row = getScanner().nextInt();

        if (row > cinema.getRows() || row < 1) {
            System.out.println();
            System.out.println("[x] Row exception");
            menu();
            return;
        }

        System.out.print("Select a col :/ ");
        int col = getScanner().nextInt();

        if (col > cinema.getCols() || col < 1) {
            System.out.println();
            System.out.println("[x] Col exception");
            menu();
            return;
        }

        if (tickets.containsKey(row + "-" + col)) {
            System.out.println();
            System.out.println("[x] That seat is not free");
            menu();
            return;
        }

        Ticket ticket = new Ticket(
                getApp().getUser().getUniqueId(),
                film,
                row,
                col
        );
        ticketService.repository().save(ticket);

        System.out.println();
        System.out.println("[v] Ticket registered");

        menu();
    }

    public void tickets() {

        System.out.println();
        System.out.println("==========- Tickets -==========");
        System.out.println();

        List<Ticket> tickets = ticketService.repository()
                .findByUser(getApp().getUser().getUniqueId().toString());

        for (Ticket ticket : tickets) {

            System.out.println("  " + ticket.getFilm().getName());
            System.out.println("  " + DateUtil.formatDate(ticket.getFilm().getDate()));
            System.out.println("  Seat: " + ticket.getRow() + " row, " + ticket.getCol() + " col");
            System.out.println();

        }

        System.out.print("Write someting to exit :/ ");
        getScanner().next();

        menu();

    }

}
