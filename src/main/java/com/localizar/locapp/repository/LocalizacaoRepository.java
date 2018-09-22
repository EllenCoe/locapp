package com.localizar.locapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.localizar.locapp.models.Localizacao;

public interface LocalizacaoRepository extends CrudRepository<Localizacao, String> {

}
