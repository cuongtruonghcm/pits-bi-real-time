package pe.com.j2techcon.bi.etl.dao.origen;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.j2techcon.bi.etl.domain.origen.TTipopersonal;
import pe.com.j2techcon.bi.etl.domain.origen.TTipopersonalExample;

public interface TTipopersonalMapper {
    int countByExample(TTipopersonalExample example);

    int deleteByExample(TTipopersonalExample example);

    int deleteByPrimaryKey(String codtipopersonal);

    int insert(TTipopersonal record);

    int insertSelective(TTipopersonal record);

    List<TTipopersonal> selectByExample(TTipopersonalExample example);

    TTipopersonal selectByPrimaryKey(String codtipopersonal);

    int updateByExampleSelective(@Param("record") TTipopersonal record, @Param("example") TTipopersonalExample example);

    int updateByExample(@Param("record") TTipopersonal record, @Param("example") TTipopersonalExample example);

    int updateByPrimaryKeySelective(TTipopersonal record);

    int updateByPrimaryKey(TTipopersonal record);
}