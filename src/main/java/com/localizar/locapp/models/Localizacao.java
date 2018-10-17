package com.localizar.locapp.models;


import java.util.Date;
import java.sql.Time;
//import java.sql.Date;
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

	
	
	
	/*@GeneratedValue(strategy= GenerationType.AUTO)
	private long idtemp;*/
	
	@Id
	@NotEmpty
	private String tagID;
	
	public String getTagID() {
		return tagID;
	}

	public void setTagID(String tagID) {
		this.tagID = tagID;
	}

	private Double localiza;
	
	public Double getLocaliza() {
		return localiza;
	}

	public void setLocaliza(Double localiza) {
		this.localiza = localiza;
	}

	private Date data;
	private String time;
	
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	

	
	/*private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date(System.currentTimeMillis());
		return dateFormat.format(date);
	}*/
	
	
	
	
	/*public long getIdtemp() {
		return idtemp;
	}
	public void setIdtemp(long idtemp) {
		this.idtemp = idtemp;
	}*/
	
	
	
	
	@ManyToOne
	private Equipamento equipamento;
	
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
}