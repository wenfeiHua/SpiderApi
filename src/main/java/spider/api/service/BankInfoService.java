package spider.api.service;

import java.util.List;

import spider.api.mybatis.model.BankInfo;
import spider.api.mybatis.model.BankloanInfo;
import spider.api.mybatis.model.BanksavingsInfo;
import spider.api.mybatis.model.FinancialInfo;

public interface BankInfoService {

	List<BankInfo> getBankList();

	List<BanksavingsInfo> getBankSavingsInfo(String bankname);

	List<BankloanInfo> getBankloanInfo(String bankname);

	List<FinancialInfo> getFinancialInfo(String bankname);

}
