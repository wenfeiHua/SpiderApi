package spider.api.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spider.api.mybatis.model.FinancialInfo;
import spider.api.mybatis.model.FinancialInfoExample;
@Mapper
public interface FinancialInfoMapper {
	int countByExample(FinancialInfoExample example);

	int deleteByExample(FinancialInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(FinancialInfo record);

	int insertSelective(FinancialInfo record);

	List<FinancialInfo> selectByExample(FinancialInfoExample example);

	FinancialInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") FinancialInfo record, @Param("example") FinancialInfoExample example);

	int updateByExample(@Param("record") FinancialInfo record, @Param("example") FinancialInfoExample example);

	int updateByPrimaryKeySelective(FinancialInfo record);

	int updateByPrimaryKey(FinancialInfo record);
}