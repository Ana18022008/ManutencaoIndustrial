package com.manutencaoindustrial.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String []args){

        try (Connection conn = Conexao.conectar()){

            if (conn != null) {
                System.out.println("Conectado!");
            } else {
                System.out.println("Conexão não encontrada!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
