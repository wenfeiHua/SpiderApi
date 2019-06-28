package spider.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spider.api.mybatis.mapper.BankDataMapper;
import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.mybatis.mapper.BankloanInfoMapper;
import spider.api.mybatis.mapper.BanksavingsInfoMapper;
import spider.api.mybatis.mapper.FinancialInfoMapper;
import spider.api.mybatis.model.BankData;
import spider.api.mybatis.model.BankInfo;
import spider.api.mybatis.model.BankInfoExample;
import spider.api.mybatis.model.BankInfoExample.Criteria;
import spider.api.mybatis.model.BankloanInfo;
import spider.api.mybatis.model.BankloanInfoExample;
import spider.api.mybatis.model.BanksavingsInfo;
import spider.api.mybatis.model.BanksavingsInfoExample;
import spider.api.mybatis.model.FinancialInfo;
import spider.api.mybatis.model.FinancialInfoExample;
import spider.api.service.BankDataService;
import spider.api.service.BankInfoService;
import spider.api.util.FileOperatorUtil;
import spider.api.util.HttpUtils;

@Service
public class BankDataServiceImpl implements BankDataService{

	@Autowired
	BankDataMapper bankDataMapper;
    /**
     * 更新银行数据
     */
    @Override
    public void updateByBankData(BankData record) {
    	System.out.println(record.toString());
    	bankDataMapper.updateByBankData(record);

    }
}
