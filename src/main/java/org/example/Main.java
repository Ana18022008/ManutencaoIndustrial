package org.example;

import com.manutencaoindustrial.service.Gerenciador;
import com.manutencaoindustrial.view.View;

public class Main {
    public static void main(String[] args) {

      int escolha = -1;
      View view = new View();
      Gerenciador gerenciador = new Gerenciador();
       do{

       }while (escolha != 0);
        escolha = view.menu();
        gerenciador.Gerenciar(view, escolha);
        }

    }
