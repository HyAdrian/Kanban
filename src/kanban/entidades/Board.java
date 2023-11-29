/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanban.entidades;

import javax.swing.DefaultListModel;
import java.util.ArrayList;

public class Board {
    public String Nome;
    public DefaultListModel<Task> fazer;
    public DefaultListModel<Task> analise;
    public DefaultListModel<Task> dev;
    public DefaultListModel<Task> teste;
    public DefaultListModel<Task> finalizado;

    public Board(String Nome) {
        this.Nome = Nome;
        fazer = new DefaultListModel<>();
        analise = new DefaultListModel<>();
        dev = new DefaultListModel<>();
        teste = new DefaultListModel<>();
        finalizado = new DefaultListModel<>();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void addTarefa(DefaultListModel<Task> lista, Task tarefa) {
        lista.addElement(tarefa);
    }

    public void removeTarefa(DefaultListModel<Task> lista, Task tarefa) {
        lista.removeElement(tarefa);
        tarefa.setEstado(tarefa.getEstado() + 1);
    }

    public void moveTarefa(DefaultListModel<Task> source, DefaultListModel<Task> destiny, Task tarefa) {
        destiny.addElement(tarefa);
        source.removeElement(tarefa);
        tarefa.setEstado(tarefa.getEstado() + 1);
    }
}
