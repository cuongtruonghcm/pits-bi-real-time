package pe.com.j2techcon.bi.etl.dao.origen;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.j2techcon.bi.etl.domain.origen.Despacho;
import pe.com.j2techcon.bi.etl.domain.origen.DespachoExample;

public interface DespachoMapper {
    int countByExample(DespachoExample example);

    int deleteByExample(DespachoExample example);

    int deleteByPrimaryKey(@Param("serieguia") String serieguia, @Param("nroguia") String nroguia);

    int insert(Despacho record);

    int insertSelective(Despacho record);

    List<Despacho> selectByExample(DespachoExample example);

    Despacho selectByPrimaryKey(@Param("serieguia") String serieguia, @Param("nroguia") String nroguia);

    int updateByExampleSelective(@Param("record") Despacho record, @Param("example") DespachoExample example);

    int updateByExample(@Param("record") Despacho record, @Param("example") DespachoExample example);

    int updateByPrimaryKeySelective(Despacho record);

    int updateByPrimaryKey(Despacho record);
}