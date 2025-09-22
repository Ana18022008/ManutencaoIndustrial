package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.OrdemManutencao;
import com.manutencaoindustrial.model.OrdemPeca;
import com.manutencaoindustrial.model.Peca;
import com.manutencaoindustrial.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdemPecaDAO {

    public void adicionar(OrdemPeca ordemPeca, OrdemManutencao ordemManutencao, Peca peca) throws SQLException {
        String query = """
                INSERT INTO OrdemPeca (idOrdem, idPeca, quantidade)
                VALUES (?,?,?);
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

          stmt.setInt(1, ordemManutencao.getId());
          stmt.setInt(2, peca.getId());
          stmt.setDouble(3, ordemPeca.getQuantidade());
          stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

