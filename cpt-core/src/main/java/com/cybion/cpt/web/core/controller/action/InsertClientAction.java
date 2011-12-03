package com.cybion.cpt.web.core.controller.action;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cybion.cpt.web.core.model.Client;
import com.cybion.cpt.web.core.model.Concern;
import com.cybion.cpt.web.core.persistence.PersistenceBroker;


public class InsertClientAction implements CybionAction{

	
	private PersistenceBroker broker;
	private Logger logger = Logger.getLogger(this.getClass());

	
	
	
	public boolean doWork(HttpServletRequest request) {
		boolean result = false;
		try {
			String nome = request.getParameter("name");
			String email = request.getParameter("email");
			String [] interessiString = request.getParameterValues("interessi");
			List<Integer> interessi = resolveInteressi(interessiString); //estrae gli interessi
			Set<Concern> setInteressi = new HashSet<Concern>();
			for (int i : interessi) {
				Concern interesse = broker.getInteresse(i);
				setInteressi.add(interesse);
			}
			Client c = new Client();
			c.setEmail(email);
			c.setNome(nome);
			c.setSetInteressi(setInteressi);
			broker.saveCliente(c);
			request.setAttribute("message", "Hai inserito le informazioni per il cliente"+c.getNome());
		}catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);
		e.printStackTrace();}
		
		
		return result;
	}
	
	
	
	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		this.broker = broker;
	}
	
	/*Estrae i valori dal parametro della option multipla */
	private List<Integer> resolveInteressi(String[] interessiString){
		List<Integer> resultList = new LinkedList<Integer>();
		try{ 
			int i = 0;
			while(i<interessiString.length) {
				resultList.add(Integer.valueOf(interessiString[i]));
				i++;
			}
		}catch(Exception e){e.printStackTrace();}
		return resultList;
	}
	
}
