package com.localizar.locapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.localizar.locapp.models.Equipamento;

public interface EquipamentoRepository  extends CrudRepository<Equipamento, String>{
	Equipamento findByCodigo(long codigo);
	

}
