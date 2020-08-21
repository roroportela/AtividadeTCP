package conexao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cliente = new Socket("127.0.0.1", 7413);
		System.out.println("Cliente Conectado");

		Scanner sc = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		while (sc.hasNext()) {
			saida.println(sc.nextLine());
		}
		saida.close();
		sc.close();
		cliente.close();
	}
}
