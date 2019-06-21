package spider.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.mybatis.mapper.BankloanInfoMapper;
import spider.api.mybatis.mapper.BanksavingsInfoMapper;
import spider.api.mybatis.mapper.FinancialInfoMapper;
import spider.api.mybatis.model.BankInfo;
import spider.api.mybatis.model.BankInfoExample;
import spider.api.mybatis.model.BankInfoExample.Criteria;
import spider.api.mybatis.model.BankloanInfo;
import spider.api.mybatis.model.BankloanInfoExample;
import spider.api.mybatis.model.BanksavingsInfo;
import spider.api.mybatis.model.BanksavingsInfoExample;
import spider.api.mybatis.model.FinancialInfo;
import spider.api.mybatis.model.FinancialInfoExample;
import spider.api.service.BankInfoService;

@Service
public class BankInfoServiceImpl implements BankInfoService{

	@Autowired
	BankInfoMapper bankInfoMapper;
	@Autowired
	BanksavingsInfoMapper banksavingsInfoMapper;
	@Autowired
	BankloanInfoMapper bankloanInfoMapper;
	@Autowired
	FinancialInfoMapper financialInfoMapper;

	@Override
	public List<BankInfo> getBankList() {
		List<BankInfo> list = new ArrayList<BankInfo>();
		BankInfoExample example =new BankInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdeleteEqualTo(false);
		list = bankInfoMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<BanksavingsInfo> getBankSavingsInfo(String bankname) {
		List<BanksavingsInfo> list = new ArrayList<BanksavingsInfo>();
		BanksavingsInfoExample example = new BanksavingsInfoExample();
		spider.api.mybatis.model.BanksavingsInfoExample.Criteria criteria = example.createCriteria();
		if(bankname != null && bankname != ""){
			criteria.andBanknameEqualTo(bankname);
		}
		criteria.andIsdeleteEqualTo(false);
		list = banksavingsInfoMapper.selectByExample(example);

		return list;
	}

	@Override
	public List<BankloanInfo> getBankloanInfo(String bankname) {
		List<BankloanInfo> list = new ArrayList<BankloanInfo>();
		BankloanInfoExample example = new BankloanInfoExample();
		spider.api.mybatis.model.BankloanInfoExample.Criteria criteria = example.createCriteria();
		if(bankname != null && bankname != ""){
			criteria.andBanknameEqualTo(bankname);
		}
		criteria.andIsdeleteEqualTo(false);
		list = bankloanInfoMapper.selectByExample(example);

		return list;
	}

	@Override
	public List<FinancialInfo> getFinancialInfo(String bankname) {
		List<FinancialInfo> list =new ArrayList<FinancialInfo>();
		FinancialInfoExample example = new FinancialInfoExample();
		spider.api.mybatis.model.FinancialInfoExample.Criteria criteria = example.createCriteria();
		if(bankname != null && bankname != ""){
			criteria.andBanknameEqualTo(bankname);
		}
		criteria.andIsdeleteEqualTo(false);
		list = financialInfoMapper.selectByExample(example);

		return list;
	}

}
