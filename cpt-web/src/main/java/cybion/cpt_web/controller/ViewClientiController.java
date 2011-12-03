package cybion.cpt_web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import cybion.cpt_web.controller.action.CybionAction;
import cybion.cpt_web.model.Cliente;

public class ViewClientiController extends AbstractController implements
		Controller {
	
	private CybionAction action;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String result = "indexAdmin";
		try {
			if(action.doWork(arg0))
				result = "viewClienti";
		}catch(Exception e){e.printStackTrace();}
		
		/*Aggiungo la lista di clienti alla pagina*/
		List<Cliente> listaClienti = (List<Cliente>)arg0.getAttribute("listaClienti");
		ModelAndView m = new ModelAndView(result);
		m.addObject("listaClienti", listaClienti);
		return m;
	}

	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
	
	
	

}
