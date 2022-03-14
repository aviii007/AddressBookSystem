package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class AddressBook {
    private  static Scanner scanner = new Scanner(System.in);
    private static List<Contact> contactList = new ArrayList<>();

    public static void addNewContact(Scanner scanner) {
        System.out.println("Please Enter the Contact Details");
        System.out.println("First Name :");
        String firstName = scanner.next();
        System.out.println("Last Name :");
        String lastName = scanner.next();
        System.out.println("Address :");
        String address = scanner.next();
        System.out.println("City :");
        String city = scanner.next();
        System.out.println("State :");
        String state = scanner.next();
        System.out.println("Zip :");
        long zip = scanner.nextLong();
        System.out.println("Phone Number :");
        long phoneNumber = scanner.nextLong();
        System.out.println("Email :");
        String email = scanner.next();
        contactList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book System Program");
        String userChoice = "N";
        do {
            readUserInput(scanner);
            System.out.println("Do you want to continue(Y/N) ?");
            userChoice = scanner.next();
        }while(userChoice.equals("Y"));
        System.out.println("Thank you!");
    }

    private static void readUserInput(Scanner scanner) {
        System.out.println("Please select one option");
        System.out.println("1. Create new contact \n2. Edit contact \n3. List contacts \n4. Delete contact ");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                addNewContact(scanner);
                System.out.println("Contact added successfully!");
                break;
            case 2:
                editContact();
                break;
            case 3:
                listContacts();
                break;
            case 4:
                deleteContact();
                break;
            default:
                System.out.println("Invalid option. Please select valid");
    }
}

    private static void deleteContact() {
        System.out.println("Please enter the name of the person u want to delete :");
        String contactName = scanner.next();
        Iterator<Contact> iterator = contactList.iterator();
        while(iterator.hasNext()){
            Contact contact = iterator.next();
            if(contactName.equals(contact.getFirstName())){
                iterator.remove();
            }
        }
        listContacts();
    }

    private static void listContacts() {
        System.out.println(contactList);
    }

    private static void editContact() {
        System.out.println("Please enter the name of the person u want to edit :");
        String searchName = scanner.next();
        for(Contact contact : contactList){
            if (searchName.equals(contact.getFirstName())){
                System.out.println("Please select the field you want to edit ");
                System.out.println("1.Lastname  2.Address  3.City  4.State  5.Zip  6.Phone number  7.email ");
                int userChoice = scanner.nextInt();
                switch(userChoice){
                    case 1:
                        System.out.println("Please enter new last name :");
                        String lastName = scanner.next();
                        contact.setLastName(lastName);
                        break;
                    case 2:
                        System.out.println("Please enter new address :");
                        String address = scanner.next();
                        contact.setAddress(address);
                        break;
                    case 3:
                        System.out.println("Please enter new city :");
                        String city = scanner.next();
                        contact.setCity(city);
                        break;
                    case 4:
                        System.out.println("Please enter new state :");
                        String state = scanner.next();
                        contact.setState(state);
                        break;
                    case 5:
                        System.out.println("Please enter new zip :");
                        long zip = scanner.nextLong();
                        contact.setZip(zip);
                        break;
                    case 6:
                        System.out.println("Please enter new phone number :");
                        long phoneNumber = scanner.nextLong();
                        contact.setPhoneNumber(phoneNumber);
                        break;
                    case 7:
                        System.out.println("Please enter new email :");
                        String email = scanner.next();
                        contact.setEmail(email);
                        break;
                    default:
                        System.out.println("Invalid option. Please enter valid !");
                }
            }
        }
        listContacts();
    }
}
