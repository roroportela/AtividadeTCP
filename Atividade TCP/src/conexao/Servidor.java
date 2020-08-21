package conexao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private static ServerSocket serverSocket;

	private Socket conexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	public static void main(String[] args) throws IOException {
		Servidor server = new Servidor();

		serverSocket = new ServerSocket(7413);
		System.out.println("Porta 3214");

		Socket cliente = server.conexao();
//		Conex�o com o cliente
		 System.out.println("Nova conex�o com o cliente "+cliente.getInetAddress().getHostAddress());

		Scanner sc = new Scanner(cliente.getInputStream());
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
		serverSocket.close();
		cliente.close();
//		https://www.caelum.com.br/apostila-java-orientacao-objetos/apendice-sockets#cliente
	}

}
