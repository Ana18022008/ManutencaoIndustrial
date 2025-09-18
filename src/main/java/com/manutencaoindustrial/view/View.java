package com.manutencaoindustrial.view;
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
        System.out.println(" 6. Executar Manutenção");
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
        System.out.println("\n Insira o setor : \n > ");
        return sc.nextLine();
    }

    public void sucessoCadastro(String entidade){
        System.out.printf("\n %s cadastrado com sucesso! " , entidade);
    }

    public void erroCadastro(String entidade){
        System.out.printf("\n Erro ao cadastrar %s." , entidade);
    }

}
