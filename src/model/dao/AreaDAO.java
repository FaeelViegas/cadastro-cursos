/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Areas;
import model.bean.Cursos;

/**
 *
 * @author Senai
 */
public class AreaDAO {
    public List<Areas> leitura() {
        List<Areas> areas = new ArrayList<>();
        try {
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM area");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Areas area = new Areas();
                area.setIdArea(rs.getInt("idArea"));
                area.setNomeArea(rs.getString("nomeArea"));

                areas.add(area);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }
    
    public void cadastrarArea(Areas objArea) {
        try{
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("insert into area(nomeArea)values(?)");
            stmt.setString(1, objArea.getNomeArea());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Area inserida com sucesso!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletarCampo(Areas objArea) {
        try{
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM area WHERE idArea = ?");
            stmt.setInt(1, objArea.getIdArea());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Campo deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
