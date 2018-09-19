package com.localizar.locapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.localizar.locapp.models.Equipamento;
import com.localizar.locapp.repository.EquipamentoRepository;


@Controller
public class EquipamentoController {
	@Autowired
	private EquipamentoRepository er;
	
	
	@RequestMapping(value="/cadastrarEquipamento", method = RequestMethod.GET)
	public String form(){
		return "equipamento/formEquipamento";
	}
	
	@RequestMapping(value="/cadastrarEquipamento",method=RequestMethod.POST)
	public String form(Equipamento equipamento){
		er.save(equipamento);
		return "redirect:/cadastrarEquipamento";
	}

}
