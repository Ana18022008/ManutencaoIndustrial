package org.example;

import com.manutencaoindustrial.service.Gerenciador;
import com.manutencaoindustrial.view.View;

public class Main {
    public static void main(String[] args) {

      int escolha = -1;
      View view = new View();
      Gerenciador gerenciador = new Gerenciador();
       do{
           escolha = view.menu();
           gerenciador.Gerenciar(view, escolha);
       }while (escolha != 0);
        System.out.println("Finalizando...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finalizado!");
            System.exit(0);
        }

    }
