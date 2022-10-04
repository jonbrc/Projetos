package projetos;

import java.util.Scanner;

public class CalculadoraSimples {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);

		System.out.println("Qual operação deseja realizar ?");
		System.out.println(" [1] soma");
		System.out.println(" [2] multiplicação");
		System.out.println(" [3] subtração ");
		System.out.println(" [4] divisão");

		int operacao = sc.nextInt();

		System.out.println("Digite os números para realizar a operação");

		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float total;

		if (a >= 0  && a <= 100 && b >= 0 && b <= 100) {
			switch(operacao) {
			case 1:
				total = a + b;
				System.out.println("Soma = "+total);
				break;
			case 2:
				total = a * b;
				System.out.println("produto = "+total);
				break;
			case 3:
				total = a-b;
				System.out.println("diferença ="+total);
				break;
			case 4:
				total = a / b;
				System.out.println("divisão = "+total);
				break;		
			default : System.out.println("Operação inválida"); break;	


			}
		}else {
			System.out.println("operação inválida");

		}

	}
}


