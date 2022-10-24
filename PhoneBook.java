import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook  {

    public static final String PHONE_BOOK_FILE_PATH = "C:\\Users\\kemai\\Desktop\\phonebook.txt";
    public static Scanner sc = null;
    public static void main(String[] args)
    {
        sc = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille: ");
        String userFirstName = getUserInput("Entrez un prénom: ");
        String usePhoneNumber = getUserInput("Entrez un numéro de tél: ");

        Contact newContact = new Contact(userLastName, userFirstName, usePhoneNumber);
        
        File phoneBookFile = getOrCreatePhoneBookFile(PHONE_BOOK_FILE_PATH);

        appendContactToPhoneBook(phoneBookFile, newContact);

        sc.close();

    }

    public static String getUserInput(String userRequest) {

        System.out.println(userRequest);
        return sc.nextLine();

    }

    public static File getOrCreatePhoneBookFile(String phoneBookFilePath) {
        File phoneBookFile = new File(phoneBookFilePath);

        if(phoneBookFile.exists()) {
            return phoneBookFile;
        } 

        try {
            phoneBookFile.createNewFile();
            System.out.println("Le fichier à bien été crée !! (" + phoneBookFilePath + ")");
            return phoneBookFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public static void appendContactToPhoneBook(File phoneBookFile, Contact newContact) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true));

            fileWriter.append(newContact.toString());
            fileWriter.append(System.lineSeparator());
            System.out.println("Contact enregistré");

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}