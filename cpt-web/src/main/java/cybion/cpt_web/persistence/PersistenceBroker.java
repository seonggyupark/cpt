package cybion.cpt_web.persistence;

import java.util.List;

import cybion.cpt_web.model.Bando;
import cybion.cpt_web.model.Cliente;
import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.model.Interesse;
import cybion.cpt_web.model.NavXML;
import cybion.cpt_web.model.Operatore;
import cybion.cpt_web.model.Pagina;
import cybion.cpt_web.model.Statistics;

public class PersistenceBroker {
	
	private BandoDAO bandoDAO;
	private ClienteDAO clienteDAO;
	private FonteDAO fonteDAO;
	private NavXMLDAO navXMLDAO;
	private OperatoreDAO operatoreDAO;
	private PaginaDAO paginaDAO;
	private StatisticsDAO statisticsDAO;
	private InteresseDAO interesseDAO;
	
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
	
	public void saveXML(NavXML xml) {
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
	
	public List<Fonte> getAllFonti() {
		return this.fonteDAO.retrieveFonti();
	}
	
	public NavXML getXMLByFonte(int idFonte){
		Fonte f = this.fonteDAO.retrieveFonte(idFonte);
		return this.navXMLDAO.getNavXML(f);
	}
	
	public NavXML getNavXML(int idNavXML) {
		return this.navXMLDAO.getNavXML(idNavXML);
	}
	
	public Fonte getFonte(int idFonte){
		return this.fonteDAO.retrieveFonte(idFonte);
	}
	
	public List<Pagina> getPages(int idFonte){
		return this.paginaDAO.retrievePages(idFonte);
	}
	
	public void savePage(Pagina p){
		this.paginaDAO.savePagina(p);
	}
	
	
	public List<Cliente> getAllClienti(){
		return clienteDAO.retrieveAllClienti();
	}
	
	public Operatore checkOperatore(String userName, String password) {
		return operatoreDAO.retrieveOperatore(userName, password);
	}
	
	public void saveBando(Bando b) {
		this.bandoDAO.insertBando(b);
	}
	
	public void saveFonte(Fonte f) {
		this.fonteDAO.insertFonte(f);
	}
	
	public List<NavXML> getAllXML(){
		return this.navXMLDAO.getAllXML();
	}
	
	public List<Interesse> getAllInteressi(){
		return this.interesseDAO.retrieveAllInteressi();
	}
	
	public void saveInteresse(Interesse i){
		this.interesseDAO.insertInteresse(i);
	}
	
	public Interesse getInteresse(int idInteresse) {
		return this.interesseDAO.getInteresse(idInteresse);
	}
	
	public void saveCliente(Cliente c){
		this.clienteDAO.insertCliente(c);
	}
	
	public void deleteFonte(int idFonte){
		Fonte f = getFonte(idFonte);
		this.fonteDAO.deleteFonte(f);
	}
	
	public void updateFonte(Fonte f){
		this.fonteDAO.updateFonte(f);
	}
	
	public void deleteCliente(int idCliente){
		Cliente c = this.clienteDAO.getCliente(idCliente);
		this.clienteDAO.deleteCliente(c);
	}
	
	
	
	/* getter and setter methods */
	
	public BandoDAO getBandoDAO() {
		return bandoDAO;
	}

	public PaginaDAO getPaginaDAO() {
		return paginaDAO;
	}


	public void setPaginaDAO(PaginaDAO paginaDAO) {
		this.paginaDAO = paginaDAO;
	}


	public void setBandoDAO(BandoDAO bandoDAO) {
		this.bandoDAO = bandoDAO;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public FonteDAO getFonteDAO() {
		return fonteDAO;
	}

	public void setFonteDAO(FonteDAO fonteDAO) {
		this.fonteDAO = fonteDAO;
	}

	public NavXMLDAO getNavXMLDAO() {
		return navXMLDAO;
	}

	public void setNavXMLDAO(NavXMLDAO navXMLDAO) {
		this.navXMLDAO = navXMLDAO;
	}

	public OperatoreDAO getOperatoreDAO() {
		return operatoreDAO;
	}

	public void setOperatoreDAO(OperatoreDAO operatoreDAO) {
		this.operatoreDAO = operatoreDAO;
	}


	public StatisticsDAO getStatisticsDAO() {
		return statisticsDAO;
	}


	public void setStatisticsDAO(StatisticsDAO statisticsDAO) {
		this.statisticsDAO = statisticsDAO;
	}


	public InteresseDAO getInteresseDAO() {
		return interesseDAO;
	}


	public void setInteresseDAO(InteresseDAO interesseDAO) {
		this.interesseDAO = interesseDAO;
	}
	
	
}
