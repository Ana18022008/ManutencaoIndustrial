package com.manutencaoindustrial.model;

public class OrdemPeca {

    private OrdemManutencao id_ordem;
    private Peca id_peca;
    private double quantidade;

    public OrdemPeca(OrdemManutencao id_ordem, Peca id_peca, double quantidade) {
        this.id_ordem = id_ordem;
        this.id_peca = id_peca;
        this.quantidade = quantidade;
    }

    public OrdemManutencao getId_ordem() {
        return id_ordem;
    }

    public void setId_ordem(OrdemManutencao id_ordem) {
        this.id_ordem = id_ordem;
    }

    public Peca getId_peca() {
        return id_peca;
    }

    public void setId_peca(Peca id_peca) {
        this.id_peca = id_peca;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        return "\n - Ordem Peça - " +
                "\n ID ORDEM-MANUTENÇÃO : " + id_ordem +
                "\n ID PEÇA : " + id_peca +
                "\n QUANTIDADE : " + quantidade;
    }

}
