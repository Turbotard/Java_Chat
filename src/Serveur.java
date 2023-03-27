// Classe Serveur
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
public static void main(String[] args) throws IOException {
try (ServerSocket serveur = new ServerSocket(5000)) {
    System.out.println("Le serveur est à l'écoute sur le port 5000...");
    
        while (true) {
            Socket client = serveur.accept(); // Attend la connexion d'un client
            System.out.println("Un nouveau client est connecté !");
    
            // Crée un nouveau thread pour gérer la communication avec le client
            Thread thread = new Thread(new GestionClient(client));
            thread.start();
        }
}
}

}