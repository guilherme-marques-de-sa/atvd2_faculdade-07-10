import java.util.Scanner;

public class Estacionamento {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int capacidade = 4;

        int totalVeiculos = 0;
        int veiculosEletricos = 0;
        int veiculosDiaria = 0;
        double totalArrecadado = 0.0;

        System.out.println("==========================================");
        System.out.println("   SISTEMA DE COBRANÇA DE ESTACIONAMENTO");
        System.out.println("==========================================");

        for (int i = 1; i <= capacidade; i++) {

            System.out.println("\n------------------------------------------");
            System.out.println("VEÍCULO " + i);
            System.out.println("------------------------------------------");

            System.out.print("Tempo de permanência (horas): ");
            int horas = scanner.nextInt();

            System.out.println("Tipo do veículo:");
            System.out.println("1 - Convencional");
            System.out.println("2 - Elétrico");
            System.out.print("Escolha: ");
            int tipo = scanner.nextInt();

            if (horas <= 0 || (tipo != 1 && tipo != 2)) {

                System.out.println("\nERRO: Entrada inválida!");
                System.out.println(
                    "Informe horas maiores que zero e tipo 1 ou 2."
                );

                i--;

            } else {

                double valor;

                if (horas <= 1) {

                    valor = 10.00;

                } else if (horas <= 3) {

                    valor = 10.00 + (horas - 1) * 5.00;

                } else {

                    valor = 30.00;
                    veiculosDiaria++;
                }

                if (tipo == 2) {

                    valor = valor * 0.80;
                    veiculosEletricos++;

                    System.out.println(
                        "Desconto ecológico de 20% aplicado!"
                    );
                }

                totalVeiculos++;
                totalArrecadado += valor;

                System.out.printf(
                    "Valor da cobrança: R$ %.2f%n",
                    valor
                );

                System.out.println(
                    "Veículo registrado com sucesso!"
                );
            }
        }

        System.out.println("\n==========================================");
        System.out.println("          RELATÓRIO CONSOLIDADO");
        System.out.println("==========================================");

        System.out.println(
            "Total de veículos atendidos: "
            + totalVeiculos
        );

        System.out.printf(
            "Total arrecadado: R$ %.2f%n",
            totalArrecadado
        );

        System.out.println(
            "Veículos elétricos atendidos: "
            + veiculosEletricos
        );

        System.out.println(
            "Veículos que utilizaram a diária: "
            + veiculosDiaria
        );

        System.out.println("==========================================");
        System.out.println("             FIM DO TURNO");
        System.out.println("==========================================");

        scanner.close();
    }
}
