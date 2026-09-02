import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EntregaAgendada extends Entrega {
    private LocalDate dataAgendada;

    public EntregaAgendada(String destino, LocalDate dataAgendada) {
        super(destino);
        setDataAgendada(dataAgendada);
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        if (dataAgendada == null || dataAgendada.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de entrega agendada deve ser futura.");
        }
        this.dataAgendada = dataAgendada;
    }

    @Override
    public double calcularFrete(double pesoProdutos) {
        // Regra de frete agendado: R$ 8,00 por kg + R$ 15,00 taxa de agendamento
        return (pesoProdutos * 8.0) + 15.0;
    }

    @Override
    public int calcularPrazo() {
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), dataAgendada);
    }

    @Override
    public String getNomeModalidade() {
        return "Entrega Agendada";
    }
}