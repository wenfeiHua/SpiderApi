package spider.api.util;

import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

public class GetBankUrlUtil {

	private static String urll = "http://www.baidu.com/s?wd=";

	public static String getBankUrl(String bankName) {
		String result = "";
		String url = getResult(1, bankName+"官网");
		if (!StringUtils.isEmpty(url)) {
			result = url;
		}

		return result;
	}

	private static String getNews(String url, int num) {
		String attr = "";
//		String BANKURL = "";
		try {
			Document doc = Jsoup.connect(url).get();
			Element element = doc.getElementById("content_left");

			for (int i = 1; i < (num + 1); i++) {
				Element result = element.getElementById(String.valueOf(i));
				Elements add = result.select("a");
//				attr = add.text().toString().split(" ")[1].toString();
				String[] attrs = add.text().toString().split(" ");
				for(int k=0; k<attrs.length; k++){
					if(attrs[k].toString().indexOf("www") != -1){
						attr = attrs[k].toString();
					}
				}
//				System.out.println(add.first().text());
//				attr = add.first().attr("href");
				
				
//				if (attr.equals("")) {
//					for (int k = 0; k < add.size(); k++) {
//						if (k == 1) {
////							attr = add.text().toString().split(" ")[2].toString();
//							BANKURL = add.text().toString().split(" ")[2].toString();
//							System.out.println(BANKURL);
//						}
//					}
//				}
////				else if (getRightAttr(attr)) {
////					BANKURL = attr;
////				} 
//				else {
//					BANKURL = getRealUrlFromBaiduUrl(attr);
//				}
////				if(attr.toString().indexOf(".com.cn") != -1 || attr.toString().indexOf(".com") != -1 || attr.toString().indexOf(".cn") != -1){
////					BANKURL = attr;
////				} else {
//					
////				}
////				System.out.println(getRealUrlFromBaiduUrl(attr));
////				System.out.println();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return attr;
	}

	private static String getResult(int num, String question) {
		String url = "";
		try {
			url = urll + URLEncoder.encode(question, "utf-8") + "&rn=" + num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		if (!StringUtils.isEmpty(getNews(url, num))) {
		url = getNews(url, num);
//		}

		return url;
	}

//	private static String getRealUrlFromBaiduUrl(String url) {
//		Connection.Response res = null;
//		int itimeout = 60000;
//		String bankURL = "";
//		try {
//			res = Jsoup.connect(url).timeout(itimeout).method(Connection.Method.GET).followRedirects(false).execute();
//			if(StringUtils.isEmpty(res.header("Location").toString())){
//				bankURL = res.header("Location").toString();
//			}
//			return res.header("Location").toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bankURL;
//	}
}