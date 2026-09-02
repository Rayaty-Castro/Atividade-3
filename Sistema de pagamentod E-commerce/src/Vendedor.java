public class Vendedor extends Funcionario {
    private double totalVendidoNoMes;
    private static final double TAXA_COMISSAO = 0.05; // 5% de comissão

    public Vendedor(String nome, String cpf, double salario, double totalVendidoNoMes) {
        super(nome, cpf, salario);
        setTotalVendidoNoMes(totalVendidoNoMes);
    }

    public double getTotalVendidoNoMes() {
        return totalVendidoNoMes;
    }

    public void setTotalVendidoNoMes(double totalVendidoNoMes) {
        if (totalVendidoNoMes < 0) {
            throw new IllegalArgumentException("O total vendido não pode ser negativo.");
        }
        this.totalVendidoNoMes = totalVendidoNoMes;
    }

    public double calcularComissao() {
        return this.totalVendidoNoMes * TAXA_COMISSAO;
    }

    // Bonificação do Vendedor é a sua comissão de vendas
    //     // esse Overide está relacionado a classe Funcionario, ele reescreve o calcularBonificacao da classe pai Funionario para essa classe filho que e essa
    @Override
    public double calcularBonificacao() {
        return calcularComissao();
    }
}