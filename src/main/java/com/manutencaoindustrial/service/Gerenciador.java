package com.manutencaoindustrial.service;
import com.manutencaoindustrial.dao.MaquinaDAO;
import com.manutencaoindustrial.dao.OrdemManutencaoDAO;
import com.manutencaoindustrial.dao.PecaDAO;
import com.manutencaoindustrial.dao.TecnicoDAO;
import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.model.OrdemManutencao;
import com.manutencaoindustrial.model.Peca;
import com.manutencaoindustrial.model.Tecnico;
import com.manutencaoindustrial.view.View;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.manutencaoindustrial.model.Maquina.Status;


public class Gerenciador {
    View view = new View();
    List<Maquina> maquinas = new ArrayList<>();
    List<Tecnico> tecnicos = new ArrayList<>();

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

        String nome = view.nome("MÁQUINA", "da máquina");
        String setor = view.setor();
        Maquina.Status status = Status.OPERACIONAL;

        var maquinaDAO = new MaquinaDAO();

        if (setor == null || setor.trim().isEmpty() || nome == null || nome.trim().isEmpty()) {
            view.erroCadastro("! O valor está nulo");
            return;
        }

        if (maquinaDAO.verificacao(nome)) {
            view.duplicata("da máquina");
            return;
        }

        Maquina maquina = new Maquina(nome, setor, status);
        maquinas.add(maquina);

        try {
            maquinaDAO.cadastrarMaquina(maquina);
            view.sucessoCadastro("máquina");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    public void cadastrarTecnico() {
        String nome = view.nome("TÉCNICO", "técnico");
        String especialidade = view.especialidade();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();


        if (nome == null || nome.trim().isEmpty() || especialidade == null || especialidade.trim().isEmpty()) {
            view.erroCadastro("! O valor está nulo");
            return;
        }

        if (tecnicoDAO.verificar(nome)) {
            view.duplicata("do técnico");
            return;
        }

        Tecnico tecnico = new Tecnico(nome, especialidade);
        tecnicos.add(tecnico);

        try {
            tecnicoDAO.cadastrarTecnico(tecnico);
            view.sucessoCadastro("técnico");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void cadastrarPeca() {
        List<Peca> pecas = new ArrayList<>();
        String nome = view.nome("PEÇA", "peça");
        String estoque = view.estoque();
        PecaDAO pecaDAO = new PecaDAO();

        if (nome == null || nome.trim().isEmpty() || estoque.isEmpty()) {
            view.erroCadastro("! Possui valores nulos");
            return;
        }

        if (pecaDAO.verificar(nome)) {
            view.duplicata("da peça");
            return;
        }
        double estoqueInicial = Double.parseDouble(estoque);

        if (estoqueInicial < 0) {
            view.erroCadastro("! o estoque não pode ser negativo");
            return;
        }

        try {
            Peca peca = new Peca(nome, estoqueInicial);
            pecaDAO.cadastrarPeca(peca);
            view.sucessoCadastro("Peça");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void criarOrdemManutencao() {
        OrdemManutencaoDAO ordemManutencaoDAO = new OrdemManutencaoDAO();
        Maquina maquina = null;
        Tecnico tecnico = null;

        for (Maquina m : maquinas) {

            if (m.getStatus() == Status.OPERACIONAL) {
                view.visualizarMaquinas(m);
            }
        }

            for (Tecnico t : tecnicos) {
                view.visualizarTecnicos(t);
            }

            view.ordemManutencao();
            int idMaquina = view.escolhaID("máquina");

            for (Maquina m : maquinas) {
                if (m.getId() == idMaquina) {
                    maquina = m;
                    break;
                } else {
                    view.erroCadastro("! ID da máquina está inválido.");
                    return;
                }
            }

            int idTecnico = view.escolhaID("técnico");

            for (Tecnico t : tecnicos){
                if (t.getId() == idTecnico){
                    tecnico = t;
                    break;
                }else{
                    view.erroCadastro("! ID do técnico está inválido.");
                    return;
                }
            }

            LocalDate data = LocalDate.now();
            OrdemManutencao.Status status = OrdemManutencao.Status.Pendente;
             OrdemManutencao ordemManutencao = new OrdemManutencao(maquina, tecnico, data, status);
            try{
                ordemManutencaoDAO.criarOrdemManutencao(ordemManutencao, maquina, tecnico);
                ordemManutencaoDAO.atualizar(maquina);
                view.sucessoCadastro("Ordem de manutenção");
            }catch (SQLException e){
                e.printStackTrace();
                view.erroCadastro("!");
            }

        }
    }

