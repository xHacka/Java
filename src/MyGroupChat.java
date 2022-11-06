import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MyGroupChat {
    public static volatile boolean isFinished = false;
    public static String nickname;
    private InetAddress host;
    private int port;
    private MulticastSocket socket;
    private final String[] exitCodes = new String[]{"/exit", "/bye", "/quit", "/q", "/!"};

    public void joinGroup(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println(
                    "Connecting To <224.0.0.0:8080>\n" +
                    "Connect To Different Group Using Arguments: <multicast-host> <port-number>\n"
                );
                host = InetAddress.getByName("224.0.0.0");
                port = 8080;
            } else if (args.length == 1) {
                host = InetAddress.getByName(args[0]);
                port = 8080;
            } else if (args.length == 2) {
                host = InetAddress.getByName(args[0]);
                port = Integer.parseInt(args[1]);
            }

            socket = new MulticastSocket(port);

            // localhost Only (For A Subnet Set To 1)
            socket.setTimeToLive(0);
            socket.joinGroup(host);

            Thread thread = new Thread(new ReadThread(socket, host, port));
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.print("Enter Your Nickname: ");
        Scanner input = new Scanner(System.in);
        nickname = input.nextLine();

        while (!isFinished) {
            String message = input.nextLine();
            if (message.isEmpty() || message.isBlank()) continue;
            for (String s : exitCodes)
                if (message.equalsIgnoreCase(s)) {
                    sendMessage(String.format("[%s Has Left The Chat]", nickname));
                    close();
                }
            sendMessage(String.format("%s: %s", nickname, message));
        }
        input.close();
    }

    public void sendMessage(String message) {
        try {
            byte[] buffer = message.getBytes();
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, host, port);
            socket.send(datagram);
        } catch (SocketException se) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            isFinished = true;
            if (socket != null) {
                socket.leaveGroup(host);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyGroupChat chat = new MyGroupChat();
        chat.joinGroup(args);
        chat.run();
    }
}

/******************************************************************************************/

record ReadThread(MulticastSocket socket, InetAddress group, int port) implements Runnable {
    private static final int MAX_LEN = 1000;

    @Override
    public void run() {
        while (!MyGroupChat.isFinished) {
            byte[] buffer = new byte[MAX_LEN];
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, group, port);

            String message;
            try {
                socket.receive(datagram);
                message = new String(buffer, 0, datagram.getLength(), StandardCharsets.UTF_8);
                if (!message.startsWith(MyGroupChat.nickname))
                    System.out.println(message);
            } catch (IOException e) {
                System.out.printf("%s Disconnected\n", MyGroupChat.nickname);
            }
        }
    }
}