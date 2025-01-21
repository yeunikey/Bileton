package team.bileton.application;

import team.bileton.application.services.Servjce;

public class Services {

    public void setup() {
        // todo add managers
    }

    public <T extends Servjce<?>> T register(T service) {
        service.onLoad();
        return service;
    }

    public <T extends Servjce<?>> T unregister(T service) {
        service.onUnload();
        return service;
    }

}
