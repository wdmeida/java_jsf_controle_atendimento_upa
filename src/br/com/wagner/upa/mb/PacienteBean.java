package br.com.wagner.upa.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.wagner.upa.dao.DAO;
import br.com.wagner.upa.modelo.Paciente;

@ViewScoped
@ManagedBean
public class PacienteBean {
	private Paciente paciente = new Paciente();
	private List<Paciente> pacientes;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void gravar(){
		DAO<Paciente> dao = new DAO<>(Paciente.class);
		if(paciente.getId() == null) dao.adiciona(paciente);
		else dao.atualiza(paciente);
		
		paciente = new Paciente();
		pacientes = dao.listaTodos();
	}
	
	public List<Paciente> getPacientes(){
		if(pacientes == null){
			pacientes = new DAO<>(Paciente.class).listaTodos();
		}
		return pacientes;
	}
	
	public void remove(Paciente paciente){
		try {
			DAO<Paciente> dao = new DAO<>(Paciente.class);
			dao.remove(paciente);
			pacientes = dao.listaTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este paciente não pode ser removido."));
		}
	}
	
	public void cancela(){
		this.paciente =  new Paciente();
	}
}
