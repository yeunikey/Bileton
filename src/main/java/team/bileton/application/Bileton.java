package team.bileton.application;

import team.bileton.starter.Application;

public class Bileton implements Application {

    private static Bileton instance;

    private Managers managers = new Managers();

    @Override
    public void onStart() {
        instance = this;

        managers.setup();
    }

    public Managers getManagers() {
        return managers;
    }

    public static Bileton getInstance() {
        return instance;
    }

}
