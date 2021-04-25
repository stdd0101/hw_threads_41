import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        try (
                ServerSocket server = new ServerSocket(40045);
                Socket clientSocket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            System.out.println("Сервер запущен!");

            String input = in.readLine();
            System.out.println(input);
            int number = Integer.parseInt(input);
            out.write("Привет, это Сервер! Число Фибоначчи: " + fibonacci(number) + "\n");
            out.flush();
        } catch (IOException e) {
            System.out.println("Сервер закрыт!");
            System.err.println(e);
        }
    }
}
