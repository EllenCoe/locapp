package com.localizar.locapp;

import com.localizar.locapp.models.Localizacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class LocalizacaoDAO {

	public boolean save (Localizacao l) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
            stmt = con.prepareStatement("INSERT INTO localizacao (posicao,equipamento_codigo,data,time) VALUES (?,?,?,?)");
            stmt.setString(1, "92.0");
            stmt.setInt(2, 1);
            stmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            
            
           
            
            stmt.setString(4, new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
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
	 
		

