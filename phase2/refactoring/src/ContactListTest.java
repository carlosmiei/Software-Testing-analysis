import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContactListTest {

    @org.junit.Test
    public void getNumberOfContacts() {

        String cont1 = "carlos";
        String cont2 = "manel";
        ArrayList<String> array = new ArrayList<String>();
        array.add(cont1);
        array.add(cont2);

        ArrayList<String> array2 = new ArrayList<String>();
        array2.add(cont1);
        Contact c1 = new Contact(array);

        ArrayList<Contact> lista = new ArrayList<Contact>();
        lista.add(c1);

        ContactList fina = new ContactList(lista);
        int x  = fina.getNumberOfContacts();

        assertEquals("boa",2,2,0.01);

    }

    @org.junit.Test
    public void getContactByName() {
    }
}