package spider.api.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import spider.api.model.BankUrlModel;
import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.mybatis.mapper.BanksavingsInfoMapper;
import spider.api.mybatis.model.BanksavingsInfo;
import spider.api.service.BankInfoSetService;
@Service
public class BankInfoSetServiceImpl implements BankInfoSetService{

//	public String staticURL = "";

	@Autowired
	BankInfoMapper bankInfoMapper;

	@Autowired
	BanksavingsInfoMapper banksavingsInfoMapper;

	@Override
	public int setBankInfo() {
		int result = -1;
		String staticURL = "";
//		List<BankUrlModel> list = new ArrayList<BankUrlModel>();
//		list = bankInfoMapper.selectBankNameAndUrl();
//		if(list.size() > 0){
//			for (BankUrlModel model : list) {
//				if(!StringUtils.isEmpty(model.getBankname()) && !StringUtils.isEmpty(model.getBankurl())){
//					String bankName = model.getBankname();
//					String bankUrl = model.getBankurl();
//					System.out.println(bankName+"----------------------------------------------------------------------------------------");
					String bankName = "齐鲁银行股份有限公司";
					String bankUrl = "www.hzbank.com.cn/ ";
					if(bankUrl.indexOf("//") == -1){
						bankUrl = "http://"+bankUrl.trim().substring(0, bankUrl.length()-2);
						result = setbankinfo(staticURL,bankName,bankUrl);
					} else {
						bankUrl = bankUrl.trim();
						result = setbankinfo(staticURL,bankName,bankUrl);
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
	
	private int setbankinfo(String staticURL,String name,String url){
		Connection connect = Jsoup.connect(url);
		connect.timeout(4000); 
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
							if(!StringUtils.isEmpty(taga.attr("href")) && taga.attr("href").indexOf(url) == -1 && taga.attr("href").indexOf("/") != -1){
								result = setInfo(name,url+taga.attr("href"));
							} else if (!StringUtils.isEmpty(taga.attr("href")) && taga.attr("href").indexOf(url) != -1 && taga.attr("href").indexOf("/") != -1) {
								result = setInfo(name,taga.attr("href"));
							}
						} 
//						else {
//							if(!StringUtils.isEmpty(taga.attr("href")) && taga.attr("href").indexOf(url) == -1){
//								String urls = getUrl(staticURL,url,url+taga.attr("href"));
//								if(!StringUtils.isEmpty(urls) && urls.indexOf(url) == -1){
//									result = setInfo(name,url+urls);
//								} else if (!StringUtils.isEmpty(urls) && urls.indexOf(url) != -1) {
//									result = setInfo(name,urls);
//								}
//							} else if (!StringUtils.isEmpty(taga.attr("href")) && taga.attr("href").indexOf(url) != -1) {
//								String urls = getUrl(staticURL,url,taga.attr("href"));
//								if(!StringUtils.isEmpty(urls) && urls.indexOf(url) == -1){
//									result = setInfo(name,url+urls);
//								} else if (!StringUtils.isEmpty(urls) && urls.indexOf(url) != -1) {
//									result = setInfo(name,urls);
//								}
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
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");

		try {
			document = connect.get();
			Elements trs = document.getElementsByTag("table").select("tr");
			BanksavingsInfo record = new BanksavingsInfo();
			record.setBankname(name);
			record.setCreatetime(sysDate);
			record.setUpdatetime(sysDate);
			record.setIsdelete(false);
			for(Element tr: trs){
				//存储类型的定位
				String spanTR = tr.select("span").text().toString();
				String divTR = tr.select("div").text().toString();
				String pTR = tr.select("p").text().toString();
				String TR = tr.text().toString();
				//存储利率的定位
				String RateSpanTR = tr.select("span").text().toString().split(" ")[tr.select("span").text().toString().split(" ").length-1].toString();
				String RateDivTR = tr.select("div").text().toString().split(" ")[tr.select("div").text().toString().split(" ").length-1].toString();
				String RatePTR = tr.select("p").text().toString().split(" ")[tr.select("p").text().toString().split(" ").length-1].toString();
				String RateTR = tr.text().toString().split(" ")[tr.text().toString().split(" ").length-1].toString();
				
				if (StringUtils.isEmpty(record.getDemanddeposit())) {
					if(TR.indexOf("活期") != -1 || TR.indexOf("活期存款") != -1){
						if(!StringUtils.isEmpty(pTR) && pattern.matcher(RatePTR).matches()){
							System.out.println(RatePTR);
							record.setDemanddeposit(Float.parseFloat(RatePTR));
						} else if(!StringUtils.isEmpty(spanTR) && pattern.matcher(RateSpanTR).matches()){
							System.out.println(RateSpanTR);
							record.setDemanddeposit(Float.parseFloat(RateSpanTR));
						} else if(!StringUtils.isEmpty(divTR) && pattern.matcher(RateDivTR).matches()){
							System.out.println(RateDivTR);
							record.setDemanddeposit(Float.parseFloat(RateDivTR));
						} else if (!StringUtils.isEmpty(TR) && pattern.matcher(RateTR).matches()) {
							System.out.println(RateTR);
							record.setDemanddeposit(Float.parseFloat(RateTR));
						}
					}
				}
				if (record.getThreemonths() == null) {
					if(TR.indexOf("三个月") != -1){
						if(!StringUtils.isEmpty(pTR) && pattern.matcher(RatePTR).matches()){
							System.out.println(RatePTR);
							record.setThreemonths(Float.parseFloat(RatePTR));
						} else if (!StringUtils.isEmpty(spanTR) && pattern.matcher(RateSpanTR).matches()) {
							System.out.println(RateSpanTR);
							record.setThreemonths(Float.parseFloat(RateSpanTR));
						} else if(!StringUtils.isEmpty(divTR) && pattern.matcher(RateDivTR).matches()){
							System.out.println(RateDivTR);
							record.setThreemonths(Float.parseFloat(RateDivTR));
						} else if (!StringUtils.isEmpty(TR) && pattern.matcher(RateTR).matches()) {
							System.out.println(RateTR);
							record.setThreemonths(Float.parseFloat(RateTR));
						}
					}
				}
				if (record.getOneyear() == null) {
					if(TR.indexOf("一年") != -1 || TR.indexOf("一　年") != -1){
						if(!StringUtils.isEmpty(pTR) && pattern.matcher(RatePTR).matches()){
							System.out.println(RatePTR);
							record.setOneyear(Float.parseFloat(RatePTR));
						} else if (!StringUtils.isEmpty(spanTR) && pattern.matcher(RateSpanTR).matches()) {
							System.out.println(RateSpanTR);
							record.setOneyear(Float.parseFloat(RateSpanTR));
						} else if(!StringUtils.isEmpty(divTR) && pattern.matcher(RateDivTR).matches()){
							System.out.println(RateDivTR);
							record.setOneyear(Float.parseFloat(RateDivTR));
						} else if (!StringUtils.isEmpty(TR) && pattern.matcher(RateTR).matches()) {
							System.out.println(RateTR);
							record.setOneyear(Float.parseFloat(RateTR));
						}
					}
				}
				if (record.getTwoyears() == null) {
					if(TR.indexOf("二年") != -1 || TR.indexOf("二　年") != -1){
						if(!StringUtils.isEmpty(pTR) && pattern.matcher(RatePTR).matches()){
							System.out.println(RatePTR);
							record.setTwoyears(Float.parseFloat(RatePTR));
						} else if (!StringUtils.isEmpty(spanTR) && pattern.matcher(RateSpanTR).matches()) {
							System.out.println(RateSpanTR);
							record.setTwoyears(Float.parseFloat(RateSpanTR));
						} else if(!StringUtils.isEmpty(divTR) && pattern.matcher(RateDivTR).matches()){
							System.out.println(RateDivTR);
							record.setTwoyears(Float.parseFloat(RateDivTR));
						} else if (!StringUtils.isEmpty(TR) && pattern.matcher(RateTR).matches()) {
							System.out.println(RateTR);
							record.setTwoyears(Float.parseFloat(RateTR));
						}
					}
				}
				if (record.getThreeyears() == null) {
					if(TR.indexOf("三年") != -1 || TR.indexOf("三　年") != -1){
						if(!StringUtils.isEmpty(pTR) && pattern.matcher(RatePTR).matches()){
							System.out.println(RatePTR);
							record.setThreeyears(Float.parseFloat(RatePTR));
						} else if (!StringUtils.isEmpty(spanTR) && pattern.matcher(RateSpanTR).matches()) {
							System.out.println(RateSpanTR);
							record.setThreeyears(Float.parseFloat(RateSpanTR));
						} else if(!StringUtils.isEmpty(divTR) && pattern.matcher(RateDivTR).matches()){
							System.out.println(RateDivTR);
							record.setThreeyears(Float.parseFloat(RateDivTR));
						} else if (!StringUtils.isEmpty(TR) && pattern.matcher(RateTR).matches()) {
							System.out.println(RateTR);
							record.setThreeyears(Float.parseFloat(RateTR));
						}
					}
				}
				if (record.getFiveyears() == null) {
					if(TR.indexOf("五年") != -1 || TR.indexOf("五　年") != -1){
						if(!StringUtils.isEmpty(pTR) && pattern.matcher(RatePTR).matches()){
							System.out.println(RatePTR);
							record.setFiveyears(Float.parseFloat(RatePTR));
						} else if (!StringUtils.isEmpty(spanTR) && pattern.matcher(RateSpanTR).matches()) {
							System.out.println(RateSpanTR);
							record.setFiveyears(Float.parseFloat(RateSpanTR));
						} else if(!StringUtils.isEmpty(divTR) && pattern.matcher(RateDivTR).matches()){
							System.out.println(RateDivTR);
							record.setFiveyears(Float.parseFloat(RateDivTR));
						} else if(!StringUtils.isEmpty(TR) && pattern.matcher(RateTR).matches()){
							System.out.println(RateTR);
							record.setFiveyears(Float.parseFloat(RateTR));
						}
					}
				}
			}
			if(record.getDemanddeposit() != null){
				result = banksavingsInfoMapper.insertSelective(record);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	//对url再解析得到存款利率的url
	private String getUrl(String staticURL,String bankURL,String url){
		String savingURL = "";
		Connection connect = Jsoup.connect(url);
		connect.timeout(4000);
		Document document = null;
		try {
			document = connect.get();
			Elements tagA = document.getElementsByTag("a");
			if(tagA.size() > 0){
				for (Element taga : tagA) {
					if(!staticURL.contains(taga.attr("href"))){
						if(taga.text().toString().indexOf("存") != -1 && taga.text().toString().indexOf("利率") != -1){
							savingURL = taga.attr("href");
						} else {
							if(!StringUtils.isEmpty(taga.attr("href")) && taga.attr("href").indexOf(url) == -1 && taga.attr("href").indexOf("/") != -1){
								staticURL += taga.attr("href") + " ";
								savingURL = getUrl(staticURL,bankURL,bankURL+taga.attr("href"));
							} else if (!StringUtils.isEmpty(taga.attr("href")) && taga.attr("href").indexOf(url) != -1 && taga.attr("href").indexOf("/") != -1) {
								staticURL += taga.attr("href") + " ";
								savingURL = getUrl(staticURL,bankURL,taga.attr("href"));
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savingURL;
	}
}
