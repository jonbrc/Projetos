package projetos;
import java.util.Scanner;

public class urna {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		System.out.println("Qual a sua idade? : ");
		int idade = sc.nextInt();
		//a urna vai testar a idade do usuário e informar em qual faixa etária ele se encontra (voto obrigatório,opcional ou não apto).
		// a quantidade de candidatos/as é infinita, arbitrariamente escolhi 3 para manter a simplicidade do código.	
		if (idade >= 18 && idade <= 69) {

			System.out.println(" -- Você está na idade do voto obrigatório --");
			System.out.println("Digite em seguida os números do seu candidato/a : ");
			System.out.println(" (13) - Luis Inácio \n (15) - Simone Tebet \n (12) - Ciro Gomes \n (00) - Voto Nulo  ");

			int voto = sc.nextInt();

			switch (voto) {

			case 13 :
				System.out.println("Luis inácio ");
				System.out.println("confirma? [S/N]");
				String confi = sc.next();

				if(confi.equalsIgnoreCase("s") ) {
					System.out.println("Voto confirmado!!");
				}else {
					System.out.println("Voto Cancelado!!");
				} break;
			case 12 :
				System.out.println("Ciro gomes");
				System.out.println("Confirma? [S/N]");
				String confi2 = sc.next();

				if(confi2.equalsIgnoreCase("s") ) {
					System.out.println("Voto confirmado!!");
				}else {
					System.out.println("Voto Cancelado!!");
				}	  break;
			case 15 :
				System.out.println("Simone Tebet");
				System.out.println("Confirma? [S/N]");
				String confi3 = sc.next();

				if(confi3.equalsIgnoreCase("s") ) {
					System.out.println("Voto confirmado!!");
				}else {
					System.out.println("Voto Cancelado!!");
				}	  break;
			case 0 :
				System.out.println("Voto nulo ?");
				System.out.println("Confirma? [S/N]");
				String confi4 = sc.next();

				if(confi4.equalsIgnoreCase("s") ) {
					System.out.println("Voto confirmado!!");
				}else {
					System.out.println("Voto Cancelado!!");
				}	  break;

			default : System.out.println("candidato não reconhecido");

			}

		} else if ( idade >=16 && idade < 18 || idade > 69) {
			// Caso na faixa etária de voto não obrigatório, a urna vai perguntar se o usuário quer votar.
			System.out.println("-- Você não está na idade de voto obrigatório --");
			System.out.println("            Deseja votar ? [S/N]");
			String resp = sc.next();
			// Escolhendo votar, são mostradas as opções de candidatos
			if (resp.equalsIgnoreCase("s")) {
				System.out.println("Digite em seguida os números do seu candidato/a : ");
				System.out.println(" (13) - Luis Inácio \n (15) - Simone Tebet \n (12) - Ciro Gomes \n (00) - Voto Nulo  ");

				int voto = sc.nextInt();

				switch (voto) {

				case 13 :
					System.out.println("Luis inácio Lula da silva");
					System.out.println("confirma? [S/N]");
					String confi = sc.next();

					if(confi.equalsIgnoreCase("s") ) {
						System.out.println("Voto confirmado!!");
					}else {
						System.out.println("Voto Cancelado!!");
					} break;
				case 12 :
					System.out.println("Ciro gomes");
					System.out.println("Confirma? [S/N]");
					String confi2 = sc.next();

					if(confi2.equalsIgnoreCase("s") ) {
						System.out.println("Voto confirmado!!");
					}else {
						System.out.println("Voto Cancelado!!");
					}	  break;
				case 15 :
					System.out.println("Simone Tebet");
					System.out.println("Confirma? [S/N]");
					String confi3 = sc.next();

					if(confi3.equalsIgnoreCase("s") ) {
						System.out.println("Voto confirmado!!");
					}else {
						System.out.println("Voto Cancelado!!");
					}	  break;
				case 0 :
					System.out.println("Voto nulo ?");
					System.out.println("Confirma? [S/N]");
					String confi4 = sc.next();

					if(confi4.equalsIgnoreCase("s") ) {
						System.out.println("Voto confirmado!!");
					}else {
						System.out.println("Voto Cancelado!!");
					}	  break;

				default : System.out.println("Opção inválida!");
			}
			// caso opte por não votar, a operação é finalizada.	
			}else {
				System.out.println("Fim da operação!!");
			}
		}else if (idade < 16) {
			// caso o usuário não esteja em idade apta para votar a urna vai informar quantos anos faltam para tal
			int fal = 16 - idade;
			System.out.println("faltam "+fal+" anos para você estar apto à votar");
		}
	}
}


