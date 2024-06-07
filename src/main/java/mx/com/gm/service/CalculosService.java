package mx.com.gm.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CalculosService {
	
	
	public void calcularFuncion(Model model, Long mp, Long n, Double l,
			Long b, Long mc, Long b_celdas, Long b_vias) {
		Long N = (long) 0;
		Long B = (long) 0;
		Long celdas = (long) 0;
		Double auxL =  (double) 0;
		
		if(mp != 0) {
			if((mp * 1024) >= 1024) {
				
				auxL = (double) ((mp * 1024 * 8) / 16);
			} else {
				auxL = (double) ((mp * (8)) / 16);
			}
			l = (double) (Math.log(auxL)/Math.log(2));
		} else {
			N = (long) Math.pow(2, l);
			mp = ((N * 16)/(8));
			if(mp >= 1024) {
				mp = mp / 1024;
			}
		}
		
		N = (long) Math.pow(2, l);
		B = N / b;
			
		
		
		
		if(mc != 0) {
			if(mc * 1024 >= 1024) {
				mc = mc * 1024;
				b_celdas = (((mc * 8) / 16) / b);
			}
		} 
			
		if(b_celdas != 0) {
			celdas = b * b_celdas;
			mc = (celdas * 16) / 8;
			if(mc >= 1024) {
				mc = mc / 1024;
			}
		} 
		
		
		
		//CALCULAR FUNCIONES DE CORRESPONDENCIA
		//FC ASOCIATIVA
		long fcAsociativa = 0;
		long palabra = 0;
		long etiqueta = 0;
		palabra = (long) (Math.log(b)/ Math.log(2));
		etiqueta = (long) (Math.log(B)/ Math.log(2));
		fcAsociativa = palabra + etiqueta;
		//FC DIRECTA
		long fcDirecta = 0;
		long linea = 0;
		long etiquetaD = 0;
		linea = (long) (Math.log(b_celdas)/ Math.log(2));
		etiquetaD = (long) (Math.log((B/b_celdas))/ Math.log(2));
		fcDirecta = linea + etiquetaD + palabra;
		
		//FC A POR CONJUNTOS
		long fcACon = 0;
		long conjuntos = 0;
		long etiquetaC = 0;
		long c = 0;
		c = b_celdas / b_vias;
		
		conjuntos = (long) (Math.log(c)/ Math.log(2));
		etiquetaC = (long) (Math.log((B/c)) / Math.log(2));
		fcACon = conjuntos + etiquetaC + palabra;
		
		long nL = (long) Math.round(l);
		
		//REGRESO DE VARIABLES
		model.addAttribute("mp",mp);
		model.addAttribute("n",n);
		model.addAttribute("b",b);
		model.addAttribute("l",nL);
		model.addAttribute("NL",N);
		model.addAttribute("BL",B);
		model.addAttribute("mc",mc);
		model.addAttribute("b_celdas",b_celdas);
		model.addAttribute("b_vias",b_vias);
		//model.addAttribute("celdas",celdas);
		// REGRESO DE FUNCIONES
		//asociativa
		model.addAttribute("asociativa", fcAsociativa);
		model.addAttribute("palabra",palabra);
		model.addAttribute("etiqueta", etiqueta);
		//directa
		model.addAttribute("directa", fcDirecta);
		model.addAttribute("linea",linea);
		model.addAttribute("etiquetaD", etiquetaD);
		//por conjuntos
		model.addAttribute("aconjunto", fcACon);
		model.addAttribute("conjuntos",conjuntos);
		model.addAttribute("etiquetaC", etiquetaC);
	}
}
