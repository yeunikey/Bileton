package team.bileton.application.database;

import com.wiring.api.WiringAPI;
import lombok.Getter;

@Getter
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
