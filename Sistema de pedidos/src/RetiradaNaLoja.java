public class RetiradaNaLoja extends Entrega {

    public RetiradaNaLoja(String nomeLoja) {
        super(nomeLoja);
    }

    @Override
    public double calcularFrete(double pesoProdutos) {
        return 0.0; // Regra 5: sem frete
    }

    @Override
    public int calcularPrazo() {
        return 0; // Pronta para retirada
    }

    @Override
    public String getNomeModalidade() {
        return "Retirada na loja";
    }
}