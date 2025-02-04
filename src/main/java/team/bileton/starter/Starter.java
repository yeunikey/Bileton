package team.bileton.starter;

import lombok.Getter;
import team.bileton.application.Bileton;

public class Starter {

    @Getter
    private static Application application;

    public static void main(String[] args) {

        application = new Bileton();
        application.onStart();

    }

}
