package spider.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.mybatis.model.BankInfo;
import spider.api.mybatis.model.BankInfoExample;
import spider.api.mybatis.model.BankInfoExample.Criteria;
import spider.api.service.BankInfoService;

@Service
public class BankInfoServiceImpl implements BankInfoService{

	@Autowired
	BankInfoMapper bankInfoMapper;
	
	@Override
	public List<BankInfo> getBankList() {
		List<BankInfo> list = new ArrayList<BankInfo>();
		BankInfoExample example =new BankInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdeleteEqualTo(false);
		list = bankInfoMapper.selectByExample(example);
		return list;
	}

}
