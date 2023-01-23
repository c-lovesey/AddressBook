import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

//    public void saveToCsv(String fileName) throws IOException {
//        try {
//            FileWriter writer = new FileWriter(fileName);
//            for (Contact c : contacts) {
//                writer.append(c.getName());
//                writer.append(",");
//                writer.append(c.getPhoneNumber());
//                writer.append(",");
//                writer.append(c.getEmail());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void editContact(String name, Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (c.getName().equals(name)) {
                contacts.set(i, contact);
                break;
            }
        }
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (c.getName().equals(name)) {
                contacts.remove(i);
                break;
            }
        }
    }

    public List<String> searchContacts(String term) {
        List<String> results = new ArrayList<String>();
        for (Contact c : contacts) {
            if (c.getName().contains(term) || c.getPhoneNumber().contains(term) || c.getEmail().contains(term)) {
                results.add(c.getName() + " " + c.getPhoneNumber() + " " + c.getEmail());
            }
        }
        return results;
    }

    public List<String> getAllContacts() {
        List<String> allContacts = new ArrayList<String>();
        for (Contact c : contacts) {
            allContacts.add(c.getName() + " " + c.getPhoneNumber() + " " + c.getEmail());
        }
        return allContacts;
    }
}
