package team.bileton.application;

import lombok.Getter;
import team.bileton.application.services.UserService;
import team.bileton.application.services.interfaces.Service;

@Getter
public class Services {

    private final UserService userService = register(new UserService());

    public void setup() {
        // todo add managers
    }

    public <T extends Service<?>> T register(T service) {
        service.onLoad();
        return service;
    }

    public <T extends Service<?>> T unregister(T service) {
        service.onUnload();
        return service;
    }

}
