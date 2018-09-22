package com.localizar.locapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.localizar.locapp.models.Equipamento;
import com.localizar.locapp.models.Localizacao;

public interface LocalizacaoRepository extends CrudRepository<Localizacao, String> {
	Iterable<Localizacao> findByEquipamento(Equipamento equipamento);

}
