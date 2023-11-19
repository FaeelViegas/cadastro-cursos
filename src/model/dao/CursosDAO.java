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
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Cursos;

/**
 *
 * @author Senai
 */
public class CursosDAO {
    public List<Cursos> leitura() {
        List<Cursos> cursos = new ArrayList<>();
        try {
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM cursos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cursos curso = new Cursos();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                curso.setArea(rs.getInt("area"));

                cursos.add(curso);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }
    
    public ResultSet listarArea(){
        String sql = "SELECT * FROM area;";
        try {
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void cadastrarCurso(Cursos objCurso) {
        try{
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("insert into cursos(nomeCurso,area)values(?,?)");
            stmt.setString(1, objCurso.getNomeCurso());
            stmt.setInt(2,objCurso.getArea());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Curso inserido com sucesso!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletarCampo(Cursos objCurso) {
        try{
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM cursos WHERE idCurso = ?");
            stmt.setInt(1, objCurso.getIdCurso());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Campo deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
