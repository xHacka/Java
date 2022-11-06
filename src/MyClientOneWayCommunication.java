import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClientOneWayCommunication {
    private Socket socket;
    private String host;
    private int port;

    private BufferedReader in;
    private BufferedWriter out;

    MyClientOneWayCommunication(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("You: ");
                String message = input.nextLine();
                this.out.write(message);
                this.out.newLine();
                this.out.flush();
                System.out.printf("[Message Received] %s\n", this.in.readLine());

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }

    public void close() {
        try {
            this.in.close();
            this.out.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClientOneWayCommunication client = new MyClientOneWayCommunication("localhost", 8080);
        client.start();
    }
}
