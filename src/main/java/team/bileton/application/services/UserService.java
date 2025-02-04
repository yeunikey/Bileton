package team.bileton.application.services;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import team.bileton.application.Bileton;
import team.bileton.application.repositories.UserRepository;
import team.bileton.application.services.interfaces.Service;

public class UserService implements Service<UserService, UserRepository> {

    private final UserRepository repository = new UserRepository();

    @Override
    public void onLoad() {

        WiringAPI api = Bileton.getInstance().getDatabase().getWiringAPI();

        api.createTable("users")
                .column(new Column("uniqueId", "varchar(255)").primaryKey().notNull())
                .column(new Column("username", "varchar(255)"))
                .column(new Column("password", "varchar(255)"))
                .column(new Column("tickets", "text"))
                .execute();

    }

    @Override
    public void onUnload() {

    }

    @Override
    public UserRepository repository() {
        return repository;
    }

}
