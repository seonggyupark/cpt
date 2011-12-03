package cybion.cpt_web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import cybion.cpt_web.controller.action.CybionAction;

public class CheckFonteController extends AbstractController implements
		Controller {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private CybionAction action;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String result = "index";
		try {
			if(action.doWork(arg0))
				result = "bandiPerFonte";
		}catch(Exception e){logger.error("CONTROLLER EXCEPTION", e);}		
			ModelAndView m = new ModelAndView(result);
			String message = (String) arg0.getAttribute("message");
			m.addObject("message", message);
			return m;
	}

	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
}
