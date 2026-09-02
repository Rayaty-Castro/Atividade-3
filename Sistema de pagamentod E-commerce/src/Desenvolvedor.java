public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    // Desenvolvedor recebe 10% do salário como bonificação
   //    // esse Overide está relacionado a classe Funcionario, ele reescreve o calcularBonificacao da classe pai Funionario para essa classe filho que e essa
    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.10;
    }
}