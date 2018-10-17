package com.localizar.locapp;

import com.localizar.locapp.models.Localizacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class LocalizacaoDAO {

	public boolean save (Localizacao l) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
            stmt = con.prepareStatement("INSERT INTO localizacao (posicao,equipamento_codigo,idtemp) VALUES (?,?,?)");
            stmt.setString(1, "50.0");
            stmt.setInt(2, 6);
            stmt.setInt(3,12);
            stmt.executeUpdate();
         // executa
        	stmt.execute();
        	stmt.close();
        	System.out.println("Gravado!");
        	con.close();

            return true;

        } catch (SQLException ex) {

            System.err.println("Erro ao salvar: "+ex);
            return false;
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }

	}
	
	public static void main(String[] args) {
		
		Localizacao loc = new Localizacao();
		loc.setPosicao(23.0);
		
		LocalizacaoDAO dao = new LocalizacaoDAO();
		
		if(dao.save(loc)) {
			
			System.out.println("Salvo com sucesso");
		}else {
			System.err.println("Erro ao salvar");
		}
		
		
		
		
		
	}
	
}		
	 
		

