import java.util.ArrayList;

public class Contact {
    private ArrayList<String> name;
    private ArrayList<String> address;
    private ArrayList<String> emailAddress;
    private ArrayList<String> phoneNumber;

    public Contact(ArrayList<String> name) {
        this.name = name;
        address = null;
        emailAddress = null;
        phoneNumber = null;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public ArrayList<String> getEmailAddress() {
        return emailAddress;
    }

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }
}
