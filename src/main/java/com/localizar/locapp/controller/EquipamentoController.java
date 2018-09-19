package com.localizar.locapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EquipamentoController {
	
	@RequestMapping(value="/cadastrarEquipamento")
	public String form(){
		return "equipamento/formEquipamento";
	}

}
