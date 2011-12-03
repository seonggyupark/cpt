package com.cybion.cpt.web.core.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cybion.cpt.web.core.model.Source;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;



public class CybionJob extends QuartzJobBean implements StatefulJob{
	
	
	private PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());
	


	@Override
	/**
	 * Metodo che viene eseguito dallo scheduler di Spring(modulo Quartz)
	 * secondo la configurazione definita in scheduler-context.xml
	 */
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		try {
		logger.debug("--START JOB--");
		logger.debug(new Date());
		logger.debug("--END JOB--");
		Thread.currentThread().sleep(1000);
		
		
		List<Source> fonti = broker.getAllFonti();
		
		Calendar calendar = Calendar.getInstance();
		int dow = calendar.get(Calendar.DAY_OF_WEEK);
		logger.debug("day of the week - "+dow);
		
		for(Source fonte : fonti) {
			String scheduling = fonte.getScheduling();
			if(checkScheduling(dow, scheduling))
				logger.debug("AVVIAMENTO JOB PER FONTE:"+fonte.getNome()+" SCHEDULING DAY:"+dow+" SCHEDULING STRING:"+scheduling);
		}
		}catch(Exception e){logger.error("ERRORE JOB",e);}
	}
	
	/**
	 * Controlla se nello scheduling è presente il giorno odierno
	 * @param dow: day of the week, ossia il giorno odierno
	 * @param scheduling: la stringa rappresentante lo scheduling della fonte
	 * @return true: se oggi è programmato lo scheduling per tale fonte
	 * @return false: se oggi non è programmato lo scheduling per tale fonte
	 */
	private boolean checkScheduling(int dow, String scheduling){
		if(scheduling!=null)
			return (scheduling.charAt(dow-1)!='0');
		else
			return false;
		
	}
	
	public PersistenceBroker getBroker() {
		return broker;
	}


	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}

}
