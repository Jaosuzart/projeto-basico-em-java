package teste_condicional;

import java.util.Scanner; // Importação necessária para utilizar Scanner

public class testecondicional { // O nome da classe deve começar com letra maiúscula

    public static void main(String[] args) { // O método `main` deve estar dentro da classe, não do construtor
        Scanner sc = new Scanner(System.in);

        int hora;
        System.out.print("Digite uma hora do dia: ");
        hora = sc.nextInt();

        if (hora < 12) {
            System.out.println("Bom dia!");
        } else {
            System.out.println("Boa tarde!");
        }

        sc.close();
    }
}