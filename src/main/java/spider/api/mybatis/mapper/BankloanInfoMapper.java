package spider.api.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spider.api.mybatis.model.BankloanInfo;
import spider.api.mybatis.model.BankloanInfoExample;
@Mapper
public interface BankloanInfoMapper {
	int countByExample(BankloanInfoExample example);

	int deleteByExample(BankloanInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(BankloanInfo record);

	int insertSelective(BankloanInfo record);

	List<BankloanInfo> selectByExample(BankloanInfoExample example);

	BankloanInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BankloanInfo record, @Param("example") BankloanInfoExample example);

	int updateByExample(@Param("record") BankloanInfo record, @Param("example") BankloanInfoExample example);

	int updateByPrimaryKeySelective(BankloanInfo record);

	int updateByPrimaryKey(BankloanInfo record);
}