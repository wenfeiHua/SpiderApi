package spider.api.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import spider.api.model.BankSavingsModel;
import spider.api.model.BankUrlModel;
import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.mybatis.mapper.BanksavingsInfoMapper;
import spider.api.mybatis.model.BanksavingsInfo;
import spider.api.service.BankInfoSetService;
@Service
public class BankInfoSetServiceImpl implements BankInfoSetService{

	@Autowired
	BankInfoMapper bankInfoMapper;

	@Autowired
	BanksavingsInfoMapper banksavingsInfoMapper;

	@Override
	public int setBankInfo() {
		int result = -1;
//		List<BankUrlModel> list = new ArrayList<BankUrlModel>();
//		list = bankInfoMapper.selectBankNameAndUrl();
//		if(list.size() > 0){
//			for (BankUrlModel model : list) {
//				if(!StringUtils.isEmpty(model.getBankname()) && !StringUtils.isEmpty(model.getBankurl())){
//					String bankName = model.getBankname();
//					String bankUrl = model.getBankurl();
//					System.out.println(bankName+"----------------------------------------------------------------------------------------");
					String bankName = "中国光大银行股份有限公司";
					String bankUrl = "www.cebbank.com/ ";
					if(bankUrl.indexOf("//") == -1){
						bankUrl = "http://"+bankUrl.trim().substring(0, bankUrl.length()-1);
						result = setbankinfo(bankName,bankUrl);
					} else {
						bankUrl = bankUrl.trim();
						result = setbankinfo(bankName,bankUrl);
					}
//				}
//			}
//		}
		return result;
	}

//	private int setBankInfo(String Name,String Url){
//		int result = -1;
//		Connection connect = Jsoup.connect("http://" + Url);
//		connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
//		connect.header("Accept-Encoding", "gzip, deflate");
//		connect.header("Accept-Language", "zh-CN,zh;q=0.9,ja;q=0.8,en-US;q=0.7,en;q=0.6");
//		connect.header("Cache-Control", "max-age=0");
//		connect.header("Connection", "keep-alive");
//		connect.header("Host", Url);
//		connect.header("Upgrade-Insecure-Requests", "1");
//		connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
//		try {
//			Document document = connect.get();
//			Elements urls = document.getElementsByTag("a");
//			urls.text().toString();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	private int setbankinfo(String name,String url){
		Connection connect = Jsoup.connect(url);
		Document document = null;
		int result = -1;
		try {
			document = connect.get();
			Elements tagA = document.getElementsByTag("a");
			if(tagA.size() > 0){
				for (Element taga : tagA) {
					System.out.println(taga.text().toString());
					System.out.println(taga.attr("href"));
					if(result == -1){
						if(taga.text().toString().indexOf("存") != -1 && taga.text().toString().indexOf("利率") != -1){
							if(taga.attr("href").indexOf(url) == -1){
								result = setInfo(name,url+taga.attr("href"));
							} else {
								result = setInfo(name,taga.attr("href"));
							}
						} 
//						else {
//							String urls = getUrl(taga.attr("href"));
//							if(!StringUtils.isEmpty(urls)){
//								savingsModel = getInfo(urls);
//								if(savingsModel.size() > 0){
//									model.setResult(1);
//									model.setBaseModelList(savingsModel);
//								}
//							} else {
//								model.setResult(0);
//								model.setErrCode(ErrorMessage.ERROR_CODE001);
//								model.setErrDetail(ErrorMessage.ERROE_DETAIL001);
//							}
//						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	//获取银行存款利率	
	private int setInfo(String name,String url){
		Connection connect = Jsoup.connect(url);
		Document document = null;
		int result = -1;
		Date sysDate = new Date();
		try {
			document = connect.get();
			Elements trs = document.getElementsByTag("table").select("tr");
			BanksavingsInfo record = new BanksavingsInfo();
			record.setBankname(name);
			record.setCreatetime(sysDate);
			record.setUpdatetime(sysDate);
			record.setIsdelete(false);
			for(Element tr: trs){
				if(tr.text().toString().indexOf("活期") != -1 || tr.text().toString().indexOf("活期存款") != -1 && StringUtils.isEmpty(record.getDemanddeposit())){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					record.setDemanddeposit(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("三个月") != -1 && record.getThreemonths() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					record.setThreemonths(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("一年") != -1 && record.getOneyear() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					record.setOneyear(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("二年") != -1 && record.getTwoyears() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					record.setTwoyears(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("三年") != -1 && record.getThreeyears() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					record.setThreeyears(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("五年") != -1 && record.getFiveyears() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					record.setFiveyears(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
			}
			result = banksavingsInfoMapper.insertSelective(record);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
