public class Pedido {
    private int numero;
    private String cliente;
    private double valorProdutos;
    private double pesoTotal;
    private Entrega modalidadeEntrega;

    public Pedido(int numero, String cliente, double valorProdutos, double pesoTotal, Entrega modalidadeEntrega) {
        setCliente(cliente); // Executa a validação do nome

        if (valorProdutos <= 0) {
            throw new IllegalArgumentException("O valor dos produtos deve ser maior que zero.");
        }
        if (pesoTotal <= 0) {
            throw new IllegalArgumentException("O peso total deve ser maior que zero.");
        }
        if (modalidadeEntrega == null) {
            throw new IllegalArgumentException("A modalidade de entrega é obrigatória.");
        }

        this.numero = numero;
        this.valorProdutos = valorProdutos;
        this.pesoTotal = pesoTotal;
        this.modalidadeEntrega = modalidadeEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }

        // Expressão regular: Permite apenas letras (incluindo acentuadas e ç) e espaços
        if (!cliente.matches("^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\s]+$")) {
            throw new IllegalArgumentException("O nome do cliente deve conter apenas letras.");
        }

        this.cliente = cliente;
    }

    public double calcularFrete() {
        return modalidadeEntrega.calcularFrete(pesoTotal);
    }

    public double calcularTotal() {
        return valorProdutos + calcularFrete();
    }

    public void exibirResumo() {
        System.out.println("Pedido: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Modalidade: " + modalidadeEntrega.getNomeModalidade());
        System.out.printf("Produtos: R$ %.2f\n", valorProdutos);
        System.out.printf("Peso: %.2f kg\n", pesoTotal);
        System.out.printf("Frete: R$ %.2f\n", calcularFrete());
        System.out.printf("Total: R$ %.2f\n", calcularTotal());
        System.out.println("Prazo: " + modalidadeEntrega.calcularPrazo() + " dias");
        System.out.println("----------------------------------------");
    }
}