package br.edu.ifsp.hto.listatarefa.model;

public class Tarefa {
    private String titulo;
    private String descricao;

    @Override
    public String toString() {
        return this.titulo + " - " + this.descricao;
    }

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
