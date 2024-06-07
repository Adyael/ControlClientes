package mx.com.gm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.gm.dao.FuncionesCorrespondenciaDao;
import mx.com.gm.domain.FuncionesCorrespondencia;

@Service
public class FuncionesCorrespondenciaServiceImpl implements FuncionesCorrespondenciaService{
	
	@Autowired
	private FuncionesCorrespondenciaDao funcionesCorrespondenciaDao;

	@Override
	@Transactional(readOnly = true)
	public List<FuncionesCorrespondencia> listarFunciones(){
		return (List<FuncionesCorrespondencia>) funcionesCorrespondenciaDao.findAll();
	}
	
	@Override
	@Transactional
	public void guardarResultados(FuncionesCorrespondencia funcionesCorrespondencia) {
		funcionesCorrespondenciaDao.save(funcionesCorrespondencia);
	}
	
	@Override
	@Transactional(readOnly = true)
	public FuncionesCorrespondencia encontrarFuncionById(FuncionesCorrespondencia funcionesCorrespondencia) {
		return funcionesCorrespondenciaDao.findById(funcionesCorrespondencia.getId_funcion()).orElse(null);
	}

}
