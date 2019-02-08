import java.util.ArrayList;
import java.util.LinkedList;

public class ContactList {

    public ArrayList<Contact> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ContactList(ArrayList<Contact> c){
        contacts = c;

    }

    public int getNumberOfContacts() {
        return contacts.size();
    }

    public Contact getContactByName(String name) {
        for (Contact c : contacts)
            if (c.getName().contains(name))
                return c;
        return null;
    }
}
