public class EntregaExpressa extends Entrega {

    public EntregaExpressa(String destino) {
        super(destino);
    }

    @Override
    public double calcularFrete(double pesoProdutos) {
        // Regra de frete expresso: R$ 10,00 por kg + taxa fixa de R$ 7,50
        return (pesoProdutos * 10.0) + 7.50;
    }

    @Override
    public int calcularPrazo() {
        return 2; // Regra 4
    }

    @Override
    public String getNomeModalidade() {
        return "Entrega expressa";
    }
}