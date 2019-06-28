package spider.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spider.api.mybatis.model.BankData;
import spider.api.mybatis.model.BankInfo;
import spider.api.service.BankDataService;
import spider.api.service.BankInfoService;
import spider.api.util.HttpUtils;

@RestController
@RequestMapping("/")
public class BankDataDownloadController {
    
	@Autowired 
	private HttpUtils httpUtils;
	@Autowired
	private BankData bankData;
	@Autowired
	private BankInfoService bankInfoService; 
	@Autowired
	private BankDataService bankDataService;
	
	@RequestMapping(value="/getBankData",method=RequestMethod.GET)
	@ResponseBody
	public String getBankData() {
		List<BankInfo> list=new ArrayList<>();
		//list存放从数据库拿到的银行对象
		list=bankInfoService.getBankList();
		//存放企查查"https://www.qichacha.com/search?key=银行名称" 页面数据
		String qiChaChaDataBySearch=null;
		//存放企查查的官方网址
		String qiChaChaUrl=null;
		//存放企查查指向具体银行信息的a链接的href
		String bankHref=null;
		//存放企查查显示具体银行信息的html页面
		String bankDataHtml=null;
		//存放银行数量
		int bankNum=0;
		if (list.size()>0) {
			for(BankInfo bankInfo : list) {
				qiChaChaUrl="https://www.qichacha.com/search";
				//爬取  "https://www.qichacha.com/search?key=银行名称" 页面
				qiChaChaDataBySearch=httpUtils.doGetHtmlWithParam(qiChaChaUrl, "key", bankInfo.getBankname());
				//获取企查查指向具体银行信息的a链接的href
				bankHref=bankInfoService.getBankHref(qiChaChaDataBySearch);
				//获取企查查存放具体银行信息的html页面
				bankDataHtml=bankInfoService.getBankData(bankHref);
				//解析页面获取银行数据
				bankData=bankInfoService.analysisBankData(bankDataHtml);
				bankData.setBankname(bankInfo.getBankname());
				bankDataService.updateByBankData(bankData);
				bankNum++;
				return "第"+bankNum+"家银行信息： "+bankData.toString();
			}
		}
		return "";
		
	}
   
}
