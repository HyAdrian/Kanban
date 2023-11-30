package kanban.entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Hygor
 */
public class Task implements Comparable<Task>{
    public String descricao;
    public LocalDate dataEnvio;
    public LocalDate prazo;
    int estado;
    
    public Task(String descricao, LocalDate prazo,int estado){
        this.descricao = descricao;
        this.dataEnvio = LocalDate.now();
        this.prazo = prazo;
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        Lambda diferencaDias = (a, b) -> (int) ChronoUnit.DAYS.between(a, b);
        int diferenca = diferencaDias.calculaDias(dataEnvio, prazo);

        if (estado == 5){
            return "  [" + descricao + "]";
        } else if(diferenca<=0){
            return "  [" + descricao + "]" + " - " + "ATRASADA!";
        } else if (diferenca == 1) {
            return "  [" + descricao + " - " + diferenca + " dia" + " restante] ";
        } else {
            return "  [" + descricao + " - " + diferenca + " dias" + " restantes] ";
        }
    }
    
    @Override
    public int compareTo(Task other) {
        
        return this.prazo.compareTo(other.prazo);     
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

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
}
