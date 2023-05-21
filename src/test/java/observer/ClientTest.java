package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void mustNotifyOneClient() {
        Store store = new Store("Brisbane", "Ann Street", 39);
        Client client = new Client("Josh");
        client.addClient(store);
        store.launchCollection();
        assertEquals("Josh, new collection launched at Brisbane Store on Ann Street, 39", client.getLastNotification());
    }

    @Test
    void mustNotifyClients () {
        Store store = new Store("Gold Coast", "Mary Street", 122);
        Client client1 = new Client("Lucy");
        Client client2 = new Client("Robert");
        client1.addClient(store);
        client2.addClient(store);
        store.launchCollection();
        assertEquals("Lucy, new collection launched at Gold Coast Store on Mary Street, 122", client1.getLastNotification());
        assertEquals("Robert, new collection launched at Gold Coast Store on Mary Street, 122", client2.getLastNotification());
    }

    @Test
    void shouldNotNotifyClient(){
        Store store1 = new Store("Brisbane", "Ann Street", 39);
        Client client1 = new Client("Lucy");
        store1.launchCollection();
        assertEquals(null, client1.getLastNotification());
    }

    @Test
    void mustNotifyClientOfTheBrisbaneStore() {
        Store store1 = new Store("Brisbane", "Ann Street", 39);
        Store store2 = new Store("Gold Coast", "Mary Street", 122);
        Client client1 = new Client("Lucy");
        Client client2 = new Client("Robert");
        client1.addClient(store1);
        client2.addClient(store2);
        store1.launchCollection();
        assertEquals("Lucy, new collection launched at Brisbane Store on Ann Street, 39", client1.getLastNotification());
        assertEquals(null, client2.getLastNotification());

    }

}
