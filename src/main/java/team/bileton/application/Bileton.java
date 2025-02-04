package team.bileton.application;

import lombok.Getter;
import team.bileton.application.database.BiletonDatabase;
import team.bileton.starter.Application;

@Getter
public class Bileton implements Application {

    @Getter
    private static Bileton instance;

    private BiletonDatabase database = new BiletonDatabase();
    private Services services;

    @Override
    public void onStart() {
        instance = this;

        database.connect();

        services = new Services();
        services.setup();
    }

}
