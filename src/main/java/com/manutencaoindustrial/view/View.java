package com.manutencaoindustrial.view;
import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.model.OrdemManutencao;
import com.manutencaoindustrial.model.Peca;
import com.manutencaoindustrial.model.Tecnico;
import com.manutencaoindustrial.service.Gerenciador;

import java.util.Scanner;

public class View {
    Scanner sc = new Scanner (System.in);

    public void Gerenciador(){
        Gerenciador gerenciador = new Gerenciador();
    }

    public int menu(){
        System.out.println("\n ------- MENU -------");
        System.out.println(" 1. Cadastrar Máquina");
        System.out.println(" 2. Cadastrar Técnico");
        System.out.println(" 3. Cadastrar Peça");
        System.out.println(" 4. Criar Ordem de Manutenção");
        System.out.println(" 5. Associar Peças à Ordem");
        System.out.println(" 6. Executar Manutenção ");
        System.out.print("\n 0. Sair \n > ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    public String nome(String tipo, String entidade){
        System.out.printf("----------- | %s | ------------", tipo);
        System.out.printf("\n Insira o nome : \n > " , entidade);
        return sc.nextLine();
    }

    public String setor(){
        System.out.print("\n Insira o setor : \n > ");
        return sc.nextLine();
    }

    public String especialidade(){
        System.out.print("\n Especialidade : \n > ");
        return sc.nextLine();
    }

        public String estoque(){
        System.out.println("Estoque inicial: ");
            return sc.nextLine();
    }

    public void visualizarMaquinas(Maquina maquina){
        System.out.println("\n" + maquina.toString());
    }

    public void visualizarTecnicos(Tecnico tecnico){
        System.out.println("\n " + tecnico.toString());
    }

    public void visualizarOrdemManutencao(OrdemManutencao ordemManutencao){
        System.out.println("\n" + ordemManutencao.toString());
    }

    public void visualizarPeca(Peca peca){
        System.out.println("\n " + peca.toString());
    }

    public void ordemManutencao(){
        System.out.println(" -------- ORDEM DE MANUTENÇÃO ---------");
    }

    public int escolhaID(String entidade){
        System.out.printf("\n Escolha o %s pelo ID: " , entidade);
        return sc.nextInt();
    }

    public double escolhaQuantidade(){
        System.out.println("\n Quantidade de peças necessárias : ");
        return sc.nextDouble();
    }

    public int adicionarNovaPeca(){
        System.out.println("\n - Adicionar nova Peça -");
        System.out.println(" 1. Sim");
        System.out.println(" 2. Não");
        return sc.nextInt();
    }

    public void duplicata (String entidade){
        System.out.printf("\n ERRO! O registro %s já foi feito!" , entidade);
    }

    public void sucessoCadastro(String entidade){
        System.out.printf("\n %s cadastrado com sucesso! " , entidade);
    }

    public void erroCadastro(String entidade){
        System.out.printf("\n Erro ao cadastrar%s." , entidade);
    }

}
