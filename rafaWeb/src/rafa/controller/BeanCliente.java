package rafa.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rafa.model.entities.Cliente;
import rafa.model.manager.ManagerCliente;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanCliente implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerCliente mCliente;
	
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private Cliente clienteSeleccionado, nuevoCliente;

	@PostConstruct
	public void Inicializar()
	{
		cliente = new Cliente();
		listaClientes = mCliente.FindAllCLientes();
	}
	
	public void actionIngresarCliente()
	{
		try {
			mCliente.IngresarCLiente(cliente);
			listaClientes = mCliente.FindAllCLientes();
			cliente = new Cliente();
			JSFUtil.crearMensajeINFO("Se ha registrado exitosamente");
		}catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionEliminarCliente(Integer id) {
		mCliente.EliminarCliente(id);
		listaClientes = mCliente.FindAllCLientes();
		JSFUtil.crearMensajeINFO("Cliente eliminado");
	}
	
	public void actionSeleccionarCliente(Cliente cliente) {
		clienteSeleccionado=cliente;
	}
	
	public void actionActualizarCliente() {
		try {
			mCliente.ActualizarCliente(clienteSeleccionado);
			listaClientes=mCliente.FindAllCLientes();
			JSFUtil.crearMensajeINFO("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionLogin() {
		listaClientes = mCliente.FindAllCLientes();
		for (Cliente c:listaClientes) {
			if(c.getCedulaCliente().equals(nuevoCliente.getCedulaCliente())
					&& c.getContrasenia().equals(nuevoCliente.getContrasenia())) {
				
			}
		}
		return "IniciarSesion";
	}
	//------------------- GETTERS AND SETTERS ----------------------------------
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public Cliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(Cliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}
	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}
}
