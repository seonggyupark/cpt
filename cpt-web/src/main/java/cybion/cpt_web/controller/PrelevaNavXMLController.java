package cybion.cpt_web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import cybion.cpt_web.controller.action.CybionAction;
import cybion.cpt_web.model.NavXML;


/**
 * Preleva l'xml di navigazione della fonte identificata dall'ID passato
 * @author tommaso
 *
 */
public class PrelevaNavXMLController extends AbstractController {
	
	private CybionAction action;

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String result = "viewNavXML";
		NavXML navXML = null;
		ModelAndView mav = null;
		try {
				if(action.doWork(req))
				{
					navXML = (NavXML) req.getAttribute("navXML");
				}
			}
		catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		mav = new ModelAndView(result);
		mav.addObject("navXML", navXML);
		return mav;
	}

	public CybionAction getAction() {
		return action;
	}


	public void setAction(CybionAction action) {
		this.action = action;
	}

}
