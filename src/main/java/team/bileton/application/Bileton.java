package team.bileton.application;

import lombok.Getter;
import team.bileton.starter.Application;

@Getter
public class Bileton implements Application {

    @Getter
    private static Bileton instance;

    private Services services = new Services();

    @Override
    public void onStart() {
        instance = this;

        services.setup();
    }

}
