package team.bileton.application;

import team.bileton.application.managers.Manager;

public class Managers {

    public void setup() {
        // todo add managers
    }

    public <T extends Manager<?>> T register(T manager) {
        manager.onLoad();
        return manager;
    }

    public <T extends Manager<?>> T unregister(T manager) {
        manager.onUnload();
        return manager;
    }

}
