package pe.com.j2techcon.bi.etl.process.dimensional;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import pe.com.j2techcon.bi.etl.logic.dimensional.DimTipoDocumentoManager;
import pe.com.j2techcon.bi.etl.logic.generic.TParametroManager;
import pe.com.j2techcon.bi.etl.util.Constantes;
import pe.com.j2techcon.bi.etl.domain.dimensional.DimTipoDocumento;
import pe.com.j2techcon.bi.etl.domain.dimensional.DimTipoDocumentoExample;
import pe.com.j2techcon.bi.etl.domain.generic.TParametro;
import pe.com.j2techcon.bi.etl.domain.generic.TParametroExample;


public class DimTipoDocumentoProcess {
	
	private BeanFactory factory;
	private int sizePage;
	private int dateTimeFrom;
	private int dateTimeUntil;
	private String typeProcess;
	private int process;
	
	private int recordTotal;
	private int recordProcessed;
	private int recordRejected;
	private int resultProcess;
	private int resultTransaction;
	
	private String stateRecordDimensional;
	private String stateRecordGeneric;
	
	private TParametro tParametro;
	private TParametroExample tParametroExample;
	
	private DimTipoDocumento dimTipoDocumento;
	private DimTipoDocumentoExample dimTipoDocumentoExample;
	
	private TParametroManager tParametroManager; 
	private DimTipoDocumentoManager dimTipoDocumentoManager;
	
	private Constantes constantes;

	public BeanFactory getFactory() {
		return factory;
	}

	public void setFactory(BeanFactory factory) {
		this.factory = factory;
	}

