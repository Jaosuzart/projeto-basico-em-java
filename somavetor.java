import java.util.Locale;
import java.util.Scanner;

public class somavetor {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        double[] vetor = new double[n];
        double soma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextDouble();
            soma += vetor[i]; // Melhorar a eficiência somando diretamente
        }

        double media = soma / n;

        System.out.print("VALORES = ");
        for (double valor : vetor) {
            System.out.printf("%.1f  ", valor);
        }

        System.out.printf("\nSOMA = %.2f\n", soma);
        System.out.printf("MEDIA = %.2f\n", media);

        sc.close();
    }
}
