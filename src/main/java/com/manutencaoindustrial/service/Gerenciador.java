package com.manutencaoindustrial.service;
import com.manutencaoindustrial.dao.MaquinaDAO;
import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.manutencaoindustrial.model.Maquina.Status.Operacional;

public class Gerenciador {
    View view = new View();

    public void Gerenciar(View view, int escolha) {
        switch (escolha) {

            case 1 -> {
                cadastrarMaquina();
            }

            case 2 -> {

            }

            case 3 -> {

            }

            case 4 -> {

            }

            case 5 -> {

            }

            case 6 -> {

            }

            default -> {
                //atendente.erro();
            }
        }

    }

    public void cadastrarMaquina() {
        List<Maquina> maquinas = new ArrayList<>();
        String nome = null;
        String setor = null;
        Maquina.Status status= null;

        while (maquinas.isEmpty()) {
            nome = view.nome("MÁQUINA", "da máquina");
           setor = view.setor();
            status = Operacional;
            return;
        }
        Maquina maquina = new Maquina(nome,setor,status);
        maquinas.add(maquina);
        var maquinaDAO = new MaquinaDAO();

        try{
            maquinaDAO.cadastrarMaquina(maquina);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
