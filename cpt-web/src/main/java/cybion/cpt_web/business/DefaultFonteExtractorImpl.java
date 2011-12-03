package cybion.cpt_web.business;

//import it.uniroma3.website.html.extensional.HTMLPage;
//import it.uniroma3.website.model.extensional.Page;
//
//import java.io.IOException;
//
//import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
//import org.jdom.JDOMException;

//public class DefaultFonteExtractorImpl implements Extractor {

//	private UIMAExecutor uimaExecutor;
//	private WebpipeExecutor webpipeExecutor;
//	
//	public DefaultFonteExtractorImpl(WebpipeExecutor webpipeExecutor, UIMAExecutor uimaExecutor) {
//		this.setUimaExecutor(uimaExecutor);
//		this.setWebpipeExecutor(webpipeExecutor);
//	}
//	
//	
//	public boolean execute() {
//		boolean ok = true;
//		try {
//			for (Page p : webpipeExecutor.fireCrawling()) {
//				HTMLPage page = (HTMLPage) p;
//				uimaExecutor.analyzeDocument(page.getHtmlUnitPage().getWebResponse().getContentAsString());
//			}
//		} catch (JDOMException e) {
//			ok = false;
//			e.printStackTrace();
//		} catch (IOException e) {
//			ok = false;
//			e.printStackTrace();
//		} catch (AnalysisEngineProcessException e) {
//			ok = false;
//			e.printStackTrace();
//		}
//		
//		return ok;
//		}
//
//
//	protected void setWebpipeExecutor(WebpipeExecutor webpipeExecutor) {
//		this.webpipeExecutor = webpipeExecutor;	}
//	}
//	protected void setUimaExecutor(UIMAExecutor uimaExecutor) {
//		this.uimaExecutor = uimaExecutor;
//	}


//}
