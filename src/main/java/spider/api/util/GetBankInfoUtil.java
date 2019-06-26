package spider.api.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import spider.api.model.BankSavingsModel;
import spider.api.model.ResultModel;

public class GetBankInfoUtil {

	public static ResultModel setBankSavings(String bankName,String bankUrl){
//		String URL_ADDRESS = "http://www.njcb.com.cn/njcb/index/khfw3/jrxx84/ckll/420655/500587/index.html";
//		String URL_ADDRESS = "http://www.bankofchina.com/fimarkets/lilv/fd31/201510/t20151023_5824963.html";
//		String URL_ADDRESS = "http://www.njcb.com.cn";
		
//		Connection connect = Jsoup.connect(URL_ADDRESS);
//		Document document = null;
//		try {
//			document = connect.get();
//			Elements trs = document.getElementsByTag("table").select("tr");
//			for(Element tr: trs){
//				if(tr.text().toString().indexOf("活期") != -1 || tr.text().toString().indexOf("活期存款") != -1){
//					System.out.println(tr.text().toString().split(" ")[1].toString());
//				}
//				if(tr.text().toString().indexOf("三个月") != -1){
//					System.out.println(tr.text().toString().split(" ")[1].toString());
//				}
//				if(tr.text().toString().indexOf("一年") != -1){
//					System.out.println(tr.text().toString().split(" ")[1].toString());
//				}
//				if(tr.text().toString().indexOf("二年") != -1){
//					System.out.println(tr.text().toString().split(" ")[1].toString());
//				}
//				if(tr.text().toString().indexOf("三年") != -1){
//					System.out.println(tr.text().toString().split(" ")[1].toString());
//				}
//				if(tr.text().toString().indexOf("五年") != -1){
//					System.out.println(tr.text().toString().split(" ")[1].toString());
//				}
//			}
//			System.out.println(trs);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ResultModel model = new ResultModel();
		model = getbankinfo(bankUrl);
		return model;
	}

	private static ResultModel getbankinfo(String url){
		ResultModel model = new ResultModel();
		Connection connect = Jsoup.connect(url);
		Document document = null;
		List<BankSavingsModel> savingsModel = new ArrayList<BankSavingsModel>();
		
		try {
			document = connect.get();
			Elements tagA = document.getElementsByTag("a");
			if(tagA.size() > 0){
				for (Element taga : tagA) {
					System.out.println(taga.text().toString());
					System.out.println(taga.attr("href"));
					if(savingsModel.size() == 0){
						if(taga.text().toString().indexOf("存") != -1 && taga.text().toString().indexOf("利率") != -1){
							if(taga.attr("href").indexOf(url) == -1){
								savingsModel = getInfo(url+taga.attr("href"));
								if(savingsModel.size() > 0){
									model.setResult(1);
									model.setBaseModelList(savingsModel);
								}
							} else {
								savingsModel = getInfo(taga.attr("href"));
								if(savingsModel.size() > 0){
									model.setResult(1);
									model.setBaseModelList(savingsModel);
								}
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

		return model;
	}

	//获取银行存款利率	
	private static List<BankSavingsModel> getInfo(String url){
		List<BankSavingsModel> models = new ArrayList<BankSavingsModel>();
		Connection connect = Jsoup.connect(url);
		Document document = null;
		try {
			document = connect.get();
			Elements trs = document.getElementsByTag("table").select("tr");
			BankSavingsModel model = new BankSavingsModel();
			for(Element tr: trs){
				if(tr.text().toString().indexOf("活期") != -1 || tr.text().toString().indexOf("活期存款") != -1 && StringUtils.isEmpty(model.getDemanddeposit())){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					model.setDemanddeposit(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("三个月") != -1 && model.getThreemonths() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					model.setThreemonths(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("一年") != -1 && model.getOneyear() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					model.setOneyear(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("二年") != -1 && model.getTwoyears() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					model.setTwoyears(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("三年") != -1 && model.getThreeyears() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					model.setThreeyears(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
				if(tr.text().toString().indexOf("五年") != -1 && model.getFiveyears() == null){
					System.out.println(tr.text().toString().split(" ")[1].toString());
					model.setFiveyears(Float.parseFloat(tr.text().toString().split(" ")[1].toString()));
				}
			}
			System.out.println(trs);
			System.out.println(model);
			models.add(model);
			System.out.println(models);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return models;
	}

	//对url再解析得到存款利率的url
	private static String getUrl(String url){
		String savingURL = "";
		Connection connect = Jsoup.connect(url);
		Document document = null;
		try {
			document = connect.get();
			Elements tagA = document.getElementsByTag("a");
			if(tagA.size() > 0){
				for (Element taga : tagA) {
					if(taga.text().toString().indexOf("存") != -1 && taga.text().toString().indexOf("利率") != -1){
						savingURL = taga.attr("href");
					} else {
//						savingURL = taga.attr("href") + "_____falseURL";
						savingURL = getUrl(taga.attr("href"));
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
