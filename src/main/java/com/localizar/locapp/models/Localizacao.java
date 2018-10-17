package com.localizar.locapp.models;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;




@Entity
public class Localizacao {

	
	
	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idtemp;
	
	@Id
	@NotEmpty
	private Double posicao;
	
	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	private Date data;

	
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date(System.currentTimeMillis());
		return dateFormat.format(date);
	}
	
	
	
	
	public long getIdtemp() {
		return idtemp;
	}
	public void setIdtemp(long idtemp) {
		this.idtemp = idtemp;
	}
	public Double getPosicao() {
		return posicao;
	}




	public void setPosicao(Double posicao) {
		this.posicao = posicao;
	}
	
	@ManyToOne
	private Equipamento equipamento;
	
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
}