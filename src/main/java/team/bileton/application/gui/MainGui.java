package team.bileton.application.gui;

import team.bileton.application.Services;
import team.bileton.application.models.Cinema;
import team.bileton.application.models.Film;
import team.bileton.application.services.CinemaService;
import team.bileton.application.services.FilmService;
import team.bileton.application.services.UserService;
import team.bileton.application.util.DateUtil;

public class MainGui extends BaseGui {

    private final Services services = getApp().getServices();
    private final UserService userService = services.getUserService();
    private final CinemaService cinemaService = services.getCinemaService();
    private final FilmService filmService = services.getFilmService();

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

}
