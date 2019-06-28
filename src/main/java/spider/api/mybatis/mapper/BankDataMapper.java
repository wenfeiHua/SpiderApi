package spider.api.mybatis.mapper;


import org.apache.ibatis.annotations.Mapper;
import spider.api.mybatis.model.BankData;


@Mapper
public interface BankDataMapper {
	
	void updateByBankData(BankData record);
}