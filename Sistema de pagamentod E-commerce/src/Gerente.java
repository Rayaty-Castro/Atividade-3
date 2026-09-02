public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    // Gerente recebe 20% do salário como bonificação
    @Override
    // esse Overide está relacionado a classe Funcionario, ele reescreve o calcularBonificacao da classe pai Funionario para essa classe filho que e essa
    public double calcularBonificacao() {
        return getSalario() * 0.20;
    }
}