package br.com.wagner.upa.mb;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	
	//Remove um médico da lista caso ele não esteja registrado em algum atendimento.
	public void remove(Medico medico){
		DAO<Medico> dao = new DAO<>(Medico.class);
		dao.remove(medico);
		this.medicos = dao.listaTodos();
	}
}
