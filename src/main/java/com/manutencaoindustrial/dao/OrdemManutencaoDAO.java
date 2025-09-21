package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.model.OrdemManutencao;
import com.manutencaoindustrial.model.Tecnico;
import com.manutencaoindustrial.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemManutencaoDAO {

    public void criarOrdemManutencao(OrdemManutencao ordemManutencao , Maquina maquina , Tecnico tecnico) throws SQLException {
        String query = """
                INSERT INTO OrdemManutencao ( idMaquina, idTecnico, dataSolicitacao, status)
                VALUES ( ? , ? , ? , ? );
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, maquina.getId());
            stmt.setInt(2, tecnico.getId());
            stmt.setDate(3, Date.valueOf(ordemManutencao.getDataSolicitacao()));
            stmt.setString(4, ordemManutencao.getStatus().name());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Maquina maquina){
        String query = """
               UPDATE Maquina
               SET status = 'EM_MANUTENCAO'
               WHERE id = ?;
               """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, maquina.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
