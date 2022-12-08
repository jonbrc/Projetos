package jogoslpa;
import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
    escolherJogo();
	}
	public static void escolherJogo () {
		Scanner sc = new Scanner (System.in);
		boolean jogarDenovo = false;


		System.out.println("Escolha o jogo:"
				+ " \n[1] Jogo da forca"
				+ " \n[2] Jogo da velha"
				+"  \n[3] Batalha naval");
		int jogo = sc.nextInt();

		switch(jogo) {
		case 1:jogoForca.run();
		break;
		case 2:jogoVelha.run();
		break;
		case 3:jogoNaval.run();
		break;
		}
	}
}
