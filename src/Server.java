import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {
        int amountOfClients = 2;
        boolean closeChat = false;
        String userMessage;
        ServerSocket serverSocket = new ServerSocket(4999);
        AcceptedClient[] acceptedClient = new AcceptedClient[amountOfClients];
        for (int i = 0; i < amountOfClients; i++) {
            acceptedClient[i] = new AcceptedClient(serverSocket);
        }
        System.out.println("All clients connected");
        for (int i = 0; i < amountOfClients; i++) {
            acceptedClient[i].getWriter().println("All users connected to chat");
            acceptedClient[i].getWriter().flush();
        }
        while (!closeChat) {
            for (int i = 0; i < amountOfClients ; i++) {
                if (acceptedClient[i].getBufferedReader().ready()) {
                    userMessage = acceptedClient[i].getBufferedReader().readLine();
                    System.out.println("client "+ (i+1) + ": " + userMessage);
                    for (int j = 0; j < amountOfClients; j++) {
                        acceptedClient[j].getWriter().println("User "+ (i+1) + ": " + userMessage);
                        acceptedClient[j].getWriter().flush();
                    }
                }
            }
        /*    if (!acceptedClient[0].getSocket().isConnected()){
                closeChat = true;
            }*/
        }
    }
}