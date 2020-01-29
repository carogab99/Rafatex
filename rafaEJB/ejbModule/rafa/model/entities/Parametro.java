package rafa.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the parametros database table.
 * 
 */
@Entity
@Table(name="parametros")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parametro")
	private Integer idParametro;

	@Column(name="correo_empresa")
	private String correoEmpresa;

	@Column(name="descuento_producto")
	private String descuentoProducto;

	@Column(name="direccion_empresa")
	private String direccionEmpresa;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	@Column(name="porcentaje_iva")
	private BigDecimal porcentajeIva;

	@Column(name="ruc_empresa")
	private String rucEmpresa;

	@Column(name="telefono_empresa")
	private String telefonoEmpresa;

	public Parametro() {
	}

	public Integer getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
	}

	public String getCorreoEmpresa() {
		return this.correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDescuentoProducto() {
		return this.descuentoProducto;
	}

	public void setDescuentoProducto(String descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}

	public String getDireccionEmpresa() {
		return this.direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public BigDecimal getPorcentajeIva() {
		return this.porcentajeIva;
	}

	public void setPorcentajeIva(BigDecimal porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public String getRucEmpresa() {
		return this.rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public String getTelefonoEmpresa() {
		return this.telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

}