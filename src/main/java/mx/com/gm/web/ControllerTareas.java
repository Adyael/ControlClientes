package mx.com.gm.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.com.gm.domain.FuncionesCorrespondencia;
import mx.com.gm.service.CalculosService;
import mx.com.gm.service.FuncionesCorrespondenciaService;

@Controller
public class ControllerTareas {
	@Autowired
	private FuncionesCorrespondenciaService funcionesCorrespondenciaService;
	@Autowired
	private CalculosService calculosService;
	
	
	@GetMapping("/tareas/funcionesCorrespondencia")
	public String listarOperaciones(Model model) {
		
		var funciones = funcionesCorrespondenciaService.listarFunciones();
		
		model.addAttribute("funciones",funciones);
		
		return "funcionesCorrespondencia";
	}
	
	@PostMapping("/tareas/funcionesCorrespondencia/detalles")
	public String detallesFuncion(Model model, Errors errores) {
		 
		return "";
	}
	
	@PostMapping("/tareas/funcionesCorrespondencia/calcular")
	public String calcularFuncion(Model model, RedirectAttributes redirect,
			@RequestParam(value="mp", defaultValue="0") Long mp,
			@RequestParam(value="n", defaultValue="0") Long n,
			@RequestParam(value="l", defaultValue="0") Double l,
			@RequestParam(value="b", defaultValue="0") Long b,
			@RequestParam(value="mc", defaultValue="0") Long mc,
			@RequestParam(value="b_celdas", defaultValue="0") Long lineas,
			@RequestParam(value="b_vias", defaultValue="0") Long vias) {
		 
		calculosService.calcularFuncion(model, mp, n, l, b, mc, lineas, vias);
		
		return "resultadoFunciones";
	}
	
	@PostMapping("/tareas/funcionesCorrespondencia/save")
	public String saveFuncion(Model model,RedirectAttributes redirect,
			@RequestParam(value="mp", defaultValue="0") Long mp,
			@RequestParam(value="n", defaultValue="0") Long n,
			@RequestParam(value="l", defaultValue="0") Long l,
			@RequestParam(value="b", defaultValue="0") Long b,
			@RequestParam(value="NL", defaultValue="0") Long NL,
			@RequestParam(value="BL", defaultValue="0") Long BL,
			@RequestParam(value="mc", defaultValue="0") Long mc,
			@RequestParam(value="b_celdas", defaultValue="0") Long lineas,
			@RequestParam(value="b_vias", defaultValue="0") Long vias,
			@RequestParam(value="asociativa", defaultValue="0") Long asociativa,
			@RequestParam(value="etiqueta", defaultValue="0") Long etiqueta,
			@RequestParam(value="palabra", defaultValue="0") Long palabra,
			@RequestParam(value="directa", defaultValue="0") Long directa,
			@RequestParam(value="etiquetaD", defaultValue="0") Long etiquetaD,
			@RequestParam(value="linea", defaultValue="0") Long linea,
			@RequestParam(value="aconjunto", defaultValue="0") Long aconjunto,
			@RequestParam(value="conjuntos", defaultValue="0") Long conjuntos,
			@RequestParam(value="etiquetaC", defaultValue="0") Long etiquetaC) {
		FuncionesCorrespondencia funcionesCorrespondencia = new FuncionesCorrespondencia();
		funcionesCorrespondencia.setMp(mp);
		funcionesCorrespondencia.setB(b);
		funcionesCorrespondencia.setN(n);
		funcionesCorrespondencia.setL(l);
		funcionesCorrespondencia.setNL(NL);
		funcionesCorrespondencia.setBL(BL);
		funcionesCorrespondencia.setMc(mc);
		funcionesCorrespondencia.setB_celdas(lineas);
		funcionesCorrespondencia.setB_vias(vias);
		funcionesCorrespondencia.setAsociativa(asociativa);
		funcionesCorrespondencia.setEtiqueta(etiqueta);
		funcionesCorrespondencia.setPalabra(palabra);
		funcionesCorrespondencia.setDirecta(directa);
		funcionesCorrespondencia.setEtiquetaD(etiquetaD);
		funcionesCorrespondencia.setLinea(linea);
		funcionesCorrespondencia.setAconjunto(aconjunto);
		funcionesCorrespondencia.setConjuntos(conjuntos);
		funcionesCorrespondencia.setEtiquetaC(etiquetaC);
		
		//System.out.println(funcionesCorrespondencia.toString());
		
		funcionesCorrespondenciaService.guardarResultados(funcionesCorrespondencia);
		return "redirect:/tareas/funcionesCorrespondencia";
	}
}
