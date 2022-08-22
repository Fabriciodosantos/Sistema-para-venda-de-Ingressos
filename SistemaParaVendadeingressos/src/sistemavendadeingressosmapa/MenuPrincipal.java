package sistemavendadeingressosmapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private int opcaoEscolhida;
    private List<Evento> listaEvento;

    public List<Evento> getListaEvento(int op) {
        return listaEvento;
    }

    public void setListaEvento(List<Evento> listaEvento) {
        this.listaEvento = listaEvento;
    }

    Scanner scanner = new Scanner(System.in);
    private Ingresso ing;

    public void menuPrincipal() {
        this.listaEvento = new ArrayList<>();
        do {
            Evento evento = new Evento();
            System.out.println("==================================");

            System.out.println("# SISTEMA DE VENDER INGRESSOS #");
            System.out.println("==================================");

            System.out.println("Menu: ");
            this.mostrarOpcoes();
            System.out.print("Digite a opção de escolha:");
            this.setOpcaoEscolhida(scanner.nextInt());
            System.out.println("----------------------------------");

            System.out.println("\n");

            switch (this.getOpcaoEscolhida()) {
                case 1:
                    System.out.println("==================================");
                    System.out.println("# CADASTRAR NOVO EVENTO #");
                    System.out.println("==================================");

                    Evento novoEvento = evento.criarEvento();
                    this.listaEvento.add(novoEvento);

                    break;
                case 2:
                    System.out.println("==================================");
                    System.out.println("# VER EVENTOS #");
                    System.out.println("==================================");
                    evento.mostrarEventos(this.listaEvento, false);

                    break;

                case 3:
                    System.out.println("==================================");
                    System.out.println("# VENDER INGRESSOS #");
                    System.out.println("==================================");
                    System.out.println("*Selecione o Evento que deseja comprar Ingressos:");
                    System.out.println("----------------------------------");
                    evento.mostrarEventos(this.listaEvento, false);
                    System.out.println("----------------------------------");
                    System.out.print("Digite o numero referente ao evento escolhido:");
                    int opcaoEscolhidaParaEvento = scanner.nextInt();
                    System.out.println("----------------------------------");
                    if (opcaoEscolhidaParaEvento > 0 && opcaoEscolhidaParaEvento <= this.listaEvento.size()) {//Size = temanho da lista

                        this.listaEvento.get(opcaoEscolhidaParaEvento - 1).venderIngresso();

                    } else {
                        System.out.println("Evento inexistente.");
                    }

                    break;

                case 4:
                    System.out.println("==================================");
                    System.out.println("# QUANTIDADE DE INGRESSOS VENDIDOS #");
                    System.out.println("==================================");
                    evento.mostrarEventos(this.listaEvento, true);

                    break;

                case 5:
                    System.out.println("==================================");
                    System.out.println("# DADOS DOS INGRESSOS VENDIDOS #");
                    System.out.println("==================================");
                    evento.mostrarEventos(listaEvento, false);
                    System.out.print("Selecione o evento, para ver dados dos igressos: ");
                    int eventoSelecionadoParaVerIngressos = scanner.nextInt();

                    if (eventoSelecionadoParaVerIngressos > 0 && eventoSelecionadoParaVerIngressos <= this.listaEvento.size()) {//Size = temanho da lista

                        this.listaEvento.get(eventoSelecionadoParaVerIngressos - 1).mostrarIngressosVendidos(false);

                    }

                    break;

                case 0:
                    System.out.println("Volte Sempre.");
                    break;

                default:
                    System.out.println("Opção Invalida, Escolha Novamente!");

            }
            System.out.println("----------------------------------");
            System.out.println("\n");

        } while (this.getOpcaoEscolhida() != 0);

    }

    public int getOpcaoEscolhida() {
        return opcaoEscolhida;
    }

    public void setOpcaoEscolhida(int opcaoEscolhida) {
        this.opcaoEscolhida = opcaoEscolhida;
    }

    private void mostrarOpcoes() {
        System.out.println("1: Cadastrar novo evento. ");
        System.out.println("2: Ver Eventos.");
        System.out.println("3: Vender ingressos.");
        System.out.println("4: Mostrar quantidade de ingressos vendidos.");
        System.out.println("5: Mostrar dados dos ingressos vendidos.");
        System.out.println("0: Sair");
        System.out.println("----------------------------------");
    }

}
