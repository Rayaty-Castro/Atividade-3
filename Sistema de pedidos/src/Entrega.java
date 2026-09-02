public abstract class Entrega {
    private String destino;

    public Entrega(String destino) {
        setDestino(destino);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        if (destino == null || destino.trim().isEmpty()) {
            throw new IllegalArgumentException("Destino é obrigatório.");
        }
        this.destino = destino;
    }

    public abstract double calcularFrete(double pesoProdutos);
    public abstract int calcularPrazo();
    public abstract String getNomeModalidade();
}