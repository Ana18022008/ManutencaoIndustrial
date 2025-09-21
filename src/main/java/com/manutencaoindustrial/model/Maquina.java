package com.manutencaoindustrial.model;

public class Maquina {

    private int id;
    private String nome;
    private String setor;
    private Status status;

    public enum Status{
        OPERACIONAL, EM_MANUTENCAO;
    }

    public Maquina( String nome, String setor, Status status) {
        this.nome = nome;
        this.setor = setor;
        this.status = status;
    }

    public Maquina(int id, String nome, String setor, Status status) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.status = status;
    }

    public Maquina(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n - Máquina - " +
                "\n ID : " + id + 1 +
                "\n NOME : " + nome +
                "\n SETOR : " + setor +
                "\n STATUS : " + status;
    }
}
