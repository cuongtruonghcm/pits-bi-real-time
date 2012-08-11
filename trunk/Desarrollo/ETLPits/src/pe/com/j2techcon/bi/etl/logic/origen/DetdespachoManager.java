package pe.com.j2techcon.bi.etl.logic.origen;

import java.util.List;

import pe.com.j2techcon.bi.etl.dao.origen.DetdespachoMapper;
import pe.com.j2techcon.bi.etl.domain.origen.Detdespacho;
import pe.com.j2techcon.bi.etl.domain.origen.DetdespachoExample;

public class DetdespachoManager {
	
	private DetdespachoMapper detdespachoMapper;

	public DetdespachoMapper getDetdespachoMapper() {
		return detdespachoMapper;
	}

	public void setDetdespachoMapper(DetdespachoMapper detdespachoMapper) {
		this.detdespachoMapper = detdespachoMapper;
	}

	public int countByExample(DetdespachoExample example) {
		return detdespachoMapper.countByExample(example);
	}

	public int deleteByExample(DetdespachoExample example) {
		return detdespachoMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(String serieguia, String nroguia,
			String serie, String orden, String correlativo) {
		return detdespachoMapper.deleteByPrimaryKey(serieguia, nroguia, serie, orden, correlativo);
	}

	public int insert(Detdespacho record) {
		return detdespachoMapper.insert(record);
	}

	public int insertSelective(Detdespacho record) {
		return detdespachoMapper.insertSelective(record);
	}

	public List<Detdespacho> selectByExample(DetdespachoExample example) {
		return detdespachoMapper.selectByExample(example);
	}

	public Detdespacho selectByPrimaryKey(String serieguia, String nroguia,
			String serie, String orden, String correlativo) {
		return detdespachoMapper.selectByPrimaryKey(serieguia, nroguia, serie, orden, correlativo);
	}

	public int updateByExampleSelective(Detdespacho record,
			DetdespachoExample example) {
		return detdespachoMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Detdespacho record, DetdespachoExample example) {
		return detdespachoMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Detdespacho record) {
		return detdespachoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Detdespacho record) {
		return detdespachoMapper.updateByPrimaryKey(record);
	}

}
