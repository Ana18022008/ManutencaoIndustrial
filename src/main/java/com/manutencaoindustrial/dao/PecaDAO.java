package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.Peca;
import com.manutencaoindustrial.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PecaDAO {

    public void cadastrarPeca (Peca peca) throws SQLException {
        String query = """
            INSERT INTO Peca (id, nome, estoque)
            VALUES (? ,? ,? );
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, peca.getId());
            stmt.setString(2, peca.getNome());
            stmt.setDouble(3, peca.getEstoque());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean verificar(String nome) {
        String query = """
                SELECT 1 FROM Peca WHERE nome = ? LIMIT 1;
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    }
