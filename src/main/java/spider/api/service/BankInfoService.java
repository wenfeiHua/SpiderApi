package spider.api.service;

import java.util.List;

import spider.api.mybatis.model.BankInfo;

public interface BankInfoService {

	List<BankInfo> getBankList();

}
