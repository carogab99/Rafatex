package rafa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rafa.model.entities.Empleado;
import rafa.model.manager.ManagerEmpleado;

@Named
@SessionScoped
public class BeanEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerEmpleado managerEmpleado;
	private List<Empleado> ListaEmpleados;
	private Empleado empleado;
	private boolean panelColapsado;
	private Empleado empleadoSeleccionado;
	private int idRol;
	private int idEmpleado;
	//private Number rol;
	//private Rol rolselec;
	@PostConstruct
	public void inicializar() {
		ListaEmpleados=managerEmpleado.findAllEmpleados();
		empleado=new Empleado();
		panelColapsado=true;
	}
	public void actionListenerInsertarEmpleado() {
		try {
			
			managerEmpleado.insertarEmpleado(empleado,idRol);
			ListaEmpleados=managerEmpleado.findAllEmpleados();
			empleado=new Empleado();
			JSFUtil.crearMensajeINFO("Empleado Ingresado");;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarEmpleado(Integer idempleado) {
		managerEmpleado.eliminarEmpleado(idempleado);
		ListaEmpleados=managerEmpleado.findAllEmpleados();
		JSFUtil.crearMensajeINFO("Empleado eliminado");
	}
	public void actionListenerSeleccionarEmpleado(Empleado empleado) {
		empleadoSeleccionado=empleado;
	}
	public void actionListenerActualizarEmpleado() {
		try {
			managerEmpleado.actualizarEmpleado(empleadoSeleccionado);
			ListaEmpleados=managerEmpleado.findAllEmpleados();
			JSFUtil.crearMensajeINFO("Datos actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}
	public List<Empleado> getListaEmpleados() {
		return ListaEmpleados;
	}
	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		ListaEmpleados = listaEmpleados;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}
	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
}
