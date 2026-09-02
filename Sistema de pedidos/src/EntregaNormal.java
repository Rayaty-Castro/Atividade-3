public class EntregaNormal extends Entrega {

    public EntregaNormal(String destino) {
        super(destino);
    }

    @Override
    public double calcularFrete(double pesoProdutos) {
        // Regra de frete normal: R$ 5,00 por kg
        return pesoProdutos * 5.0;
    }

    @Override
    public int calcularPrazo() {
        return 7; // Regra 3
    }

    @Override
    public String getNomeModalidade() {
        return "Entrega Normal";
    }
}