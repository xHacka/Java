import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerOneWayCommunication {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private final int port;

    private BufferedReader in;
    private BufferedWriter out;

    MyServerOneWayCommunication(int port) {
        this.port = port;
    }

    public void init() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            this.clientSocket = serverSocket.accept();
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            init();
            try {
                while (true) {
                    String message = in.readLine();
                    System.out.printf("Client: %s\n", message);
                    out.newLine();
                    out.flush();
                    if (message.equalsIgnoreCase("exit")) {
                        out.write("Closing Server...");
                        this.close();
                        break;
                    }
                }
            } catch (IOException e) {
                this.close();
            }
        }
    }

    public void close() {
        try {
            this.in.close();
            this.out.close();
            this.clientSocket.close();
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServerOneWayCommunication server = new MyServerOneWayCommunication(8080);
        server.start();
    }
}
