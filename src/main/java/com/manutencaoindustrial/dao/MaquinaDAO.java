package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDAO {

   public void  cadastrarMaquina(Maquina maquina)throws SQLException{
       String query = """
               INSERT INTO Maquina (id,nome, setor, status)
               VALUES (?,? , ? , ?);
               """;

       try(Connection conn = Conexao.conectar();
           PreparedStatement stmt = conn.prepareStatement(query)){

           stmt.setInt(1, maquina.getId());
           stmt.setString(2, maquina.getNome());
           stmt.setString(3, maquina.getSetor());
           stmt.setString(4, maquina.getStatus().name());
           stmt.executeUpdate();

       }catch(SQLException e){
           e.printStackTrace();
       }
   }

   public boolean verificacao(String nome){
       String query = "SELECT 1 From Maquina Where nome = ? LIMIT 1;";

       try(Connection conn = Conexao.conectar();
       PreparedStatement stmt = conn.prepareStatement(query)){

       stmt.setString(1, nome);
       ResultSet rs = stmt.executeQuery();

       return rs.next();

       }catch (SQLException e){
           e.printStackTrace();
           return false;
       }
   }

    public List<Maquina> listar() {
        String query = """
                Select id, nome, setor, status from Maquina where status = 'OPERACIONAL';
                """;
        List<Maquina> maquinas = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String setor = rs.getString("setor");
                Maquina.Status status = Maquina.Status.valueOf(rs.getString("status"));

                Maquina maquina = new Maquina(id, nome, setor, status);
                maquinas.add(maquina);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maquinas;
    }

}
