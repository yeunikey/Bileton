package team.bileton.application.managers;

public interface Manager<T> {

    void onLoad();
    void onUnload();

    T getManager();

}
