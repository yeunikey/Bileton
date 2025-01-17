package team.bileton.starter;

import team.bileton.application.Bileton;

public class Starter {

    private static Application application;

    public static void main(String[] args) {

        application = new Bileton();
        application.onStart();

    }

    public static Application getApplication() {
        return application;
    }

}
