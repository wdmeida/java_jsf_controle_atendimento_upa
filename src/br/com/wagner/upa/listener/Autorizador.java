package br.com.wagner.upa.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.wagner.upa.mb.LoginBean;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Executa algo depois da fase. Nessa aplica��o, ser� feita a verifica��o
	 * do que o usu�rio est� tentando acessar e se ele j� est� logado ou n�o.
	 */
	@Override
	public void afterPhase(PhaseEvent event) {
		/*
		 * Valida se a requisi��o veio a partir de tela de login.
		 *  Nesse caso, n�o � necess�rio validar
		 * se se o mesmo est� logado ou n�o.
		 */
		FacesContext context = event.getFacesContext();
		if("/login.xhtml".equals(context.getViewRoot().getViewId())) return;
	
		/*
		 * Caso o usu�rio esteja tentando acessar uma tela diferente
		 *  da tela de login � necess�rio
		 * realizar a valida��o necess�ria. 
		 * Ser� necess�rio obter uma inst�ncia de LoginBean da sess�o,
		 *  que cont�m o usu�io logado.
		 * Em seguida, faz-se a verifica��o se o atributo usu�rio de 
		 * loginBean est� nulo ou n�o.
		 */
		LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		if(!loginBean.isLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Recupera o identificador atual de uma determinada fase, para que seja
	 * possivel executar o PhaseListener na recupera��o das views. N�o esquecer
	 * pois sem ele o acesso as p�ginas sem estar logado � poss�vel pois n�o
	 * ser� poss�vel recuperar o identificador de fase bloquear o acesso.
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
