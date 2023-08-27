package com.company;
import java.util.*;
import java.io.*;

class Contact{
    private String name;
    private String PhoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber,String emailAddress) {
        this.name = name;
        this.PhoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
}
class AddressBook{
    private List<Contact> contacts;

    public AddressBook(){
        contacts = new ArrayList<>();
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    public void removeContact(Contact contact){
        contacts.remove(contact);
    }
    public Contact searchContact(String name){
        for(Contact contact : contacts){
            if(contact.getName().equalsIgnoreCase(name)){
                return contact;

            }
        }
        return null;
    }
    public List<Contact> getAllContacts(){
        return contacts;
    }
}

public class Task5 {
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Address Book Menu: ");
            System.out.println("1. Adding a new Contact");
            System.out.println("2. removing an existing Contact");
            System.out.println("3. searching for a contact");
            System.out.println("4. displaying all contacts");
            System.out.println("5. exiting the application");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.println(" Enter email address: ");
                    String emailAddress = sc.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    ab.addContact(newContact);
                    break;
                case 2:
                    System.out.print("Enter name to removing an existing contacts");
                    String removeName = sc.nextLine();
                    Contact removedContact = ab.searchContact(removeName);
                    if (removedContact != null) {
                        ab.removeContact(removedContact);
                        System.out.println("Contact removed an existing contacts");
                    } else {
                        System.out.println("Contact not found an existing contact");
                    }
                    break;
                case 3:
                    System.out.println("Enter name to search in contact list");
                    String searchName = sc.nextLine();
                    Contact searchedContact = ab.searchContact(searchName);
                    if (searchedContact != null) {
                        System.out.println("Contact found: ");
                        System.out.println("searchedContact");
                    } else {
                        System.out.println("contact not found an existing contact : ");
                    }
                    break;
                case 4:
                    List<Contact> allContacts = ab.getAllContacts();
                    System.out.println("All contacts:");
                    for (Contact contact : allContacts) {
                        System.out.println(contact);
                    }
                    break;
                case 5:
                    System.out.println("Existing address book, Thank you!");
                    break;
                default:
                    System.out.println("invalid choice please select valid option.");
                    break;

            }
        }  while (choice != 5) ;
    }
}
