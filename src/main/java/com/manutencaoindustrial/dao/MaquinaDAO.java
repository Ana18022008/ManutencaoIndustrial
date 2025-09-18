package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaquinaDAO {

   public void  cadastrarMaquina(Maquina maquina)throws SQLException{
       String query = """
               INSERT INTO maquina (id, nome, setor, status)
               VALUES (? , ? , ? , ?);
               """;

       try(Connection conn = Conexao.conectar();
           PreparedStatement stmt = conn.prepareStatement(query)){

           stmt.setInt(1,maquina.getId());
           stmt.setString(2, maquina.getNome());
           stmt.setString(3, maquina.getSetor());
           stmt.setObject(4, maquina.getStatus().name());
           stmt.executeUpdate();

       }catch(SQLException e){
           e.printStackTrace();
       }
   }
}
