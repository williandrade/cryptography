

import java.util.Scanner;

import me.williandrade.cryptography.Cryptography;
import me.williandrade.cryptography.FiveLevelsCryptography;

public class CryptographyMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String result = "";
		Cryptography cryptography = new FiveLevelsCryptography();

		while (true) {
			System.out.println("----------------------------");
			System.out.println("0 - Para criptografar");
			System.out.println("1 - Para decriptografar");
			System.out.println("----------------------------");

			Integer response = sc.nextInt();

			if (response == 0) {
				System.out.println("Informe o seu texto:");
				String text = sc.next();
				System.out.println("Informe a sua chave (Em números!):");
				Integer key = sc.nextInt();
				result += "Seu texto criptografado é: \"";
				result += cryptography.encript(text, key);
				result += "\" guarde sua chave, que  é: " + key;
			} else if (response == 1) {
				System.out.println("Informe o seu texto:");
				String text = sc.next();
				System.out.println("Informe a sua chave (Em números!):");
				Integer key = sc.nextInt();
				result += "Seu texto decriptografado é: ";
				result = cryptography.decript(text, key);
			}

			System.out.println(result);
			System.out.println("----------------------------FIM----------------------------\n\n");
		}
	}

}
