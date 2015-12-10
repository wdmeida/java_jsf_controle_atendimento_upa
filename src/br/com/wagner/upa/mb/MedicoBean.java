package br.com.wagner.upa.mb;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.wagner.upa.dao.DAO;
import br.com.wagner.upa.modelo.Medico;

@ViewScoped
@ManagedBean
public class MedicoBean {
	private Medico medico = new Medico();
	private List<Medico> medicos;

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	//Grava as informações de um novo médico no banco.
	public void gravar(){
		DAO<Medico> dao = new DAO<>(Medico.class);
		if(medico.getId() == null) dao.adiciona(medico);
		else dao.atualiza(medico);
		
		medico = new Medico();
		this.medicos = dao.listaTodos();
	}
	
	//Obtém uma lista com todos os médicos cadastrados.
	public List<Medico> getMedicos(){
		if(medicos == null){
			medicos = new DAO<>(Medico.class).listaTodos();
		}
		return medicos;
	}
	
	//Reinstância o objeto, liberando os dados armazemados.
	public void cancela(){
		this.medico = new Medico();
	}
	
	//Remove um médico da lista caso ele não esteja registrado em algum atendimento.
	public void remove(Medico medico){
		try {
			DAO<Medico> dao = new DAO<>(Medico.class);
			dao.remove(medico);
			this.medicos = dao.listaTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Este médico não pode ser removido."));	
		}
	}
}
