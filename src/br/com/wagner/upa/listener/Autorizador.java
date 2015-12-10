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
	 * Executa algo depois da fase. Nessa aplicação, será feita a verificação
	 * do que o usuário está tentando acessar e se ele já está logado ou não.
	 */
	@Override
	public void afterPhase(PhaseEvent event) {
		/*
		 * Valida se a requisição veio a partir de tela de login.
		 *  Nesse caso, não é necessário validar
		 * se se o mesmo está logado ou não.
		 */
		FacesContext context = event.getFacesContext();
		if("/login.xhtml".equals(context.getViewRoot().getViewId())) return;
	
		/*
		 * Caso o usuário esteja tentando acessar uma tela diferente
		 *  da tela de login é necessário
		 * realizar a validação necessária. 
		 * Será necessário obter uma instãncia de LoginBean da sessão,
		 *  que contém o usuáio logado.
		 * Em seguida, faz-se a verificação se o atributo usuário de 
		 * loginBean está nulo ou não.
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
	 * possivel executar o PhaseListener na recuperação das views. Não esquecer
	 * pois sem ele o acesso as páginas sem estar logado é possível pois não
	 * será possível recuperar o identificador de fase bloquear o acesso.
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
