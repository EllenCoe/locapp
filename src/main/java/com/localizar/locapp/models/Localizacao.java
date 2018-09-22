package com.localizar.locapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;




@Entity
public class Localizacao {

	@Id 
	@NotEmpty
	private String posicao;
	
	
	
	@ManyToOne
	private Equipamento equipamento;
	
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEvento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
}