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
import spider.api.service.BankInfoService;
import spider.api.util.FileOperatorUtil;
import spider.api.util.HttpUtils;

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
	@Autowired 
	HttpUtils httpUtils;
	@Autowired
	BankData bankData;

	@Override
	public List<BankInfo> getBankList() {
		List<BankInfo> list = new ArrayList<BankInfo>();
		BankInfoExample example =new BankInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdeleteEqualTo(false);
		//list = bankInfoMapper.selectByExample(example);
		list=bankInfoMapper.selectBankName();
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
	
	/**
	 * 从文件"BankName.txt"中获取银行url
	 * @return 一个存放银行url的list
	 */
    @Override
    public String getBankUrlFormFile() {
    	String bankFilePathString="bankName.txt";
    	List<String> bankUrlList=FileOperatorUtil.readFromFile(bankFilePathString, "utf8");
    	String bankName=null;
    	if (bankUrlList!=null && bankUrlList.size()>=2) {
			bankName=bankUrlList.get(1);
		}
    	return bankName;
    	
    }
    
    /**
     * 解析html字符串，获取企查查的具体银行界面的a链接的href
     * @param html 爬取的企查查页面（https://www.qichacha.com/search?key=银行名称）
     * @return href 企查查页面具体指向具体银行信息的a链接的href
     */
    @Override
    public String getBankHref(String html) {
    	Document doc=Jsoup.parse(html,"utf8");
    	Elements ele=doc.select("a.ma_h1");
    	String href=ele.attr("href");
    	return href;
    }
    
    /**
     * 获取企查查的具体银行界面的html
     * @param href 企查查页面具体指向具体银行信息的a链接的href
     * @return html 企查查具体银行信息的页面
     */
    @Override
    public String getBankData(String href) {
    	System.out.println("打飞"+href);
    	String QichachaUrl="https://www.qichacha.com";
    	System.out.println(QichachaUrl+href);
        String html=httpUtils.doGetHtml(QichachaUrl+href);
    	return html;
    }
    
    /**
     * 解析企查查的具体银行界面，获取信息
     * @param data 企查查具体银行信息的页面
     * @return BankData 一家具体银行信息的对象
     */
    @Override
    public BankData analysisBankData(String data) {
    	Document doc=Jsoup.parse(data,"utf8");
    	//获取银行的官方网址
    	Element ele=doc.select("span.cvlu").get(1);
    	String bankUrl=ele.text();
    	//获取银行的所在地址
    	Element bankAddress1=doc.select("span.cvlu").get(3);
    	Element  bankAddress=bankAddress1.children().first();
    	String address=bankAddress.text();
    	//获取银行的注册资本金
    	Element principal=doc.select("section#ipoBase table.ntable tbody tr").get(3).child(1);
    	String principalData=principal.text();
    	bankData.setBankurl(bankUrl);
    	bankData.setAddress(address);
    	bankData.setPrincipal(principalData);
    	return bankData;
    }
    
}
