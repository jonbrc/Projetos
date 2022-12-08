package jogoslpa;
import java.util.Scanner;


public class jogoVelha {

	// Esse método constroi e retorna o tabuleiro, uma matriz 3X3 de strings vazias.
	
	public static void run() {
		Scanner sc = new Scanner (System.in);
		System.out.println("<< JOGO DA VELHA >>");
		jogada();
		
	}
	public static String[][] tabuleiro () {

		String[][] tabuleiro = new String[3][3];
		for (int il = 0; il < tabuleiro.length; il++) {
			for (int ic = 0; ic < tabuleiro[il].length ; ic++) {
				tabuleiro[il][ic] = " ";
			}
		}
		return tabuleiro;	
	}
	//Esse método permite a impressão de um vetor bidimensional.
	public static void imprimir (String[][] tabela) {
			
		// il para "Indíce linhas" e ic para "indíce colunas".
		for (int il = 0; il < tabela.length; il++) {
			System.out.println("-------------");
			for (int ic = 0; ic < tabela[il].length ; ic++) {
				System.out.print("| "+tabela[il][ic]+ " ");

				if(ic == 2) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
		System.out.print("-------------\n");
	}

	public static void jogada () {

		// O primeiro passo é instanciar o Scanner, a única biblioteca que utilizamos nesse código.
		Scanner sc = new Scanner (System.in);
		System.out.println("O jogo vai começar !");

		//aqui cria-se um array bidimensional através do método "tabuleiro", esse array ; é chamado de velha.
		String[][] velha = tabuleiro();

		int jogadas = 0;
		//O processo de jogo vai acontecer dentro de um loop while controlado por uma variável booleana chamada de "vencedor", essa variável começa como falsa e 
		// pode mudar em função do método "teste".
		boolean vencedor = false,validacao = false,validacao2 = false;


		while(vencedor == false) {


			int linha =0;
			int coluna=0;
			//depois do jogador 1 indicar linah e coluna para sua jogada o índice correspondete no array bidimensional chamado de "velha" é substituido por um "X".
			do {
				validacao=false;
				System.out.println("jogador 1, indique a linha da sua jogada (0 à 2)");
				linha = sc.nextInt();

				System.out.println("jogador 1, indique a coluna da sua jogada (0 à 2)");
				coluna= sc.nextInt();
				if(validacao2(linha,coluna) == true) {
					validacao = validacao(velha,linha,coluna);
				}
			}while (validacao == false);
			velha[linha][coluna]="X";
			jogadas++;
			//O método de impressão utilizado para demonstar onde o X foi alocado na tabela.
			imprimir(velha);
			//uma condição para confirmar se o limite de jogadas possiveis foi atingido, resultando num empate.
			if(jogadas==9) {
				System.out.println("O jogo foi um empate");
				jogarDenovo();
			}
			//Aqui o valor de vencedor pode ou não variar em função do método "teste", que vai receber como parâmetro a tabela chamada de "velha", caso as condições 
			// definidas no método sejam atentidas, o valor da variável vencedor muda para true e o programa é encerrado exibindo a mensagem de vitória para o jogador 1.
			if(teste(velha) == true) {
				jogarDenovo();
			}
			//o Processo para o jogador 2 é o mesmo, mudando somente "X" para um "O".
			do {
				validacao=false;
				System.out.println("jogador 2, indique a linha da sua jogada (0 à 2)");
				linha = sc.nextInt();

				System.out.println("jogador 2, indique a coluna da sua jogada (0 à 2)");
				coluna= sc.nextInt();
				if(validacao2(linha,coluna) == true) {
					validacao = validacao(velha,linha,coluna);
				}

			}while (validacao == false );
			velha[linha][coluna]="O";
			jogadas++;
			imprimir(velha);
			if(jogadas==9) {
				System.out.println("O jogo foi um empate");
				jogarDenovo();
			}
			if(teste(velha) == true) {
				jogarDenovo();
			}
			
		}
	}
	public static boolean teste (String[][] tabela) {

		//testando respectivamente linhas, colunas e diagonais.

		String linha0 = tabela[0][0] + tabela [0][1] + tabela [0][2];
		String linha1 = tabela[1][0] + tabela [1][1] + tabela [1][2];
		String linha2 = tabela[2][0] + tabela [2][1] + tabela [2][2];

		String coluna0 = tabela[0][0] + tabela [1][0] + tabela [2][0];
		String coluna1 = tabela[0][1] + tabela [1][1] + tabela [2][1];
		String coluna2 = tabela[0][2] + tabela [1][2] + tabela [2][2];

		String diagonal1 = tabela[0][0] + tabela [1][1] + tabela [2][2];
		String diagonal2 = tabela[0][2] + tabela [1][1] + tabela [2][0];


		if(linha0.equalsIgnoreCase("XXX") || linha1.equalsIgnoreCase("XXX") ||linha2.equalsIgnoreCase("XXX")||
				coluna0.equalsIgnoreCase("XXX")||coluna1.equalsIgnoreCase("XXX")||coluna2.equalsIgnoreCase("XXX")||
				diagonal1.equalsIgnoreCase("XXX")||diagonal2.equalsIgnoreCase("XXX")) {

			System.out.println("jogador 1 é o vencedor");
			return true;

		}if(linha0.equalsIgnoreCase("OOO") || linha1.equalsIgnoreCase("OOO") ||linha2.equalsIgnoreCase("OOO")||
				coluna0.equalsIgnoreCase("OOO")||coluna1.equalsIgnoreCase("OOO")||coluna2.equalsIgnoreCase("OOO")||
				diagonal1.equalsIgnoreCase("OOO")||diagonal2.equalsIgnoreCase("OOO")) {

			System.out.println("jogador 2 é o vencedor");
			return true;
		}else {
			return false;
		}
	}

// validaão para garantir que não seja realizada jogada onde já tem um X ou O
	public static boolean validacao(String[][] tabela,int linha, int coluna){

		if(tabela[linha][coluna].equalsIgnoreCase("X") || tabela[linha][coluna].equalsIgnoreCase("O")) {
			System.out.println("Jogada inválida , já existe uma jogada no local!");
			return false;
		}else {
			return true;				

		}			
	}
//	validacao para não permitir que o jogador indique um indice fora dos limites
// mudar o "0" para "1" para facilitar vizualização.
	public static boolean validacao2(int linha, int coluna){
		if (linha <0 || linha > 2 || coluna < 0 || coluna > 2) {
			System.out.println("jogada fora dos limites!");
			return false;
		}else {
			return true;
		}
	}

	public static void jogarDenovo() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Deseja jogar denovo?[S/N]: ");
		String resp = sc.next();
		if(resp.equalsIgnoreCase("s")) {
			 Console.escolherJogo();
		}else {
			System.out.println("Sistema terminado");
			System.exit(0);
		}
	}
}




