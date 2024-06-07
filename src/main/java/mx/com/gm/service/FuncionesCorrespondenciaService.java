package mx.com.gm.service;

import java.util.List;

import mx.com.gm.domain.FuncionesCorrespondencia;

public interface FuncionesCorrespondenciaService {
	
	public List<FuncionesCorrespondencia> listarFunciones();
	
	public void guardarResultados(FuncionesCorrespondencia funcionesCorrespondencia);
	
	public FuncionesCorrespondencia encontrarFuncionById(FuncionesCorrespondencia funcionesCorrespondencia);
	
}
