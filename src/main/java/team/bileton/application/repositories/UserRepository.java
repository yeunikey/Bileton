package team.bileton.application.repositories;

import team.bileton.application.models.User;
import team.bileton.application.repositories.interfaces.CrudRepositories;

import java.util.List;

public class UserRepository implements CrudRepositories<User, String> {

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(String s) {

    }

}
