package cybion.cpt_web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import cybion.cpt_web.controller.action.CybionAction;

public class InsertClienteController extends AbstractController implements Controller{
	
	private Logger logger = Logger.getLogger(this.getClass());
	private CybionAction action;
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = "insertCliente";
		try {
			if(action.doWork(request));
				result = "success";
			
			
		}catch(Exception e){logger.error("CONTROLLER EXCEPTION", e);}
		String s = (String)request.getAttribute("message");
		ModelAndView m = new ModelAndView(result);
		m.addObject("message", s);
		return m;
	}

	public CybionAction getAction() {
		return action;
	}

	public void setAction(CybionAction action) {
		this.action = action;
	}
	
	
	

}
