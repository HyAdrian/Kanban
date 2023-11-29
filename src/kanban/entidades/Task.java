package kanban.entidades;

import java.time.LocalDate;

/**
 *
 * @author Hygor
 */
public class Task {
    String descricao;
    LocalDate dataEnvio;
    LocalDate prazo;
    int estado;
    
    public Task(String descricao,int estado){
        this.descricao = descricao;
        this.dataEnvio = LocalDate.now();
        //this.prazo = prazo;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
}
