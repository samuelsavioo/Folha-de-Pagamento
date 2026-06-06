import java.util.ArrayList;
import java.util.Scanner;

public class SistemaFolhaPagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Colaborador> listaColaboradores = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=======================================");
            System.out.println("   SISTEMA DE FOLHA DE PAGAMENTO");
            System.out.println("=======================================");
            System.out.println("1 - Cadastrar Colaborador");
            System.out.println("2 - Listar Colaboradores e Emitir Folha");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Novo Colaborador ---");

                    // Validação do número de registro
                    int registro = -1;
                    while (registro < 0) {
                        System.out.print("Número de registro: ");
                        registro = scanner.nextInt();
                        scanner.nextLine();
                        if (registro < 0) {
                            System.out.println("[Erro] O número de registro não pode ser negativo!");
                        }
                    }

                    System.out.print("Nome completo: ");
                    String nome = scanner.nextLine();

                    // Validação do tipo de vínculo
                    int tipo = 0;
                    while (tipo < 1 || tipo > 3) {
                        System.out.println("Tipo de vínculo:");
                        System.out.println("  1 - Funcionário Padrão");
                        System.out.println("  2 - Funcionário Comissionado");
                        System.out.println("  3 - Funcionário de Produção");
                        System.out.print("Opção: ");
                        tipo = scanner.nextInt();
                        scanner.nextLine();
                        if (tipo < 1 || tipo > 3) {
                            System.out.println("[Erro] Opção inválida! Selecione entre 1, 2 ou 3.");
                        }
                    }

                    // Instanciação do objeto base
                    Colaborador novoColaborador = new Colaborador(registro, nome, tipo);

                    // Captura e validação de dados específicos conforme o vínculo escolhido
                    if (tipo == 2) {
                        double vendas = -1;
                        while (vendas < 0) {
                            System.out.print("Valor total de vendas no mês (R$): ");
                            vendas = scanner.nextDouble();
                            if (vendas < 0) System.out.println("[Erro] O valor das vendas não pode ser negativo!");
                        }

                        double comissao = -1;
                        while (comissao < 0) {
                            System.out.print("Percentual de comissão (%): ");
                            comissao = scanner.nextDouble();
                            if (comissao < 0) System.out.println("[Erro] O percentual de comissão não pode ser negativo!");
                        }
                        novoColaborador.setDadosComissao(vendas, comissao);

                    } else if (tipo == 3) {
                        double valorPeca = -1;
                        while (valorPeca < 0) {
                            System.out.print("Valor por peça produzida (R$): ");
                            valorPeca = scanner.nextDouble();
                            if (valorPeca < 0) System.out.println("[Erro] O valor por peça não pode ser negativo!");
                        }

                        int qtdPecas = -1;
                        while (qtdPecas < 0) {
                            System.out.print("Quantidade de peças produzidas: ");
                            qtdPecas = scanner.nextInt();
                            if (qtdPecas < 0) System.out.println("[Erro] A quantidade não pode ser negativa!");
                        }
                        novoColaborador.setDadosProducao(valorPeca, qtdPecas);
                    }

                    // Salvando o colaborador estruturado dentro do ArrayList dinâmico
                    listaColaboradores.add(novoColaborador);
                    System.out.println("\n[Sucesso] Colaborador cadastrado com êxito!");
                    break;

                case 2:
                    System.out.println("\n==========================================================================");
                    System.out.println("                      RELATÓRIO DA FOLHA DE PAGAMENTO                     ");
                    System.out.println("==========================================================================");

                    if (listaColaboradores.isEmpty()) {
                        System.out.println("Nenhum colaborador cadastrado no sistema até o momento.");
                    } else {
                        // Varredura da lista dinâmica utilizando a estrutura de repetição For-Each
                        for (Colaborador colab : listaColaboradores) {
                            System.out.printf("Reg: %-5d | Nome: %-25s | Vínculo: %-13s | Salário Final: R$ %,.2f%n",
                                    colab.getNumeroRegistro(),
                                    colab.getNomeCompleto(),
                                    colab.getDescricaoTipoVinculo(),
                                    colab.calcularSalarioFinal());
                        }
                    }
                    System.out.println("==========================================================================");
                    break;

                case 3:
                    System.out.println("\nFinalizando o programa de Folha de Pagamento. Até logo!");
                    break;

                default:
                    System.out.println("\n[Erro] Opção inválida do menu! Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}