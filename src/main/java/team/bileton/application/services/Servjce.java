package team.bileton.application.services;

public interface Servjce<T> {

    void onLoad();
    void onUnload();

    T getManager();

}
