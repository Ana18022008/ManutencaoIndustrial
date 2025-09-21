package com.manutencaoindustrial.service;
import com.manutencaoindustrial.dao.MaquinaDAO;
import com.manutencaoindustrial.dao.PecaDAO;
import com.manutencaoindustrial.dao.TecnicoDAO;
import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.model.Peca;
import com.manutencaoindustrial.model.Tecnico;
import com.manutencaoindustrial.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.manutencaoindustrial.model.Maquina.Status;


public class Gerenciador {
    View view = new View();

    public void Gerenciar(View view, int escolha) {
        switch (escolha) {

            case 1 -> {
                cadastrarMaquina();
            }

            case 2 -> {
                cadastrarTecnico();
            }

            case 3 -> {
                cadastrarPeca();
            }

            case 4 -> {
                criarOrdemManutencao();
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

        String nome = view.nome("MÁQUINA", "da máquina");
        String setor = view.setor();
        Maquina.Status status = Status.OPERACIONAL;

        Maquina maquina = new Maquina(nome, setor, status);
        maquinas.add(maquina);
        var maquinaDAO = new MaquinaDAO();

        if (setor == null || setor.trim().isEmpty() || nome == null || nome.trim().isEmpty()){
            view.erroCadastro("! O valor está nulo");
            return;
        }

        if (maquinaDAO.verificacao(nome)) {
            view.duplicata("da máquina");
            return;
        }
            try {
                maquinaDAO.cadastrarMaquina(maquina);
                view.sucessoCadastro("máquina");
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }


    public void cadastrarTecnico(){
        List<Tecnico>tecnicos = new ArrayList<>();
        String nome = view.nome("TÉCNICO", "técnico");
        String especialidade = view.especialidade();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();


        if(nome == null || nome.trim().isEmpty()|| especialidade == null || especialidade.trim().isEmpty()){
            view.erroCadastro("! O valor está nulo");
            return;
        }

        if(tecnicoDAO.verificar(nome)){
            view.duplicata("do técnico");
            return;
        }

        try{
            Tecnico tecnico = new Tecnico(nome, especialidade);
            tecnicoDAO.cadastrarTecnico(tecnico);
            view.sucessoCadastro("técnico");
        }catch (SQLException e){
            e.printStackTrace();
        }


    }


    public void cadastrarPeca(){
        List<Peca>pecas = new ArrayList<>();
        String nome = view.nome("PEÇA", "peça");
        String estoque = view.estoque();
        PecaDAO pecaDAO = new PecaDAO();

        if(nome == null || nome.trim().isEmpty() || estoque.isEmpty()){
            view.erroCadastro("! Possui valores nulos");
            return;
        }

        if (pecaDAO.verificar(nome)){
            view.duplicata("da peça");
            return;
        }
        double estoqueInicial = Double.parseDouble(estoque);

        if (estoqueInicial  < 0){
            view.erroCadastro("! o estoque não pode ser negativo");
            return;
        }

        try{
            Peca peca = new Peca(nome, estoqueInicial);
            pecaDAO.cadastrarPeca(peca);
            view.sucessoCadastro("Peça");
        }catch(SQLException e){
            e.printStackTrace();
        }


    }


    public void criarOrdemManutencao(){

    }

}
