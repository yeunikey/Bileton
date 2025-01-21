package team.bileton.application.services;

import team.bileton.application.repositories.UserRepository;
import team.bileton.application.services.interfaces.Service;

public class UserService implements Service<UserService, UserRepository> {

    private final UserRepository repository = new UserRepository();

    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public UserRepository repository() {
        return repository;
    }

}
