/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanban;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.DefaultListModel;

import kanban.entidades.Task;


public class Conexao {
    private Connection conexao;
    private final String url = "jdbc:postgresql://localhost/Kanban";
    private final String user = "postgres";
    private final String password = "admin";
    

 public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
   
   
     public void getTask(){
     String sql = "select descricao,estado from public.task";
     try(Connection con = connect();
          Statement smt = con.createStatement();
          ResultSet rs = smt.executeQuery(sql)){
         while(rs.next()){
             System.out.println(rs.getString("descricao")+' ' + rs.getString("estado"));
         }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
       
   
   }   
    
     public void insertTask(Task task, LocalDate prazo, int estado)
     {
         long id = 0;
         String SQL = "insert into task (descricao, prazo, estado) values (?,?, ?)";
         try(Connection conn = connect();
             PreparedStatement in = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)){
             in.setString(1, task.getDescricao());
             in.setDate(2, java.sql.Date.valueOf(task.prazo));
             in.setInt(3,estado);
             int res = in.executeUpdate();
             if(res > 0){
                 try (ResultSet rs = in.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                        System.out.println("Inserido com sucesso");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
             }
             
         }catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
         
         
     }

     public int updateTask(Task task){
         String SQL = "update task " + "set estado = ? " + "where descricao = ?";
         int res = 0;
         int estado = task.getEstado();
              try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            
            pstmt.setInt(1,estado);
            pstmt.setString(2,task.getDescricao());
            res = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return estado;
    }
         
    public void preencheLista(DefaultListModel<Task> lista, int estado){
        String SQL = "select descricao, prazo, estado from task where estado = ?";

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, estado);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Task t = new Task(rs.getString("descricao").trim(), rs.getDate("prazo").toLocalDate() ,rs.getInt("estado"));
                lista.addElement(t);
            } 
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    
    }

}
