/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanban.entidades;

import java.util.ArrayList;

public class Board {
    public String Nome;
    public ArrayList<Task> fazer;
    public ArrayList<Task> analise;
    public ArrayList<Task> desenvolvimento;
    public ArrayList<Task> teste;
    public ArrayList<Task> feito;

    public Board(String Nome) {
        this.Nome = Nome;
        fazer = new ArrayList<Task>();
        analise = new ArrayList<Task>();
        desenvolvimento = new ArrayList<Task>();
        teste = new ArrayList<Task>();
        feito = new ArrayList<Task>();
              
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public void addTarefa(ArrayList<Task> lista, Task tarefa){
        lista.add(tarefa);
    }
      public void removeTarefa(ArrayList<Task> lista, Task tarefa){
        lista.remove(tarefa);
    }
}
