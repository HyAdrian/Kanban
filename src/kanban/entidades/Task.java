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
    
    public Task(String descricao){
        this.descricao = descricao;
        this.dataEnvio = LocalDate.now();
        //this.prazo = prazo;
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
