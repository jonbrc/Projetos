package jogoslpa;
import java.util.Scanner;

public class jogoNaval {


	

	public static void run() {
		System.out.println("<< BATALHA NAVAL >>");
		efetuarJogada(tabuleiroJogadorA(),tabuleiroJogadorB());
	}	
public static void efetuarJogada(String[][] tabuleiroA,String[][] tabuleiroB) {
		boolean continuar = false;

		//preciso criar uma tabela vazia para exibir para o adversário, essa tabela
		// precisa se relacionar com a original, marcando com "X" o local onde o tiro
		// acertar.
		String[][] testeA = tabuleiro();
		String[][] testeB = tabuleiro();


		int i = 2;
		while(continuar = true) {
			if(i%2==0) {
				System.out.println("jogador A vai jogar: \n");
				System.out.println("       tabuleiro do jogador B");
				imprimir(testeB);
				jogada(tabuleiroB,testeB);
				if(vencedor(testeB) == true) {
					System.out.println("jogador A venceu!");
					jogarDenovo();
					return;
				}
			}else {
				System.out.println("Jogador B vai jogar: ");
				System.out.println("       tabuleiro do jogador A");
				imprimir(testeA);
				jogada(tabuleiroA,testeA);
				if(vencedor(tabuleiroJogadorA()) == true) {
					System.out.println("jogador b venceu!");
					jogarDenovo();
					return;
				}
			}
			i++;			
		}
	}

