package br.com.wagner.upa.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.wagner.upa.jpa.JPAUtil;
import br.com.wagner.upa.modelo.Atendimento;

//Define os m�todos especif�cos para manipula��o dos dados de atendimento aos usu�rios.
public class AtendimentoDAO {
	/*
	 * Obt�m todos os atendimentos agendados para uma determinada data.
	 */
	public static List<Atendimento> obterAtendimentosDia(Calendar data){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("from Atendimento a where a.data = :pData");
		query.setParameter("pData", data, TemporalType.DATE);
		@SuppressWarnings("unchecked")
		List<Atendimento> atendimentos = query.getResultList();
		em.close();
		return atendimentos;
	}
}
