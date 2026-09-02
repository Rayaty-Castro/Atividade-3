import java.text.NumberFormat;
import java.util.Locale;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.replaceAll("\\D", "").length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }
        this.cpf = cpf;
        // O \\D e um regex que significa "tudo o que não for dígito" esse metodo substitui pontos, traços, espaços e letras por nada ""
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("O salário deve ser maior que zero.");
        }
        this.salario = salario;
    }

    // Metodo abstrato a ser implementado nas classes filho
    public abstract double calcularBonificacao();

    // Metodo concreto para calcular remuneração total
    public double calcularRemuneracaoTotal() {
        return this.salario + calcularBonificacao();
    }

    // Exibe o holerite detalhado do funcionário
    public void exibirHolerite() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("=== HOLERITE ===");
        System.out.println("Cargo: " + this.getClass().getSimpleName());
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Salário Base: " + moeda.format(this.salario));
        System.out.println("Bonificação: " + moeda.format(calcularBonificacao()));
        System.out.println("Remuneração Total: " + moeda.format(calcularRemuneracaoTotal()));
    }
}