package sistemavendadeingressosmapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Atributos
public class Evento {

    private String nome;
    private String data;
    private float valorUnico;
    private int capacidadeMaxima;
    private boolean statusEvento;
    private List<Ingresso> ingressosVendidos;

    Scanner scanner = new Scanner(System.in);

    //Metodo Construtor
    public Evento() {
        this.ingressosVendidos = new ArrayList<>();
        this.setStatusEvento(false);
        this.setNome("");
        this.setData("Defina a data.");
        this.setValorUnico(00);
        this.setCapacidadeMaxima(00);
    }

    //Metodo para verificar status atual dos atributos
    public void status() {
        System.out.println("* EVENTO CADASTRADO *");
        System.out.println("Status: " + this.getStatusEvento());
        System.out.println("Evento: " + this.getNome());
        System.out.println("Data: " + this.getData());
        System.out.println("Valor Unico: " + this.getValorUnico());
        System.out.println("Capacidade Maxima: " + this.getCapacidadeMaxima());
        System.out.println("----------------------------------");
    }

    //Getters e Setters
    public boolean getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(boolean statusEvento) {
        this.statusEvento = statusEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValorUnico() {
        return valorUnico;
    }

    public void setValorUnico(float valorUnico) {
        this.valorUnico = valorUnico;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(List<Ingresso> ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }

    //Metodos De funcionalidade da classe.
    public Evento criarEvento() {
        Evento novoEvento = new Evento();

        novoEvento.setStatusEvento(true);
        System.out.print("Nome do Evento: ");

        novoEvento.setNome(scanner.nextLine());

        System.out.print("Data: ");
        novoEvento.setData(scanner.nextLine());

        System.out.print("Valor unico: ");
        novoEvento.setValorUnico(scanner.nextFloat());

        System.out.print("Capacidade Maxima: ");
        novoEvento.setCapacidadeMaxima(scanner.nextInt());

        System.out.println("Evento cadastrado com sucesso.");

        return novoEvento;
    }

    public void venderIngresso() {
        Ingresso novoIngresso = new Ingresso();
        System.out.println("*VENDA DE INGRESSOS*");
        System.out.println("Evento: " + this.getNome());
        System.out.println("----------------------------------");

        if (this.getStatusEvento()) {
            System.out.println("Processo de venda aberto.");
            System.out.println("----------------------------------");
        } else {
            System.out.println("ERRO: Evento inexistente.");
            return;
        }
        if (this.ingressosVendidos.size() == this.getCapacidadeMaxima()) {
            System.out.println("Evento Lotado.");
            System.out.println("----------------------------------");
            return;
        }
        novoIngresso.setEventoRelacionado(this.getNome());

        System.out.println("*Cadastar dados do ingresso*");
        System.out.print("Nome do Comprador: ");
        Scanner scannerIngresso = new Scanner(System.in);
        novoIngresso.setNomeIngresso(scannerIngresso.nextLine());
        System.out.print("CPF: ");
        novoIngresso.setCpf(scannerIngresso.nextLine());
        this.mostrarTipodeIngresso();
        System.out.print("Digite o tipo de Ingresso: ");
        int escolherTipodeIngresso = scannerIngresso.nextInt();

        if (escolherTipodeIngresso == 1 || escolherTipodeIngresso == 2 || escolherTipodeIngresso == 3) {
            novoIngresso.calcularValor(escolherTipodeIngresso, this.getValorUnico());
        } else {
            System.out.println("Tipo de ingresso invalido!");
            return;
        }

        if (this.ingressosVendidos.size() < this.getCapacidadeMaxima()) {
            this.ingressosVendidos.add(novoIngresso);
            System.out.println("Compra efetuada com Sucesso.\n");
            System.out.println("----------------------------------");

            novoIngresso.mostrarDadosIngresso(this, true);
            System.out.println("----------------------------------");
        } else {
            System.out.println("Ingressos esgotados!");

        }

        System.out.println("Ainda restam " + (this.getCapacidadeMaxima() - this.ingressosVendidos.size()) + " Ingressos.");

    }

    public void mostrarEventos(List<Evento> listaEvento, boolean mostrarQuantidadeIngressos) {
        System.out.println("*Eventos Cadastrados:*");

        for (int i = 0; i < listaEvento.size(); i++) {
            System.out.println((i + 1) + " - Evento: " + listaEvento.get(i).getNome());
            if (mostrarQuantidadeIngressos) {
                System.out.println("Ingressos Vendidos: " + listaEvento.get(i).getIngressosVendidos().size());
                System.out.println("Ingressos Restantes: " + (listaEvento.get(i).getCapacidadeMaxima() - listaEvento.get(i).getIngressosVendidos().size()));
                System.out.println("----------------------------------");
            }

        }
    }

    public void mostrarIngressosVendidos(boolean dadosIngresso) {
        for (Ingresso ingressoVendido : this.getIngressosVendidos()) {
            ingressoVendido.mostrarDadosIngresso(this, false);
        }

    }

    public void mostrarTipodeIngresso() {
        System.out.println("Tipo de Ingresso: ");
        System.out.println("1: Pista.");
        System.out.println("2: Vip.");
        System.out.println("3: Camarote.");

    }

}
