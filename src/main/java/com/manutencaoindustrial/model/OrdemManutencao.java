package com.manutencaoindustrial.model;

import java.time.LocalDate;

public class OrdemManutencao {

    private int id;
    private Maquina id_maquina;
    private Tecnico id_tecnico;
    private LocalDate dataSolicitacao;
    private Status status;

    public static enum Status{
        Pendente, Executada, Cancelada;
    }


    public OrdemManutencao(int id, Maquina id_maquina, Tecnico id_tecnico, LocalDate dataSolicitacao, Status status) {
        this.id = id;
        this.id_maquina = id_maquina;
        this.id_tecnico = id_tecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public OrdemManutencao(Maquina id_maquina, Tecnico id_tecnico, LocalDate dataSolicitacao, Status status) {
        this.id_maquina = id_maquina;
        this.id_tecnico = id_tecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maquina getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Maquina id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Tecnico getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(Tecnico id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString(){
    return "\n - Ordem de Manutenção - " +
            "\n ID : " + id +
            "\n ID DA MÁQUINA : " + id_maquina +
            "\n ID DO TÉCNICO : " + id_tecnico +
            "\n DATA DE SOLICITAÇÃO : " + dataSolicitacao +
            "\n STATUS : " + status;

}
}
