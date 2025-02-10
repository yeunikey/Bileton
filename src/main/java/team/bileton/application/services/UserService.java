package team.bileton.application.services;

import com.wiring.api.WiringAPI;
import team.bileton.application.Bileton;
import team.bileton.application.repositories.FilmRepository;
import team.bileton.application.repositories.TicketRepository;
import team.bileton.application.repositories.UserRepository;
import team.bileton.application.services.interfaces.Service;

public class UserService implements Service<UserService, UserRepository> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onLoad() {
        userRepository.init();
    }

    @Override
    public void onUnload() {

    }

    @Override
    public UserRepository repository() {
        return userRepository;
    }

}
