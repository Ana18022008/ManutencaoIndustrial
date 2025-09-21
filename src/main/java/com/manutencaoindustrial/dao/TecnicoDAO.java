package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.Tecnico;
import com.manutencaoindustrial.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TecnicoDAO {

    public void cadastrarTecnico(Tecnico tecnico)throws SQLException{
        String query = """
                INSERT INTO Tecnico (id, nome, especialidade)
                VALUES (?,?,?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt (1, tecnico.getId());
            stmt.setString(2, tecnico.getNome());
            stmt.setString(3, tecnico.getEspecialidade());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public boolean verificar(String nome){
        String query = """
                SELECT 1 FROM Tecnico Where nome = ? LIMIT 1;
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            return rs.next();


        }catch(SQLException e){
            e.printStackTrace();
            return false;

        }


    }


}
