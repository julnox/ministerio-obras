package application;

import entities.Cidadao;
import entities.Endereco;
import entities.Reclamacao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MinisterioObras {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final HashMap<Integer, Cidadao> cidadaos = new HashMap<>();
    private static final HashMap<Integer, Reclamacao> reclamacoes = new HashMap<>();

    public static void main(String[] args) {
        int opcao;

        try {
            do {
                switchOpcao(opcao = menu());
            } while (opcao != 8);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int menu() {
        System.out.println("     <<Secretária de Obras Gama>>");
        System.out.println("Digite (1) para criar cidadão");
        System.out.println("Digite (2) para excluir cidadão");
        System.out.println("Digite (3) para consultar um cidadão");
        System.out.println("Digite (4) para mostrar todos os cidadãos");
        System.out.println("Digite (5) para registrar uma reclamação");
        System.out.println("Digite (6) para excluir uma reclamação");
        System.out.println("Digite (7) para consultar uma reclamação");
        System.out.println("Digite (8) para mostrar todas as reclamações");
        System.out.println("Digite (9) para marcar uma reclamação como resolvido");
        System.out.println("Digite (10) para sair");
        System.out.print("Seu input: ");

        return scanner.nextInt();
    }

    private static void switchOpcao(int opcao) {
        int quantidade;

        switch (opcao) {
            case 1:
                System.out.println("----ADICIONAR----");
                quantidade = quantidadeElementos();
                for (int i = 1; i <= quantidade; i++){
                    System.out.println("CIDADÃO #" + i);
                    criarCidadao();
                }
                System.out.println("----ADICIONAR----");
                break;
            case 2:
                System.out.println("----REMOVER----");
                quantidade = quantidadeElementos();
                if (quantidade > cidadaos.size()){
                    throw new IllegalArgumentException("Erro: Quantidade maior que elementos na lista");
                }
                for (int i = 1; i<= quantidade; i++){
                    System.out.printf("Digite o ID do cidadão #%d: ", i);
                    cidadaos.remove(scanner.nextInt());
                }
                System.out.println("----REMOVER----");
                break;
            case 3:
                System.out.println("----CONSULTA----");
                System.out.print("Digite o ID do cidadão: ");
                System.out.println(cidadaos.get(scanner.nextInt()));
                System.out.println("----CONSULTA----");
                break;
            case 4:
                System.out.println("----CONSULTA----");
                for (Map.Entry<Integer, Cidadao> e : cidadaos.entrySet()){
                    System.out.println(e.toString());
                }
                System.out.println("----CONSULTA----");
                break;
            case 5:
                System.out.println("----ADICIONAR----");
                quantidade = quantidadeElementos();
                for (int i = 1; i <= quantidade; i++){

                }

                System.out.println("----ADICIONAR----");

                break;
            case 6:
                break;
            case 7:
                break;
            default:
                break;
        }
    }
    private static void criarCidadao(){
        Cidadao cidadao;

        int id = random.nextInt();

        System.out.println("ID DO CIDADÃO: " + id);
        System.out.print("Digite um nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        long cpfLong = scanner.nextLong();
        String cpf = Long.toString(cpfLong);

        if (cpf.length() != 11){
            throw new IllegalArgumentException("CPF deve ser 11 dígitos");
        }
        cidadao = new Cidadao(nome, cpf);

        System.out.println("Digite a rua da residência: ");
        int rua = scanner.nextInt();
        System.out.println("Digite o número da residência: ");
        int numero = scanner.nextInt();
        System.out.println("Digite o bairro da residência: ");
        String bairro = scanner.nextLine();
        System.out.println("Digite o cep da residência: ");
        long cepLong = scanner.nextLong();
        String cep = Long.toString(cepLong);

        cidadao.setEndereco(new Endereco(rua, numero, bairro, cep));

        cidadaos.put(id, cidadao);
    }
    private static void criarReclamacao(){
        Reclamacao reclamacao;
        int id = random.nextInt();

        System.out.println("ID DA RECLAMAÇÃO: " + id);
        System.out.println("Digite o ID do cidadão autor da reclamação: ");
        int idCidadao = scanner.nextInt();
        if (cidadaos.get(idCidadao) == null){
            throw new IllegalArgumentException("ID de cidadão invalido");
        }
        quantidadeElementos();
    }
    private static void criarProblema(){

    }
    private static int quantidadeElementos(){
        int quantidade;

        System.out.print("Digite a quantidade: ");
        quantidade = scanner.nextInt();

        if (quantidade <= 0){
            throw new IllegalArgumentException("Quantidade invalida");
        }

        return quantidade;
    }
}