	public static String [][] tabuleiroJogadorA () {
		String [][] tabuleiroA = tabuleiro();

		//porta aviões
		tabuleiroA[0][3] = "P";
		tabuleiroA[0][4] = "P";
		tabuleiroA[0][5] = "P";
		tabuleiroA[0][6] = "P";
		tabuleiroA[0][7] = "P";

		//navio tanque
		tabuleiroA[3][1] = "N";
		tabuleiroA[4][1] = "N";
		tabuleiroA[5][1] = "N";
		tabuleiroA[6][1] = "N";


		//navio tanque
		tabuleiroA[5][3] = "N";
		tabuleiroA[5][4] = "N";
		tabuleiroA[5][5] = "N";
		tabuleiroA[5][6] = "N";

		// contra-torpedeiro
		tabuleiroA[9][9] = "C";
		tabuleiroA[9][8] = "C";
		tabuleiroA[9][7] = "C";

		// contra-torpedeiro
		tabuleiroA[2][9] = "C";
		tabuleiroA[3][9] = "C";
		tabuleiroA[4][9] = "C";

		// contra-torpedeiro
		tabuleiroA[6][2] = "C";
		tabuleiroA[7][2] = "C";
		tabuleiroA[8][2] = "C";

		//submarino
		tabuleiroA[9][1] = "S";
		tabuleiroA[9][2] = "S";

		//submarino
		tabuleiroA[8][4] = "S";
		tabuleiroA[8][5] = "S";

		//submarino
		tabuleiroA[2][3] = "S";
		tabuleiroA[2][4] = "S";

		//submarino
		tabuleiroA[6][9] = "S";
		tabuleiroA[7][9] = "S";


		return tabuleiroA;
	}
	public static String [][] tabuleiroJogadorB () {
		String [][] tabuleiroB = tabuleiro();

		//porta aviões
		tabuleiroB[1][0] = "P";
		tabuleiroB[2][0] = "P";
		tabuleiroB[3][0] = "P";
		tabuleiroB[4][0] = "P";
		tabuleiroB[5][0] = "P";

		//Navio tanque
		tabuleiroB[0][4] = "N";
		tabuleiroB[0][5] = "N";
		tabuleiroB[0][6] = "N";
		tabuleiroB[0][7] = "N";


		//Navio tanque
		tabuleiroB[2][6] = "N";
		tabuleiroB[3][6] = "N";
		tabuleiroB[4][6] = "N";
		tabuleiroB[5][6] = "N";

		//contra-Torpedeiro
		tabuleiroB[9][9] = "C";
		tabuleiroB[9][8] = "C";
		tabuleiroB[9][7] = "C";

		//contra-Torpedeiro
		tabuleiroB[2][8] = "C";
		tabuleiroB[3][8] = "C";
		tabuleiroB[4][8] = "C";

		//contra-Torpedeiro
		tabuleiroB[4][2] = "C";
		tabuleiroB[5][2] = "C";
		tabuleiroB[6][2] = "C";

		//submarinos
		tabuleiroB[7][1] = "S";
		tabuleiroB[8][1] = "S";

		//submarinos
		tabuleiroB[9][4] = "S";
		tabuleiroB[9][5] = "S";

		//submarinos
		tabuleiroB[2][3] = "S";
		tabuleiroB[2][4] = "S";

		//submarinos
		tabuleiroB[6][8] = "S";
		tabuleiroB[7][8] = "S";


		return tabuleiroB;
	}
	// retornar como vetor de inteiros para tratamento posterior.
	public static String [][] tabuleiro (){
		String[][] tabuleiro = new String[10][10];
		for (int il = 0; il < tabuleiro.length; il++) {
			for (int ic = 0; ic < tabuleiro[0].length ; ic++) {
				tabuleiro[il][ic] = " ";
			}
		}
		return tabuleiro;
	}
	//Método para realizar a jogada. O método testa e válida comparando o tabuleiro criado com o tabuleiro vazio que vai ser 
	// vizualizado pelo jogador oposto. Assim, se passar pela validação, um "X" é marcado no tabuleiro do adversário.
	public static void jogada (String [][] tabuleiro,String [][] tabuleiroVazio) {
		Scanner sc = new Scanner (System.in);

		int a,b;
		do {
			System.out.println("Indique o seu tiro(LINHA/COLUNA): ");
			a = sc.nextInt();
			b = sc.nextInt();
		}while(validacao(tabuleiro,a,b) == false);

		// se a jogada passar pela validação o método adciona o X no tabuleiro vazio (que vai ser vizualizado pelo adversário
		tabuleiroVazio[a][b] = "x";

	}
	//a validação vai testar através do valor da String qual o tipo de navio que acertou
	// se acertou ou se fez uma jogada inválida.
	public static boolean validacao (String [][] tabuleiro,int a , int b) {
		if(tabuleiro[a][b] == " ") {
			System.out.println("Acertou água");			
			return true;
		}if(tabuleiro[a][b].equalsIgnoreCase("p") ) {
			System.out.println("Acertou um porta aviões!");
			return true;
		}if(tabuleiro[a][b].equalsIgnoreCase("n") ) {
			System.out.println("Acertou um navio tanque");
			return true;
		}if(tabuleiro[a][b].equalsIgnoreCase("c") ) {
			System.out.println("Acertou um contra-torpedeiro");
			return true;
		}if(tabuleiro[a][b].equalsIgnoreCase("s") ) {
			System.out.println("Acertou um submarino");
			return true;
		}if(tabuleiro[a][b].equalsIgnoreCase("x") ) {
			System.out.println("Jogada inválida !");
			return false;
		}
		return false;
	}
	public static void imprimir (String[][] tabela) {
		System.out.println("  0   1   2   3   4   5   6   7   8   9 ");
		int x = 0;
		for (int il = 0; il < tabela.length; il++) {
			System.out.println("-----------------------------------------");
			for (int ic = 0; ic < tabela[0].length ; ic++) {
				System.out.print("| "+tabela[il][ic]+ " ");				
			}
			System.out.print("| "+ x);
			x++;
			System.out.println("");
		}

		System.out.print("-----------------------------------------\n");
	}
	//o método conta quantos X tem na tabela. Caso um jogador afunde todos os
	//navios do outro ele vai ter 
	public static boolean vencedor (String [][] tabuleiro) {
		int x = 0;
		for (int il = 0; il <tabuleiro.length; il++) {
			for (int ic = 0; ic <tabuleiro[0].length ; ic++) {
				if(tabuleiro[il][ic].equalsIgnoreCase("x")) {
					x++;
					if(x==30) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void jogarDenovo() {
		Scanner sc = new Scanner (System.in);
		System.out.println(" \n" + "Deseja jogar denovo?[S/N]: ");
		String resp = sc.next();
		if(resp.equalsIgnoreCase("s")) {
			 Console.escolherJogo();
		}else {
			System.out.println("Sistema terminado");
			System.exit(0);
		}
	}
}

