import java.text.NumberFormat;
// Usei o java.text.NumberFormat pois ele muda o número automaticamente para a moeda local do usuário, seria por exempo 1.30 no Brasil e 1,30 nos EUA
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("=== CADASTRO DE FUNCIONÁRIOS ===");

        // Passo 1. Cadastrar Gerente
        System.out.println("\n Dados do Gerente");
        System.out.print("Nome: ");
        String nomeGerente = scanner.nextLine();
        System.out.print("CPF (somente números): ");
        String cpfGerente = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioGerente = scanner.nextDouble();
        scanner.nextLine();
        Gerente gerente = new Gerente(nomeGerente, cpfGerente, salarioGerente);
        funcionarios.add(gerente);

        // 2. Cadastrar Desenvolvedor
        System.out.println("\n Dados do Desenvolvedor");
        System.out.print("Nome: ");
        String nomeDev = scanner.nextLine();
        System.out.print("CPF (somente números): ");
        String cpfDev = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioDev = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        Desenvolvedor dev = new Desenvolvedor(nomeDev, cpfDev, salarioDev);
        funcionarios.add(dev);

        // 3. Cadastrar Vendedor
        System.out.println("\n Dados do Vendedor");
        System.out.print("Nome: ");
        String nomeVendedor = scanner.nextLine();
        System.out.print("CPF (somente números): ");
        String cpfVendedor = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioVendedor = scanner.nextDouble();
        System.out.print("Total Vendido no Mês: ");
        double vendasVendedor = scanner.nextDouble();

        Vendedor vendedor = new Vendedor(nomeVendedor, cpfVendedor, salarioVendedor, vendasVendedor);
        funcionarios.add(vendedor);

        // Exibição dos Holerites
        System.out.println("\n\n=== EMISSÃO DE HOLERITES ===");
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirHolerite();
        }

        // Cálculo da Folha de Pagamento
        double totalFolha = 0;
        for (Funcionario funcionario : funcionarios) {
            totalFolha += funcionario.calcularRemuneracaoTotal();
        }

        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("TOTAL DA FOLHA DE PAGAMENTO: " + moeda.format(totalFolha));

        scanner.close();
    }
}