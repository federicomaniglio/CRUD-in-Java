import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DB database = new DB("127.0.0.1", "3306", "dbesempio", "root", "");
        System.out.println(database.selectALL("persone"));
        if (database.insertIntoPersone("Marco", "Rossi", 18, "m")) {
            System.out.println(database.selectALL("persone"));
        } else {
            System.out.println("Inserimento non avvenuto!");
        }
        System.out.println();
        if (database.updateIntoPersonabyID(7, "Mario", "Bianchi", 19, "m")) {
            System.out.println(database.selectALL("persone"));
        } else {
            System.out.println("Aggiornamento non avvenuto!");
        }
        System.out.println();
        if (database.deleteIntoPersoneByName("Mario")) {
            System.out.println(database.selectALL("persone"));
        } else {
            System.out.println("Eliminazine non avvenuta!");
        }
    }
}




