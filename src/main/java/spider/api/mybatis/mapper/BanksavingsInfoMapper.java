package spider.api.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spider.api.mybatis.model.BanksavingsInfo;
import spider.api.mybatis.model.BanksavingsInfoExample;
@Mapper
public interface BanksavingsInfoMapper {
	int countByExample(BanksavingsInfoExample example);

	int deleteByExample(BanksavingsInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(BanksavingsInfo record);

	int insertSelective(BanksavingsInfo record);

	List<BanksavingsInfo> selectByExample(BanksavingsInfoExample example);

	BanksavingsInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BanksavingsInfo record,
			@Param("example") BanksavingsInfoExample example);

	int updateByExample(@Param("record") BanksavingsInfo record, @Param("example") BanksavingsInfoExample example);

	int updateByPrimaryKeySelective(BanksavingsInfo record);

	int updateByPrimaryKey(BanksavingsInfo record);
}