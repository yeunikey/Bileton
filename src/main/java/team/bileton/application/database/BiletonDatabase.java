package team.bileton.application.database;

import com.wiring.api.WiringAPI;
import com.wiring.api.entity.column.Column;
import team.bileton.application.database.interfaces.IDatabase;

import java.util.UUID;

public class BiletonDatabase implements IDatabase {

    private WiringAPI wiringAPI;

    @Override
    public void connect() {
        wiringAPI = new WiringAPI(
                "org.postgresql.Driver",
                "postgresql",
                "34.118.52.174",
                5432,
                "yeunikey",
                "Yerassyl0107",
                "bileton",
                null);
    }

}
