package cybion.cpt_web.controller.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cybion.cpt_web.business.UIMAExecutor;
import cybion.cpt_web.model.Metadata;
import cybion.cpt_web.model.Pagina;
import cybion.cpt_web.persistence.PersistenceBroker;

public class ViewAnnotationsAction implements CybionAction {

  private Logger logger = Logger.getLogger(this.getClass());

  private PersistenceBroker broker;

  private final UIMAExecutor uimaExecutor = new UIMAExecutor();

  public PersistenceBroker getBroker() {
    return broker;
  }

  public void setBroker(PersistenceBroker broker) {
    this.broker = broker;
  }

  public boolean doWork(HttpServletRequest request) {
    boolean result = false;
    List<Metadata> listaAnnotations = new LinkedList<Metadata>();
    try {
      int idFonte = Integer.parseInt(request.getParameter("idFonte"));
      List<Pagina> listaPagine = broker.getPages(idFonte);
      for (Pagina p : listaPagine) {
        listaAnnotations.addAll(uimaExecutor.analyzeDocument(p.getContent()).getMetadatas());
      }
      request.setAttribute("listaAnnotation", listaAnnotations);
      result = true;
    } catch (Exception e) {
      logger.error(new StringBuilder("ERRORE : ").append(e.getLocalizedMessage()).toString(), e);
    }
    return result;
  }

  // @Deprecated
  // public boolean oldDoWork(HttpServletRequest request) {
  // boolean result = false;
  // List<Metadata> listaAnnotations = new LinkedList<Metadata>();
  // try {
  // listaAnnotations = uimaExecutor.analyzeDocument(doc).getMetadatas();
  // System.out.println("annotations size : "+listaAnnotations.size());
  // request.setAttribute("listaAnnotation", listaAnnotations);
  // result = true;
  // }catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
  // return result;
  // }

  // FIXME static string to analyze
  private final String doc = "Competition objectives The Investigator-Initiated Research Grant (IIRG) forms the backbone of the Alzheimer?s Association grant program. To be considered responsive, the research grant application must address a question or questions relevant to the 2009 areas of focus (see Section II, pages 3?12, of the program announcement) or a compelling issue in Alzheimer research pertinent to the applicant?s special interest or expertise."
          + "The Alzheimer?s Association recognizes the need to increase the number of scientists from underrepresented groups in the research enterprise. Researchers from these groups are encouraged to apply."
          + "Funding and award period: The Association anticipates funding 55 awards under the IIRG program. Each total award is limited to $240,000 (direct and indirect costs) for up to three years. Requests in any given year may not exceed $100,000 (direct and indirect costs). Indirect costs are capped at 10 percent (rent for laboratory/office space is expected to be covered by indirect costs paid to the institution)."
          + "Eligibility: Researchers with full-time staff or faculty appointments are encouraged to apply. IIRG applications from post-doctoral candidates will not be accepted."
          + "Deadlines and award dates:  Letters of intent must be received by 5:00 p.m. EASTERN STANDARD TIME, December 1, 2008. Letters of intent will not be accepted after this date. No exceptions will be made."
          + "Applications must be received by 5:00 p.m. EASTERN STANDARD TIME, January 8, 2009. Scientific and technical review will be conducted from February through May 2009."
          + "The second-level review by the Medical and Scientific Advisory Council will be conducted during June 2009. Funding will be awarded by July 2009."
          + "Mechanism of award, reporting requirements and allowable costs: The mechanism of award is the individual research grant. The maximum duration of award is three years. Annual progress and financial reports are required.  Continuation of the grant over the awarded duration is contingent upon the timely submission of interim scientific and financial reports."
          + "Budget: A ?budget summary? for the proposed research project is required and must be submitted with the application and within the allowable page limits. However, if the application is to be awarded, a more detailed budget will be required and must be approved prior to the disbursement of funds. Your budget must not exceed the maximum amount of the award ($240,000 for IIRG)."
          + "Allowable costs under this award"
          + "    *  It is required that most of the funds awarded under this program be used for direct research support."
          + "Other allowable costs include:"
          + "    * Purchase and care of laboratory animals"
          + "   * Small pieces of laboratory equipment and laboratory supplies"
          + "    * Computer software if used strictly for data collection"
          + "   * Salary for the principal investigator, scientific (including post-doctoral fellows) and technical staff (including laboratory technicians and administrative support related directly to the funded project)"
          + "    * Travel to scientific and professional meetings, not to exceed $1,000 per year"
          + "Costs not allowed under this award include:"
          + "    * Tuition"
          + "    * Computer hardware or standard software (e.g., Microsoft Office) for investigators"
          + "    * Construction or renovation costs"
          + "    * Rent for laboratory/office space"
          + "    * Construction or renovation costs";

}
