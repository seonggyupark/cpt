package com.cybion.cpt.web.core.persistence;

import java.util.List;

import com.cybion.cpt.web.core.model.Client;
import com.cybion.cpt.web.core.model.Concern;
import com.cybion.cpt.web.core.model.CrawledPage;
import com.cybion.cpt.web.core.model.Monitorable;
import com.cybion.cpt.web.core.model.NavigationXML;
import com.cybion.cpt.web.core.model.Source;
import com.cybion.cpt.web.core.model.Statistics;
import com.cybion.cpt.web.core.model.User;


public class PersistenceBroker {
	
	private MonitorableDAO monitorableDAO;
	private ClientDAO clienteDAO;
	private SourceDAO fonteDAO;
	private NavigationXMLDAO navXMLDAO;
	private UserDAO operatoreDAO;
	private CrawledPageDAO paginaDAO;
	private StatisticsDAO statisticsDAO;
	private ConcernDAO interesseDAO;
	
	private static PersistenceBroker singleton = new PersistenceBroker();
	
	/*Costruttore privato per impedire l'istanziazione dall'esterno*/
	private PersistenceBroker(){}
	
	
	/*
	 * Restituisce un istanza della classe
	 * che si occupa di offrire i servizi
	 * dello strato di persistenza.
	 * Implementato tramite singleton e dependency injection
	 */
	public static PersistenceBroker getInstance(){
		return singleton;
	}
	
	public void saveXML(NavigationXML xml) {
		this.navXMLDAO.saveXML(xml);
	}
	
	/*
	 * Aggiorna le statistiche sull'esito del crawling
	 */
	public void updateStatistics(int idFonte, int pagineScaricate){
		this.statisticsDAO.updateStatistics(idFonte, pagineScaricate);
	}
	
	public List<Statistics> getAllStatistics() {
		return this.statisticsDAO.getAllStatistics();
	}
	
	public List<Source> getAllFonti() {
		return this.fonteDAO.retrieveFonti();
	}
	
	public NavigationXML getXMLByFonte(int idFonte){
		Source f = this.fonteDAO.retrieveFonte(idFonte);
		return this.navXMLDAO.getNavXML(f);
	}
	
	public NavigationXML getNavXML(int idNavXML) {
		return this.navXMLDAO.getNavXML(idNavXML);
	}
	
	public Source getFonte(int idFonte){
		return this.fonteDAO.retrieveFonte(idFonte);
	}
	
	public List<CrawledPage> getPages(int idFonte){
		return this.paginaDAO.retrievePages(idFonte);
	}
	
	public void savePage(CrawledPage p){
		this.paginaDAO.savePagina(p);
	}
	
	
	public List<Client> getAllClienti(){
		return clienteDAO.retrieveAllClienti();
	}
	
	public User checkOperatore(String userName, String password) {
		return operatoreDAO.retrieveOperatore(userName, password);
	}
	
	public void saveMonitorable(Monitorable monitorable) {
		this.monitorableDAO.insertMonitorable(monitorable);
	}
	
	public void saveFonte(Source f) {
		this.fonteDAO.insertFonte(f);
	}
	
	public List<NavigationXML> getAllXML(){
		return this.navXMLDAO.getAllXML();
	}
	
	public List<Concern> getAllInteressi(){
		return this.interesseDAO.retrieveAllInteressi();
	}
	
	public void saveInteresse(Concern i){
		this.interesseDAO.insertInteresse(i);
	}
	
	public Concern getInteresse(int idInteresse) {
		return this.interesseDAO.getInteresse(idInteresse);
	}
	
	public void saveCliente(Client c){
		this.clienteDAO.insertCliente(c);
	}
	
	public void deleteFonte(int idFonte){
		Source f = getFonte(idFonte);
		this.fonteDAO.deleteFonte(f);
	}
	
	public void updateFonte(Source f){
		this.fonteDAO.updateFonte(f);
	}
	
	public void deleteCliente(int idCliente){
		Client c = this.clienteDAO.getCliente(idCliente);
		this.clienteDAO.deleteCliente(c);
	}
	
	
	
	/* getter and setter methods */
	
	public MonitorableDAO getMonitorableDAO() {
		return monitorableDAO;
	}

	public CrawledPageDAO getPaginaDAO() {
		return paginaDAO;
	}


	public void setPaginaDAO(CrawledPageDAO paginaDAO) {
		this.paginaDAO = paginaDAO;
	}


	public void setMonitorableDAO(MonitorableDAO monitorableDAO) {
		this.monitorableDAO = monitorableDAO;
	}

	public ClientDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClientDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public SourceDAO getFonteDAO() {
		return fonteDAO;
	}

	public void setFonteDAO(SourceDAO fonteDAO) {
		this.fonteDAO = fonteDAO;
	}

	public NavigationXMLDAO getNavXMLDAO() {
		return navXMLDAO;
	}

	public void setNavXMLDAO(NavigationXMLDAO navXMLDAO) {
		this.navXMLDAO = navXMLDAO;
	}

	public UserDAO getOperatoreDAO() {
		return operatoreDAO;
	}

	public void setOperatoreDAO(UserDAO operatoreDAO) {
		this.operatoreDAO = operatoreDAO;
	}


	public StatisticsDAO getStatisticsDAO() {
		return statisticsDAO;
	}


	public void setStatisticsDAO(StatisticsDAO statisticsDAO) {
		this.statisticsDAO = statisticsDAO;
	}


	public ConcernDAO getInteresseDAO() {
		return interesseDAO;
	}


	public void setInteresseDAO(ConcernDAO interesseDAO) {
		this.interesseDAO = interesseDAO;
	}
	
	
}
