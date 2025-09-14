package exemplo_repita_ate;

import java.util.Locale;
import java.util.Scanner; 

public class Repita {

    public static void main(String[] args) { 
        
        Locale.setDefault(Locale.US); // Define a formatação numérica para o padrão dos EUA
        Scanner sc = new Scanner(System.in);
        
        double C, F;
        char resp;
        
        do { 
            System.out.print("Digite a temperatura em Celsius: "); 
            C = sc.nextDouble(); 
            F = 9.0 * C / 5.0 + 32.0; 
            System.out.printf("Equivalente em Fahrenheit: %.1f%n", F); 
            System.out.print("Deseja repetir (s/n)? "); 
            resp = sc.next().toLowerCase().charAt(0); // Converte para minúscula para garantir comparações consistentes
        } while (resp == 's');
        
        sc.close();
    } 
}

