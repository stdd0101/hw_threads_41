import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
                Socket clientSocket = new Socket("localhost", 40045);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        ) {

            System.out.println("Введите n:");
            String word = reader.readLine();
            out.write(word + "\n");
            out.flush();
            String serverWord = in.readLine();
            System.out.println(serverWord);

        } catch (IOException e) {
            System.out.println("Завершение работы клиента.");
            System.err.println(e);
        }
    }
}
