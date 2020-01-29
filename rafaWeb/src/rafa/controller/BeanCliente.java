package rafa.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;

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
	
	private Integer idCliente;
	private String apellidoCliente;
	private String cedulaCliente;
	private String celular;
	private String contrasenia;
	private String correoCliente;
	private String direccionCliente;
	private String nombreCliente;
	private String telefono;


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
			if(c.getCedulaCliente().equals(cliente.getCedulaCliente())
					&& c.getContrasenia().equals(cliente.getContrasenia())) {
				idCliente=c.getIdCliente();
			
			}
		}
		return "catalogo";
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
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
