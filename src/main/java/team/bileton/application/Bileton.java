package team.bileton.application;

import lombok.Getter;
import lombok.Setter;
import team.bileton.application.database.BiletonDatabase;
import team.bileton.application.gui.AuthGui;
import team.bileton.application.gui.interfaces.Gui;
import team.bileton.application.models.Category;
import team.bileton.application.models.Cinema;
import team.bileton.application.models.Film;
import team.bileton.application.models.User;
import team.bileton.starter.Application;

import java.time.LocalDateTime;

@Getter
public class Bileton implements Application {

    @Getter
    private static Bileton instance;

    private BiletonDatabase database = new BiletonDatabase();
    private Services services;

    private Gui currentGui;
    @Setter
    private User user;

    @Override
    public void onStart() {
        instance = this;

        database.connect();

        services = new Services(database.getWiringAPI());
        services.setup();

        enterGui(new AuthGui());

    }

    public void enterGui(Gui gui) {
        currentGui = gui;
        currentGui.onEnter();
    }

}
