package br.edu.ifsp.hto.listatarefa.model;

// TODO(3) Definir uma classe Tarefa.
// Agora nossa ObservableList irá manter objetos do tipo Tarefa.
// O cadastro de uma Tarefa terá agora o título e a descrição da Tarefa.
public class Tarefa {
    // TODO(4) Definir um atributo para o título da tarefa.
    private String titulo;
    // TODO(5) Definir um atributo para a descrição da tarefa.
    private String descricao;

    // TODO(8) Quando o ListView vai mostrar um item de uma lista na tela,
    // ele usa, por padrão, o método toString.
    // Fazemos a sobrescrita desta método concatenando o título da tarefa com
    // sua descrição.
    // Se este método não for definido, o item que aparecerá na lista será
    // os dados internos do objeto e não seu conteúdo.
    @Override
    public String toString() {
        return this.titulo + " - " + this.descricao;
    }

    // TODO(6) Definir um construtor com o título e a descrição da Tarefa.
    // Com isso, só será possível criar um novo objeto Tarefa (new Tarefa)
    // parassando obrigatoriamente o título e a descrição.
    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
    
    // TODO(7) Fazemos o encapsulamento dos atributos, que são privados
    // com getters e setters para cada atributo.
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
