package observer;

import java.util.Observable;

public class Store extends Observable {

    private String city;
    private String street;
    private int number;

    public Store(String city, String street, int number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public void launchCollection() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return city + " Store on " + street + ", " + number;
    }
}
