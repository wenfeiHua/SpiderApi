package spider.api.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spider.api.mybatis.model.BankInfo;
import spider.api.mybatis.model.BankInfoExample;

@Mapper
public interface BankInfoMapper {
	int countByExample(BankInfoExample example);

	int deleteByExample(BankInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(BankInfo record);

	int insertSelective(BankInfo record);

	List<BankInfo> selectByExample(BankInfoExample example);

	BankInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BankInfo record, @Param("example") BankInfoExample example);

	int updateByExample(@Param("record") BankInfo record, @Param("example") BankInfoExample example);

	int updateByPrimaryKeySelective(BankInfo record);

	int updateByPrimaryKey(BankInfo record);
}