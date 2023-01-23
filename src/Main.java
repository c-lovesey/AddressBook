import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. List All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    email = scanner.nextLine();

                    contact = new Contact(name, phoneNumber, email);
                    addressBook.editContact(name, contact);
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    addressBook.deleteContact(name);
                    break;
                case 4:
                    System.out.print("Enter search term: ");
                    String term = scanner.nextLine();
                    for (String c : addressBook.searchContacts(term)) {
                        System.out.println(c);
                    }
                    break;
                case 5:
                    for (String c : addressBook.getAllContacts()) {
                        System.out.println(c);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please enter a number between 1 and 6.");
            }
        }
    }
}
