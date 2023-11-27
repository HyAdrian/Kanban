package kanban.entidades;
/**
 *
 * @author Hygor
 */
public class Task {
    String descricao;
    
    public Task(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
