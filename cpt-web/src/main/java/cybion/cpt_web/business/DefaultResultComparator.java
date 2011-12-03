package cybion.cpt_web.business;

import java.util.List;

import cybion.cpt_web.persistence.PersistenceBroker;

public class DefaultResultComparator implements ResultComparator {

  private PersistenceBroker broker;
  
  //cannot instantiate without argument
  @SuppressWarnings("unused")
  private DefaultResultComparator(){
    
  }
  
  public DefaultResultComparator(final PersistenceBroker pbroker) {
    broker = pbroker;
  }

  public void filter(List<UIMAResult> results, int idFonte) {
    // TODO Auto-generated method stub
    
  }

}
