package br.com.wagner.upa.mb;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wagner.upa.dao.AtendimentoDAO;
import br.com.wagner.upa.dao.DAO;
import br.com.wagner.upa.modelo.Atendimento;

@ViewScoped
@ManagedBean
public class AtendimentoBean {
	private Atendimento atendimento = new Atendimento();
	private List<Atendimento> atendimentos;
	private Calendar dataHoje = Calendar.getInstance();
	
	public Calendar getDataHoje() {
		return dataHoje;
	}

	public void setDataHoje(Calendar dataHoje) {
		this.dataHoje = dataHoje;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public void gravar(){
		DAO<Atendimento> dao = new DAO<>(Atendimento.class);
		if(atendimento.getId() == null) dao.adiciona(atendimento);
		else dao.atualiza(atendimento);
		
		atendimento = new Atendimento();
	}
	
	public List<Atendimento> getAtendimentosDoDia(){
		atendimentos = AtendimentoDAO.obterAtendimentosDia(dataHoje);
		return atendimentos;
	}
	
	public List<Atendimento> getAtendimentos(){
		DAO<Atendimento> dao = new DAO<Atendimento>(Atendimento.class);
		List<Atendimento> atendimentos = dao.listaTodos();
		return atendimentos;
	}
	
	public void cancela(){
		atendimento = new Atendimento();
	}
}
