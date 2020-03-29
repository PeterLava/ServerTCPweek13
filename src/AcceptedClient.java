import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptedClient {
    Socket socket;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;
    PrintWriter writer;

     AcceptedClient(ServerSocket client) throws IOException {
        this.socket = client.accept();
        inputStreamReader = new InputStreamReader(this.socket.getInputStream());
        bufferedReader = new BufferedReader(this.inputStreamReader);
        writer = new PrintWriter(this.socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public InputStreamReader getInputStreamReader() {
        return inputStreamReader;
    }

    public void setInputStreamReader(InputStreamReader inputStreamReader) {
        this.inputStreamReader = inputStreamReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
}
