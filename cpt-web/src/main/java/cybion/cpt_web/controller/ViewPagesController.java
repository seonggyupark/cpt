package cybion.cpt_web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import cybion.cpt_web.controller.action.CybionAction;
import cybion.cpt_web.model.Pagina;

public class ViewPagesController extends AbstractController implements Controller{
	
	private CybionAction action;
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String result = "indexAdmin";
		try {
			if(action.doWork(arg0))
				result = "viewPages";
		}catch(Exception e){e.printStackTrace();}
		
		ModelAndView m = new ModelAndView(result);
		List<Pagina> listaPagine = (List<Pagina>)arg0.getAttribute("listaPagine");
		m.addObject("listaPagine", listaPagine);
		return m;
	}
	
	public CybionAction getAction() {
		return action;
	}


	public void setAction(CybionAction action) {
		this.action = action;
	}


	

}
