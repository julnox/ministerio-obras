package application;

import entities.*;
import entities.enums.TipoLista;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MinisterioObras {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static HashMap<Integer, Cidadao> cidadaos = new HashMap<>();
    private static HashMap<Integer, Reclamacao> reclamacoes = new HashMap<>();

    public static void main(String[] args) {
        int opcao = 0;

        do {
            try {
                switchOpcao(opcao = menu());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                scanner.nextLine();
                scanner.nextLine();
            }
        } while (opcao != 10);

        scanner.close();
    }


    private static int menu() {
        System.out.println("|-----------------------MENU---------------------------|");
        System.out.println("| Digite (1) para criar cidadão                        |");
        System.out.println("| Digite (2) para excluir cidadão                      |");
        System.out.println("| Digite (3) para consultar um cidadão                 |");
        System.out.println("| Digite (4) para mostrar todos os cidadãos            |");
        System.out.println("| Digite (5) para registrar uma reclamação             |");
        System.out.println("| Digite (6) para excluir uma reclamação               |");
        System.out.println("| Digite (7) para consultar uma reclamação             |");
        System.out.println("| Digite (8) para mostrar todas as reclamações         |");
        System.out.println("| Digite (9) para marcar uma reclamação como resolvido |");
        System.out.println("| Digite (10) para sair                                |");
        System.out.println("|-----------------------MENU---------------------------|");
        System.out.print("Seu input: ");

        return scanner.nextInt();
    }

    private static void switchOpcao(int opcao) {
        int quantidade;

        switch (opcao) {
            case 1:
                System.out.println("|---------------------ADICIONAR------------------------|");
                System.out.print("Digite a quantidade de cidadãos: ");
                quantidade = quantidadeAdicionar();
                for (int i = 1; i <= quantidade; i++) {
                    System.out.println("CIDADÃO #" + i);
                    scanner.nextLine();
                    criarCidadao();
                }
                System.out.println("|---------------------ADICIONAR------------------------|");
                break;
            case 2:
                System.out.println("|----------------------REMOVER-------------------------|");
                System.out.print("Digite a quantidade de cidadãos: ");
                quantidade = quantidadeRemover(TipoLista.CIDADAO);
                for (int i = 1; i <= quantidade; i++) {
                    System.out.printf("Digite o ID do cidadão #%d: ", i);
                    cidadaos.remove(scanner.nextInt());
                }
                System.out.println("|----------------------REMOVER-------------------------|");
                break;
            case 3:
                System.out.println("|---------------------CONSULTAR------------------------|");
                System.out.print("Digite o ID do cidadão: ");
                System.out.println(cidadaos.get(scanner.nextInt()));
                System.out.println("|---------------------CONSULTAR------------------------|");
                break;
            case 4:
                System.out.println("|---------------------CONSULTAR------------------------|");
                for (Map.Entry<Integer, Cidadao> e : cidadaos.entrySet()) {
                    System.out.println(e.getValue().toString() + "\n");
                }
                System.out.println("|---------------------CONSULTAR------------------------|");
                break;
            case 5:
                System.out.println("|---------------------ADICIONAR------------------------|");
                System.out.print("Digite a quantidade de reclamações: ");
                quantidade = quantidadeAdicionar();
                for (int i = 1; i <= quantidade; i++) {
                    System.out.println("RECLAMAÇÃO #" + i);
                    criarReclamacao();
                }
                System.out.println("|---------------------ADICIONAR------------------------|");
                break;
            case 6:
                System.out.println("|----------------------REMOVER-------------------------|");
                System.out.print("Digite a quantidade de reclamações: ");
                quantidade = quantidadeRemover(TipoLista.RECLAMACAO);
                for (int i = 1; i <= quantidade; i++) {
                    System.out.printf("Digite o ID da reclamação #%d: ", i);
                    reclamacoes.remove(scanner.nextInt());
                }
                System.out.println("|----------------------REMOVER-------------------------|");
                break;
            case 7:
                System.out.println("|---------------------CONSULTAR------------------------|");
                System.out.print("Digite o ID da reclamação: ");
                System.out.println(reclamacoes.get(scanner.nextInt()));
                System.out.println("|---------------------CONSULTAR------------------------|");
                break;
            case 8:
                System.out.println("|---------------------CONSULTAR------------------------|");
                for (Map.Entry<Integer, Reclamacao> e : reclamacoes.entrySet()) {
                    System.out.println(e.getValue().toString() + "\n");
                }
                System.out.println("|---------------------CONSULTAR------------------------|");
                break;
            case 9:
                System.out.println("|---------------------ATUALIZAR------------------------|");
                System.out.print("Digite o ID da reclamação: ");
                System.out.println(reclamacoes.get(scanner.nextInt()));
                System.out.println("|---------------------ATUALIZAR------------------------|");
            default:
                break;
        }
    }

    private static void criarCidadao() {
        int rua, numero, id;
        long cepLong;
        String bairro, cep;
        Cidadao cidadao;

        System.out.print("Digite um nome: ");
        String nome = scanner.nextLine();

        id = random.nextInt(1500);
        while(checarId(TipoLista.CIDADAO, id)){
            id = random.nextInt(1500);
        }

        cidadao = new Cidadao(id, nome);

        System.out.print("Digite a rua da residência: ");
        rua = scanner.nextInt();
        System.out.print("Digite o número da residência: ");
        numero = scanner.nextInt();
        System.out.print("Digite o bairro da residência: ");
        scanner.nextLine();
        bairro = scanner.nextLine();
        System.out.print("Digite o cep da residência: ");
        cepLong = scanner.nextLong();
        cep = Long.toString(cepLong);

        cidadao.setEndereco(new Endereco(rua, numero, bairro, cep));

        System.out.println("ID DO CIDADÃO: " + cidadao.getId());

        cidadaos.put(cidadao.getId(), cidadao);
    }

    private static void criarReclamacao() {
        int quantProblema, idCidadao, id;
        Reclamacao reclamacao;

        System.out.print("Digite o ID do cidadão autor da reclamação: ");
        idCidadao = scanner.nextInt();
        if (cidadaos.get(idCidadao) == null) {
            throw new IllegalArgumentException("ID de cidadão invalido");
        }

        id = random.nextInt(1500);
        while(checarId(TipoLista.RECLAMACAO, id)) {
            id = random.nextInt(1500);
        }
        Problema problema = criarProblema();

        reclamacao = new Reclamacao(id, cidadaos.get(idCidadao), problema);

        System.out.println("ID DA RECLAMAÇÃO: " + reclamacao.getId());
        reclamacoes.put(reclamacao.getId(), reclamacao);
    }

    private static Problema criarProblema() {
        char tipoProblema;

        System.out.print("O problema é um buraco na via? (s/n) ");
        tipoProblema = scanner.next().toLowerCase().charAt(0);
        System.out.print("Detalhe o problema: ");
        scanner.nextLine();
        String relato = scanner.nextLine();

        if (tipoProblema == 's') {
            int tamanho, localizacao;

            System.out.print("Digite o tamanho do buraco em uma escala de 0 a 10: ");
            tamanho = scanner.nextInt();
            if (tamanho < 0 || tamanho > 10) {
                throw new IllegalArgumentException("Tamanho invalido");
            }

            System.out.println("Localização: ");
            System.out.println("Digite (1) para rua");
            System.out.println("Digite (2) para calçada");
            System.out.print("Digite a localização: ");
            localizacao = scanner.nextInt();
            if (localizacao > 2 || localizacao < 1) {
                throw new IllegalArgumentException("Localização Invalida");
            }

            return new Buraco(relato, tamanho, localizacao);

        } else {
            return new Problema(relato);
        }
    }

    private static int quantidadeAdicionar() {
        int quantidade;

        quantidade = scanner.nextInt();

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade invalida");
        }

        return quantidade;
    }

    private static int quantidadeRemover(TipoLista tipoLista) {
        int quantidade;

        quantidade = scanner.nextInt();

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade invalida");
        } else if (tipoLista == TipoLista.valueOf("CIDADAO")) {
            if (quantidade > cidadaos.size()) {
                throw new IllegalArgumentException("Quantidade maior que lista de cidadãos");
            }
        } else if (tipoLista == TipoLista.valueOf("RECLAMACAO")) {
            if (quantidade > reclamacoes.size()) {
                throw new IllegalArgumentException("Quantidade maior que lista de reclamações");
            }
        }
        return quantidade;
    }

    private static boolean checarId(TipoLista tipoLista, int id){
        if (tipoLista == TipoLista.RECLAMACAO){
            return reclamacoes.get(id) != null;
        } else{
            return cidadaos.get(id) != null;
        }
    }
}
