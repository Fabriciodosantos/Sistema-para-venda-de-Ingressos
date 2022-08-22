package sistemavendadeingressosmapa;

public class Ingresso {

    private String nomeIngresso;
    private String cpf;
    private String eventoRelacionado;
    private String tipoIngresso;
    private Float valor;

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Ingresso() {
        this.setNomeIngresso("");
        this.setCpf("");
        this.setEventoRelacionado("");
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public String getNomeIngresso() {
        return nomeIngresso;
    }

    public void setNomeIngresso(String nome) {
        this.nomeIngresso = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEventoRelacionado() {
        return eventoRelacionado;
    }

    public void setEventoRelacionado(String eventoRelacionado) {
        this.eventoRelacionado = eventoRelacionado;
    }

    public void calcularValor(int tipoIngresso, float valorUnico) {
        if (tipoIngresso == 1) {
            this.setValor(valorUnico);
            this.setTipoIngresso("Pista");
        } else if (tipoIngresso == 2) {
            this.setValor(valorUnico * 1.3f);
            this.setTipoIngresso("Vip");
        } else if (tipoIngresso == 3) {
            this.setValor(valorUnico * 1.6f);
            this.setTipoIngresso("Camarote");
        }

    }

    public void mostrarDadosIngresso(Evento evento, boolean mostrarDadosIngresso) {
        System.out.println("----------------------------------");

        System.out.println("*DADOS DO INGRESSO*");
        System.out.println("Nome: " + this.getNomeIngresso());
        System.out.println("CPF: " + this.getCpf());
        if (mostrarDadosIngresso) {
            System.out.println("Evento: " + evento.getNome());
            System.out.println("Data: " + evento.getData());
            System.out.println("Tipo Ingresso: " + this.getTipoIngresso());
            System.out.println("Valor total: " + this.getValor());
            System.out.println("----------------------------------");
        }

    }
}
