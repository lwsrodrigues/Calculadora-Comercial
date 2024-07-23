import java.util.Scanner;

public class CalculadoraTroco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura do valor total da compra
        System.out.print("Valor total da compra: R$ ");
        double valorTotalCompra = scanner.nextDouble();

        // Leitura do valor recebido
        System.out.print("Valor pago: R$ ");
        double valorRecebido = scanner.nextDouble();

        // Cálculo do troco
        double troco = valorRecebido - valorTotalCompra;

        // Exibição do troco
        System.out.println("Troco: R$ " + troco);

        // Cálculo do número de notas e moedas
        int[] notas = { 100, 50, 20, 10, 5, 2, 1 };
        int[] moedasCentavos = { 50, 25, 10, 5, 1 }; // Valores das moedas em centavos

        for (int i = 0; i < notas.length; i++) {
            int quantidadeNotas = (int) (troco / notas[i]);
            troco -= quantidadeNotas * notas[i];
            System.out.println(quantidadeNotas + " nota(s) de R$ " + notas[i]);
        }

        // Convertendo o troco restante de reais para centavos
        int trocoEmCentavos = (int) Math.round(troco * 100);

        for (int i = 0; i < moedasCentavos.length; i++) {
            int quantidadeMoedas = trocoEmCentavos / moedasCentavos[i];
            trocoEmCentavos -= quantidadeMoedas * moedasCentavos[i];

            // Convertendo para valor em reais
            double valorMoeda = (double) moedasCentavos[i] / 100;
            System.out.printf("%d moeda(s) de R$ %.2f\n", quantidadeMoedas, valorMoeda);
        }

        scanner.close();
    }
}
