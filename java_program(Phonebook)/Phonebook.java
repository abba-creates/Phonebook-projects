import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Phonebook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> insertContact(scanner);
                case 2 -> searchContact(scanner);
                case 3 -> displayContacts();
                case 4 -> deleteContact(scanner);
                case 5 -> updateContact(scanner);
                case 6 -> sortContacts();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    static void insertContact(Scanner scanner) {
        System.out.println("Enter Contact Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Contact Phone Number:");
        String phone = scanner.nextLine();

        contactList.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    static void searchContact(Scanner scanner) {
        System.out.println("Enter the name of the contact to search:");
        String name = scanner.nextLine();
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found: " + contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        }
    }

    static void deleteContact(Scanner scanner) {
        System.out.println("Enter the name of the contact to delete:");
        String name = scanner.nextLine();
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contactList.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    static void updateContact(Scanner scanner) {
        System.out.println("Enter the name of the contact to update:");
        String name = scanner.nextLine();
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Enter new phone number:");
                String newPhone = scanner.nextLine();
                contact.setPhone(newPhone);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    static void sortContacts() {
        contactList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        System.out.println("Contacts sorted by name.");
    }
}
