package pe.com.j2techcon.bi.etl.logic.generic;

import java.util.List;

import pe.com.j2techcon.bi.etl.dao.generic.TOrdenMapper;
import pe.com.j2techcon.bi.etl.domain.generic.TOrden;
import pe.com.j2techcon.bi.etl.domain.generic.TOrdenExample;

public class TOrdenManager {
	
	private TOrdenMapper tOrdenMapper;

	public TOrdenMapper gettOrdenMapper() {
		return tOrdenMapper;
	}

	public void settOrdenMapper(TOrdenMapper tOrdenMapper) {
		this.tOrdenMapper = tOrdenMapper;
	}

	public int countByExample(TOrdenExample example) {
		return tOrdenMapper.countByExample(example);
	}

	public int deleteByExample(TOrdenExample example) {
		return tOrdenMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer ordId) {
		return tOrdenMapper.deleteByPrimaryKey(ordId);
	}

	public int insert(TOrden record) {
		return tOrdenMapper.insert(record);
	}

	public int insertSelective(TOrden record) {
		return tOrdenMapper.insertSelective(record);
	}

	public List<TOrden> selectByExample(TOrdenExample example) {
		return tOrdenMapper.selectByExample(example);
	}

	public TOrden selectByPrimaryKey(Integer ordId) {
		return tOrdenMapper.selectByPrimaryKey(ordId);
	}

	public int updateByExampleSelective(TOrden record, TOrdenExample example) {
		return tOrdenMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(TOrden record, TOrdenExample example) {
		return tOrdenMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(TOrden record) {
		return tOrdenMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TOrden record) {
		return tOrdenMapper.updateByPrimaryKey(record);
	}

}