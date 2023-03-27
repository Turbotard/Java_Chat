// Classe Client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws IOException {
try (Socket client = new Socket("localhost", 5000)) {
    System.out.println("Connecté au serveur !");
    
        // Ouvre les flux d'entrée et de sortie pour communiquer avec le serveur
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    
        // Lit les messages du serveur et les affiche sur la console du client
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Serveur : " + message);
        }
    
        try (// Lit les messages entrés par l'utilisateur et les envoie au serveur
        Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String messageClient = scanner.nextLine();
                out.println(messageClient);
            }
        }
    }
}

}