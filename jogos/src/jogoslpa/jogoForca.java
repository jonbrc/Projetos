package jogoslpa;
import java.util.Random;
import java.util.Scanner;

public class jogoForca {

	

	public static void run() {
		System.out.println("<< JOGO DA FORCA >>");
		efetuarJogada(escolherPalavra ());
	}
	// Método para escolher a palavra na forma de um vetor de char
	
public static char[] escolherPalavra () {

		Random rand = new Random();
		//aqui tô criando um vetor com as palavras do jogo
		String [] palavras = {"casa","cachorro","navio","computador","zebra","arvore","mochila"};
		//escolhendo uma palavra aleatóriamente através do índice.
		String palavraEscolhida = palavras[rand.nextInt(7)];

		//Aqui eu tô criando um vetor de Chars do tamanho da palavra e preenchido com os caracteres dela
		char vetorChar[] = new char[palavraEscolhida.length()];
		//usei o "charAt" para preencher no vetor de chars com a palavra escolhida
		for (int c = palavraEscolhida.length() - 1; c >= 0; c--) {
			vetorChar[c] = palavraEscolhida.charAt(c);
		}
		System.out.println(palavraEscolhida);
		return vetorChar;

	}
	// método para construir a forca e o boneco e recebe como parâmetro um inteiro que representa
	// o número de tentativas
	public static void construirForca(int tentativas) {
		switch(tentativas) {
		case 0:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |        "
				+ "\n |       "
				+ "\n |      " 
				+ "\n_|"
				+ "____\n");break;
		case 1:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |       O "
				+ "\n |       "
				+ "\n |      " 
				+ "\n_|"
				+ "____\n");break;
		case 2:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |       O "
				+ "\n |       | "
				+ "\n |      " 
				+ "\n_|"
				+ "____\n");break;
		case 3:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |       O "
				+ "\n |       |\\"
				+ "\n |      " 
				+ "\n_|"
				+ "____\n");break;
		case 4:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |       O "
				+ "\n |      /|\\"
				+ "\n |      " 
				+ "\n_|"
				+ "____\n");break;
		case 5:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |       O "
				+ "\n |      /|\\"
				+ "\n |        \\" 
				+ "\n_|"
				+ "____\n");break;
		default:System.out.println(" ---------"
				+ "\n |       | "
				+ "\n |       O "
				+ "\n |      /|\\"
				+ "\n |      / \\" 
				+ "\n_|"
				+ "____\n");
		System.out.println("Não tem mais tentativas");
		jogarDenovo();;;break;

		}


	}
	//método para efetuar a jogada, recebe como parâmetro um vetor de char
	public static void efetuarJogada (char[] palavraEscolhida) {

		Scanner sc = new Scanner (System.in);
		//cria-se um vetor do mesmo tamanho do vetor de chars recebido como paramêtro
		// e esse é preenchido por underlines (que posteriormente serão substituídos 
		// pelas letras caso o jogador acerte.
		char [] underline = new char [palavraEscolhida.length];
		for (int i = 0; i < underline.length; i++) {
			underline[i] = '_' ;
		}

		char letraEscolhida;
		int tentativas = 0;

		boolean continuar = false;
		//Esse loop vai controlar o fluxo do jogo.
		while(continuar == false) {
			//Inicia-se mostrando 
			construirForca(tentativas);

			for(int x = 0; x<palavraEscolhida.length;x++) {
				System.out.print(underline[x]+ " ");
			}
			boolean validar = false; 
			//esse loop "do - while" serve para passar as letras escolhidas pelo usuário
			//pelas validações
			do {
				//chama-se o método jogada, que recebe um char do usuário
				letraEscolhida = jogada();
				//cria-se uma variável chamada validar, que recebe um booleano vindo de um método
				//de validação que recebe como parâmetro a palavra sorteada e a letra escolhida
				validar=validar(palavraEscolhida,letraEscolhida);
				if(validar == false) {
					System.out.println("jogada inválida");
					tentativas++;
					construirForca(tentativas);
					for(int x = 0; x<palavraEscolhida.length;x++) {
						System.out.print(underline[x]+ " ");
					}
				}
			}while(validar == false);

			for (int c = 0; c < palavraEscolhida.length ; c++) {
				if(letraEscolhida == palavraEscolhida[c]) {
					underline[c] = letraEscolhida;								
				}

			}
			//método que testa se o jogador já advinhou todas as letras
			if(ganhou(underline)==true) {
				System.out.println("Parabéns,a palavra era" );
				for(int x = 0; x<palavraEscolhida.length;x++) {
					System.out.print(palavraEscolhida[x]+ " ");
				}
				jogarDenovo();
			}
		}
	}

	public static void imprimir(String [] vetor) {

		for(int i = 0;i<vetor.length;i++) {
			System.out.print(vetor[i] + " ");
		}
	}
	//Esse método pede para o usuário realizar a jogada a retorna um char informado pelo mesmo.
	public static char jogada(){

		Scanner sc = new Scanner (System.in);
		System.out.println("\n\nEscolha uma letra: ");
		char letraEscolhida = sc.next().charAt(0);

		return letraEscolhida;

	}

	//Esse método recebe como parâmetro um vetor de chars e um char. Depois verifica através
	//de um loop for se o char é presente em algum dos indices do vetor. Caso sim ele retorna
	//positivo.
	public static boolean validar (char[] palavraEscolhida,char letraEscolhida) {

		for (int i = 0; i <palavraEscolhida.length; i++) {
			if(palavraEscolhida[i]==letraEscolhida) {
				return true;
			}
		}
		return false;
	}

	//esse método testa se no vetor ainda tem algum underline. Se não tiver, ele retorna um booleano true.
	public static boolean ganhou (char [] teste) {

		for (int i = 0; i <teste.length; i++) {
			if(teste[i]== '_' ) {
				return false;
			}
		}
		return true;
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










