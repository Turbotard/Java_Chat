// Classe GestionClient
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestionClient implements Runnable {
private Socket client;

public GestionClient(Socket client) {
    this.client = client;
}

@Override
public void run() {
    try {
        // Ouvre les flux d'entrée et de sortie pour communiquer avec le client
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // Envoie un message de bienvenue au client
        out.println("Bienvenue sur le chat !");

        // Lit les messages du client et les affiche sur la console du serveur
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Client : " + message);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}