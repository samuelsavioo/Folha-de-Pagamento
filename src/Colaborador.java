public class Colaborador {
    // Constante obrigatória do sistema
    public static final double SALARIO_BASE = 2000.00;

    // Atributos
    private int numeroRegistro;
    private String nomeCompleto;
    private int tipoVinculo;
    private double valorVendas;
    private double percentualComissao;
    private double valorPorPeca;
    private int quantidadeProduzida;

    // Inicialização do objeto
    public Colaborador(int numeroRegistro, String nomeCompleto, int tipoVinculo) {
        this.numeroRegistro = numeroRegistro;
        this.nomeCompleto = nomeCompleto;
        this.tipoVinculo = tipoVinculo;
    }

    // Cálculo de acordo com as regras de negócio
    public double calcularSalarioFinal() {
        switch (this.tipoVinculo) {
            case 2: // Comissionado
                double comissao = (this.valorVendas * this.percentualComissao) / 100.0;
                return SALARIO_BASE + comissao;
            case 3: // Produção
                double bonus = this.valorPorPeca * this.quantidadeProduzida;
                return SALARIO_BASE + bonus;
            case 1: // Padrão
            default:
                return SALARIO_BASE;
        }
    }

    // Getters e Setters para manipulação segura dos dados cadastrados
    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setDadosComissao(double valorVendas, double percentualComissao) {
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public void setDadosProducao(double valorPorPeca, int quantidadeProduzida) {
        this.valorPorPeca = valorPorPeca;
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public String getDescricaoTipoVinculo() {
        switch (this.tipoVinculo) {
            case 1: return "Padrão";
            case 2: return "Comissionado";
            case 3: return "Produção";
            default: return "Desconhecido";
        }
    }
}