package observer;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {

    private String name;
    private String lastNotification;

    public Client(String name) {
        this.name = name;
    }

    public String getLastNotification() {
        return lastNotification;
    }

    public void addClient(Store store) {
        store.addObserver(this);
    }

    public void update (Observable store, Object arg1) {
        this.lastNotification = this.name + ", new collection launched at " + store.toString();
    }
}
