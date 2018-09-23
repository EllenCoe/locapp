package com.localizar.locapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.localizar.locapp.models.Equipamento;
import com.localizar.locapp.models.Localizacao;
import com.localizar.locapp.repository.EquipamentoRepository;
import com.localizar.locapp.repository.LocalizacaoRepository;


@Controller
public class EquipamentoController {
	@Autowired
	private EquipamentoRepository er;
	@Autowired
	private LocalizacaoRepository lr;
	
	@RequestMapping(value="/cadastrarEquipamento", method = RequestMethod.GET)
	public String form(){
		return "equipamento/formEquipamento";
	}
	
	@RequestMapping(value="/cadastrarEquipamento",method=RequestMethod.POST)
	public String form(@Valid Equipamento equipamento, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEquipamento";
		}
		
		attributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
		er.save(equipamento);
		return "redirect:/cadastrarEquipamento";
	}
	
	@RequestMapping(value= "/detalhesEquipamento{codigo}", method= RequestMethod.GET)
	public ModelAndView detalhesEquipamento(@PathVariable("codigo") long codigo){
		
		Equipamento equipamento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView ("equipamento/detalhesEquipamento");
		mv.addObject("equipamento", equipamento);
		
		Iterable<Localizacao> localizacoes = lr.findByEquipamento(equipamento);
		mv.addObject("localizacoes", localizacoes);
		
		
		return mv;
	}
	@RequestMapping(value= "/detalhesEquipamento{codigo}", method= RequestMethod.POST)
	public String detalhesEquipamento(@PathVariable("codigo") long codigo, @Valid Localizacao localizacao, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/detalhesEquipamento{codigo}";
		}
		Equipamento equipamento = er.findByCodigo(codigo);
		localizacao.setEquipamento(equipamento);
		lr.save(localizacao);
		attributes.addFlashAttribute("mensagem", "Localização adicionada com sucesso!");
		return "redirect:/detalhesEquipamento{codigo}";
	}
		
	
	
	@RequestMapping("/equipamentos")
	public ModelAndView listaEquipamentos(){
		ModelAndView mv = new ModelAndView("listaEquipamentos");
		Iterable<Equipamento> equipamentos = er.findAll();
		mv.addObject("equipamentos", equipamentos);
		return mv;
	}
	
	
	
	
}
