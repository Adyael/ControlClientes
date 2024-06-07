package mx.com.gm.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="funciones_correspondencia")
public class FuncionesCorrespondencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_funcion;
	
	//Memoria Pincipal
	// Tamano MP
	@NotNull
	private Long mp;
	// Palabra por bloque
	@NotNull
	private Long b;
	// Tamano de palabra
	@NotNull
	private Long n;
	// Longitud de direccion
	@NotNull
	private Long l;
	@NotNull
	private Long NL;
	@NotNull
	private Long BL;

	//Memoria Cache
	@NotNull
    private Long mc;
	@NotNull
	private Long b_celdas;
	@NotNull
    private Long b_vias;
    
    //Funciones de correpsondencia
    //Asociativa
	@NotNull
    private Long asociativa;
	@NotNull
    private Long palabra;
	@NotNull
    private Long etiqueta;
    //Directa
	@NotNull
    private Long directa;
	@NotNull
    private Long etiquetaD;
	@NotNull
    private Long linea;
    //Asociativa por conjuntos
	@NotNull
    private Long aconjunto;
	@NotNull
    private Long conjuntos;
	@NotNull
    private Long etiquetaC;
}
