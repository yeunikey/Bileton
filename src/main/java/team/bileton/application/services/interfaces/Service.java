package team.bileton.application.services.interfaces;

import team.bileton.application.Bileton;
import team.bileton.application.Services;
import team.bileton.application.repositories.interfaces.CrudRepositories;

public interface Service<T, R extends CrudRepositories<?, ?>> {

    void onLoad();
    void onUnload();

    R repository();

    default T getService() {
        return (T) this;
    }

    default Services services() {
        return Bileton.getInstance().getServices();
    }

}
