package team.bileton.application.gui;

import team.bileton.application.Bileton;
import team.bileton.application.models.User;
import team.bileton.application.services.UserService;

public class AuthGui extends BaseGui {

    private final UserService userService = getApp().getServices().getUserService();

    @Override
    public void onEnter() {
        lobby();
    }

    public void lobby() {

        System.out.println("==========- Auth -==========");

        System.out.println();
        System.out.println();
        System.out.println("  1. Register a new User");
        System.out.println("  2. Log-in to User");
        System.out.println();
        System.out.print("Select a option :/ ");

        int option = selectOption();

        switch (option) {
            case 1 -> {
                register();
                break;
            }
            case 2 -> {
                login();
                break;
            }
            default -> {
                System.out.println("[i] Option not found. Try again!");
                lobby();
                break;
            }
        }

    }

    public void register() {

        System.out.println();
        System.out.println("==========- Register -==========");
        System.out.println();

        System.out.print("Your username :/ ");
        String username = getScanner().next();

        User user = userService.repository().findByUsername(username);

        if (user != null) {
            System.out.println();
            System.out.println("User exists!");
            lobby();
            return;
        }

        System.out.print("Your password :/ ");
        String password = getScanner().next();

        user = new User(
                username,
                password
        );

        userService.repository()
                .save(user);

        System.out.println();
        System.out.println("User created!");

        lobby();
    }

    public void login() {
        System.out.println();
        System.out.println("==========- Login -==========");
        System.out.println();

        System.out.print("Your username :/ ");
        String username = getScanner().next();

        User user = userService.repository().findByUsername(username);

        if (user == null) {
            System.out.println();
            System.out.println("User not found!");
            lobby();
            return;
        }

        System.out.print("Your password :/ ");
        String password = getScanner().next();

        if (!user.getPassword().equals(password)) {
            System.out.println();
            System.out.println("[x] Wrong password!");
            lobby();
            return;
        }

        System.out.println();
        System.out.println("[v] Successfully logged!");

        Bileton.getInstance().setUser(user);
        Bileton.getInstance().enterGui(new MainGui());
    }


}
