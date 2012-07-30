package cybion.cpt_test;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.EntityProcessStatus;
import org.apache.uima.collection.StatusCallbackListener;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;
import org.junit.Ignore;

@Ignore
public class DummyStatusCallbackListenerImpl implements StatusCallbackListener {

  private Logger logger;
  private int entityCount = 0;

  public DummyStatusCallbackListenerImpl(Logger logger) {
    this.logger = logger;
  }
  public void entityProcessComplete(CAS aCas, EntityProcessStatus aStatus) {
    entityCount++;
    logger.log(Level.INFO,"process complete ("+entityCount+")");
  }

  public void aborted() {
    logger.log(Level.INFO,"aborted");
  }

  public void batchProcessComplete() {
    logger.log(Level.INFO,"batch process complete");
  }

  public void collectionProcessComplete() {
    logger.log(Level.INFO,"cp complete");
  }

  public void initializationComplete() {
    logger.log(Level.INFO,"initialization complete");
  }

  public void paused() {
    logger.log(Level.INFO,"paused");
  }

  public void resumed() {
    logger.log(Level.INFO,"aborted");
  }

}
