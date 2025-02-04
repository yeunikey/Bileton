package team.bileton.application.services;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import com.wiring.api.entity.result.WiringResult;
import team.bileton.application.Bileton;
import team.bileton.application.repositories.CinemaRepository;
import team.bileton.application.repositories.FilmRepository;
import team.bileton.application.services.interfaces.Service;

public class FilmService implements Service<FilmService, FilmRepository> {

    private final FilmRepository repository = new FilmRepository();

    @Override
    public void onLoad() {

        WiringAPI api = Bileton.getInstance().getDatabase().getWiringAPI();

//        api.createTable("films")
//                .column(new Column("uniqueId", "varchar(255)").primaryKey().notNull())
//                .column(new Column("name", "varchar(255)"))
//                .column(new Column("category", "varchar(255)"))
//                .column(new Column("date", "timestamp"))
//                .column(new Column("date", "text"))
//                .execute();

    }

    @Override
    public void onUnload() {

    }

    @Override
    public FilmRepository repository() {
        return repository;
    }

}