	public int getSizePage() {
		return sizePage;
	}

	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}

	public int getDateTimeFrom() {
		return dateTimeFrom;
	}

	public void setDateTimeFrom(int dateTimeFrom) {
		this.dateTimeFrom = dateTimeFrom;
	}

	public int getDateTimeUntil() {
		return dateTimeUntil;
	}

	public void setDateTimeUntil(int dateTimeUntil) {
		this.dateTimeUntil = dateTimeUntil;
	}

	public String getTypeProcess() {
		return typeProcess;
	}

	public void setTypeProcess(String typeProcess) {
		this.typeProcess = typeProcess;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public int getRecordTotal() {
		return recordTotal;
	}

	public void setRecordTotal(int recordTotal) {
		this.recordTotal = recordTotal;
	}

	public int getRecordProcessed() {
		return recordProcessed;
	}

	public void setRecordProcessed(int recordProcessed) {
		this.recordProcessed = recordProcessed;
	}

	public int getRecordRejected() {
		return recordRejected;
	}

	public void setRecordRejected(int recordRejected) {
		this.recordRejected = recordRejected;
	}

	public int getResultProcess() {
		return resultProcess;
	}

	public void setResultProcess(int resultProcess) {
		this.resultProcess = resultProcess;
	}

	public int getResultTransaction() {
		return resultTransaction;
	}

	public void setResultTransaction(int resultTransaction) {
		this.resultTransaction = resultTransaction;
	}

	public String getStateRecordDimensional() {
		return stateRecordDimensional;
	}

	public void setStateRecordDimensional(String stateRecordDimensional) {
		this.stateRecordDimensional = stateRecordDimensional;
	}

	public String getStateRecordGeneric() {
		return stateRecordGeneric;
	}

	public void setStateRecordGeneric(String stateRecordGeneric) {
		this.stateRecordGeneric = stateRecordGeneric;
	}

	public TParametro gettParametro() {
		return tParametro;
	}

	public void settParametro(TParametro tParametro) {
		this.tParametro = tParametro;
	}

	public TParametroExample gettParametroExample() {
		return tParametroExample;
	}

	public void settParametroExample(TParametroExample tParametroExample) {
		this.tParametroExample = tParametroExample;
	}

	public DimTipoDocumento getDimTipoDocumento() {
		return dimTipoDocumento;
	}

	public void setDimTipoDocumento(DimTipoDocumento dimTipoDocumento) {
		this.dimTipoDocumento = dimTipoDocumento;
	}

	public DimTipoDocumentoExample getDimTipoDocumentoExample() {
		return dimTipoDocumentoExample;
	}

	public void setDimTipoDocumentoExample(DimTipoDocumentoExample dimTipoDocumentoExample) {
		this.dimTipoDocumentoExample = dimTipoDocumentoExample;
	}

	public TParametroManager gettParametroManager() {
		return tParametroManager;
	}

	public void settParametroManager(TParametroManager tParametroManager) {
		this.tParametroManager = tParametroManager;
	}

	public DimTipoDocumentoManager getDimTipoDocumentoManager() {
		return dimTipoDocumentoManager;
	}

	public void setDimTipoDocumentoManager(DimTipoDocumentoManager dimTipoDocumentoManager) {
		this.dimTipoDocumentoManager = dimTipoDocumentoManager;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public DimTipoDocumentoProcess(BeanFactory factory, int sizePage,
			int dateTimeFrom, int dateTimeUntil, String typeProcess, int process) {
		this.factory = factory;
		this.sizePage = sizePage;
		this.dateTimeFrom = dateTimeFrom;
		this.dateTimeUntil = dateTimeUntil;
		this.typeProcess = typeProcess;
		this.process = process;
		
		recordTotal = constantes.getValueNumberDefault();
		recordProcessed = constantes.getValueNumberDefault();
		recordRejected = constantes.getValueNumberDefault();
		resultProcess = constantes.getResultProcessStarted();
		resultTransaction = constantes.getResultTransactionNoResult();
		stateRecordDimensional = constantes.getStateRecordNew();
		stateRecordGeneric = constantes.getStateRecordNew();
		
	}

	public int startProcess(){

		tParametroManager = factory.getBean("tParametroManager", TParametroManager.class);
		dimTipoDocumentoManager = factory.getBean("dimTipoDocumentoManager", DimTipoDocumentoManager.class);
		
		constantes = factory.getBean("constantes", Constantes.class);

		int offset = 0;
		
		while(true) {
			
			tParametroExample.clear();
			tParametroExample.createCriteria().andFecNumCamBetween(dateTimeFrom, dateTimeUntil);
			tParametroExample.createCriteria().andParamCodTipEqualTo(constantes.getParamCodeTipoDocumentoTrabajo());
			tParametroExample.setPaginationByClause(" limit " + constantes.getSizePage() + " offset " + offset);
			List<TParametro> lstParametro = tParametroManager.selectByExample(tParametroExample);
			if(lstParametro.size()>0){
				for (Iterator<TParametro> iterator = lstParametro.iterator(); iterator.hasNext();) {
					tParametro = iterator.next();
					dimTipoDocumento.clear();
					processRecordParametro();
				}
				offset = offset + constantes.getSizePage();
			}
			
			if(lstParametro.size()<constantes.getSizePage()){
				
				tParametroExample.clear();
				tParametroExample.createCriteria().andFecNumCamBetween(dateTimeFrom, dateTimeUntil);
				tParametroExample.createCriteria().andParamCodTipEqualTo(constantes.getParamCodeTipoDocumentoTrabajo());
				tParametroExample.createCriteria().andProcIdNotEqualTo(process);
				lstParametro = tParametroManager.selectByExample(tParametroExample);
				if(lstParametro.size()>0){
					for (Iterator<TParametro> iterator = lstParametro.iterator(); iterator.hasNext();) {
						tParametro = iterator.next();
						dimTipoDocumento.clear();
						processRecordParametro();
					}
				}
				
				lstParametro.clear();
				tParametroExample.clear();
				offset = 0;
				break;
			}
		}
		
		if(recordRejected > 0) {
			resultProcess = constantes.getResultProcessCompletedCorrectly();
		}
		else{
			resultProcess = constantes.getResultProcessCompletedErrors();
		}

		return resultProcess;
	}
	
	public void processRecordParametro(){
		
		completeFildTipoDocumento();
		
		if(typeProcess.equals(constantes.getTypeProcessSimple())){
			if(tParametro.getCodIndCam().equals(constantes.getStateRecordNew())){
				if(insertRecordDimensionalTipoDocumento()> constantes.getResultTransactionNoResult()){
					stateRecordGeneric = constantes.getStateRecordProcessed();
					recordProcessed = recordProcessed + 1; 
				} else{
					stateRecordGeneric = constantes.getStateRecordInconsistent();
					recordRejected = recordRejected + 1;
				}
			}else{
				if(updateRecordDimensionalTipoDocumento() > constantes.getResultTransactionNoResult()){
					stateRecordGeneric = constantes.getStateRecordProcessed();
					recordProcessed = recordProcessed + 1; 
				} else{
					stateRecordGeneric = constantes.getStateRecordInconsistent();
					recordRejected = recordRejected + 1;
				}
			}
		}else{
			if(updateRecordDimensionalTipoDocumento() > constantes.getResultTransactionNoResult()){
				stateRecordGeneric = constantes.getStateRecordProcessed();
				recordProcessed = recordProcessed + 1; 
			}else{
				if(insertRecordDimensionalTipoDocumento() > constantes.getResultTransactionNoResult()){
					stateRecordGeneric = constantes.getStateRecordProcessed();
					recordProcessed = recordProcessed + 1;
				}else{
					stateRecordGeneric = constantes.getStateRecordInconsistent();
					recordRejected = recordRejected + 1;
				}
			}
		}
		
		updateRecordGenericParametro(stateRecordGeneric);
	}
	
	public void completeFildTipoDocumento(){
		dimTipoDocumento.setTipoDocumentoKey(tParametro.getParamId());
		dimTipoDocumento.setTipoDocumentoCod(tParametro.getParamCod());
		dimTipoDocumento.setTipoDocumentoDesc(tParametro.getParamDes());
		dimTipoDocumento.setProcId(process);
	}
	
	public int insertRecordDimensionalTipoDocumento(){
		try{
			resultTransaction = dimTipoDocumentoManager.insertSelective(dimTipoDocumento);
		}catch(Exception e){
			resultTransaction = constantes.getResultTransactionNoResult();
		}
		return resultTransaction;
	}
	
	public int updateRecordDimensionalTipoDocumento(){
		try{
			resultTransaction = dimTipoDocumentoManager.updateByPrimaryKeySelective(dimTipoDocumento);
		}catch(Exception e){
			resultTransaction = constantes.getResultTransactionNoResult();
		}
		return resultTransaction;
	}
	
	public int deleteRecordDimensionalTipoDocumento(){
		try{
			resultTransaction = dimTipoDocumentoManager.deleteByPrimaryKey(dimTipoDocumento.getTipoDocumentoKey());
		}catch(Exception e){
			resultTransaction = constantes.getResultTransactionNoResult();
		}
		return resultTransaction; 
	}
	
	public void updateRecordGenericParametro(String statusRecord){
		try{
			int idParametro = tParametro.getParamId();
			tParametro.clear();
			tParametro.setParamId(idParametro);
			tParametro.setCodIndCam(statusRecord);
			tParametro.setProcId(process);
			tParametroManager.updateByPrimaryKeySelective(tParametro);
		}catch(Exception e){
			
		}
	}
}
