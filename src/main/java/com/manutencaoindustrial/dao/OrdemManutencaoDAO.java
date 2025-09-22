package com.manutencaoindustrial.dao;

import com.manutencaoindustrial.model.Maquina;
import com.manutencaoindustrial.model.OrdemManutencao;
import com.manutencaoindustrial.model.Tecnico;
import com.manutencaoindustrial.util.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdemManutencaoDAO {

    public void criarOrdemManutencao(OrdemManutencao ordemManutencao, Maquina maquina, Tecnico tecnico) throws SQLException {
        String query = """
                INSERT INTO OrdemManutencao (id, idMaquina, idTecnico, dataSolicitacao, status)
                VALUES (?, ? , ? , ? , ? );
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, ordemManutencao.getId());
            stmt.setInt(2, maquina.getId());
            stmt.setInt(3, tecnico.getId());
            stmt.setDate(4, Date.valueOf(ordemManutencao.getDataSolicitacao()));
            stmt.setString(5, ordemManutencao.getStatus().name());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Maquina maquina) {
        String query = """
                UPDATE Maquina
                SET status = 'EM_MANUTENCAO'
                WHERE id = ?;
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, maquina.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OrdemManutencao> listar() {
        List<OrdemManutencao> ordemM = new ArrayList<>();

        String query = """
                SELECT * FROM OrdemManutencao
                WHERE status = 'PENDENTE';
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idMaquina = rs.getInt("id_maquina");
                int idTecnico = rs.getInt("id_tecnico");
                Date dataSolicitacao = rs.getDate("dataSolicitacao");
                OrdemManutencao.Status status = OrdemManutencao.Status.valueOf(rs.getString("status"));

                LocalDate novaDataSolicitacao = dataSolicitacao.toLocalDate();
                Maquina maquina = new Maquina(idMaquina);
                Tecnico tecnico = new Tecnico(idTecnico);

                OrdemManutencao ordemManutencao = new OrdemManutencao(id, maquina, tecnico, novaDataSolicitacao, status);

                ordemM.add(ordemManutencao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordemM;
    }
}
