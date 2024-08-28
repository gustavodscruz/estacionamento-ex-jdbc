package br.com.fiap.dao;

import br.com.fiap.dto.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDAO {
    private Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }
    //não será permitido criar um objeto sem a conexão
    // e nem alterar o objeto de conexão depois
    public Connection getCon() {
        return con;
    }

    public String inserir(Carro carro){
        String sql = "insert into ddd_carro(placa, cor, descricao) values (?,?,?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) //try-with-resources
        {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            if (ps.executeUpdate() > 0){
                return "Inserido com sucesso";
            }else{
                return "Falha ao inserir!";
            }

        }catch (SQLException e){
            return "Erro de SQL: " + e.getMessage();
        }
    }

}
