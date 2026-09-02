import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
// usei o DateTimeParseException é um erro do Java que acontece quando o programa tenta ler um texto e não consegue transformá-lo em uma data ou hora.
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        System.out.println("    SISTEMA DE PEDIDOS E ENTREGAS VENDE MAIS");


        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n--- NOVO PEDIDO ---");

                System.out.print("Número do pedido: ");
                int numero = Integer.parseInt(scanner.nextLine());

                System.out.print("Nome do cliente: ");
                String cliente = scanner.nextLine();

                System.out.print("Valor dos produtos (R$): ");
                double valorProdutos = Double.parseDouble(scanner.nextLine().replace(",", "."));

                System.out.print("Peso total (kg): ");
                double pesoTotal = Double.parseDouble(scanner.nextLine().replace(",", "."));

                System.out.println("\nEscolha a modalidade de entrega:");
                System.out.println("1 - Entrega Normal");
                System.out.println("2 - Entrega Expressa");
                System.out.println("3 - Retirada na Loja");
                System.out.println("4 - Entrega Agendada");
                System.out.print("Opção: ");

                int opcaoEntrega = Integer.parseInt(scanner.nextLine());
                Entrega entrega = criarEntrega(opcaoEntrega);

                // Cria o pedido e exibe o resumo com os valores informados
                Pedido pedido = new Pedido(numero, cliente, valorProdutos, pesoTotal, entrega);

                System.out.println("\n===RESUMO===");
                pedido.exibirResumo();

            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Por favor, insira números válidos para código, valor e peso.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERRO DE VALIDAÇÃO] " + e.getMessage());
            }

            System.out.print("Deseja cadastrar outro pedido? (S/N): ");
            String resposta = scanner.nextLine().trim();
            continuar = resposta.equalsIgnoreCase("S");
        }

        System.out.println("\nSistema encerrado. Obrigado!");
    }

    private static Entrega criarEntrega(int opcao) {
        switch (opcao) {
            case 1:
                System.out.print("Endereço de destino: ");
                String destinoNormal = scanner.nextLine();
                return new EntregaNormal(destinoNormal);

            case 2:
                System.out.print("Endereço de destino: ");
                String destinoExpresso = scanner.nextLine();
                return new EntregaExpressa(destinoExpresso);

            case 3:
                System.out.print("Nome/Identificação da Loja para retirada: ");
                String loja = scanner.nextLine();
                return new RetiradaNaLoja(loja);

            case 4:
                System.out.print("Endereço de destino: ");
                String destinoAgendado = scanner.nextLine();

                System.out.print("Data da entrega (formato DD/MM/AAAA): ");
                String dataInput = scanner.nextLine();
                try {
                    LocalDate dataAgendada = LocalDate.parse(dataInput, FORMATO_DATA);
                    return new EntregaAgendada(destinoAgendado, dataAgendada);
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Formato de data inválido! Use DD/MM/AAAA.");
                }

            default:
                throw new IllegalArgumentException("Opção de entrega inválida.");
        }
    }
}