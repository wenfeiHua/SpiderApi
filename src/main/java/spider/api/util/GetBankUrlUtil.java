package spider.api.util;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetBankUrlUtil {

	private static String urll = "http://www.baidu.com/s?wd=";

	public static String getBankUrl(String bankName) {
		String result = "";
		String url = getResult(1, bankName);
		if (!StringUtils.isEmpty(url)) {
			result = url;
		}

		return result;
	}

	private static String getNews(String url, int num) {
		String attr = "";
		try {
			Document doc = Jsoup.connect(url).get();
			Element element = doc.getElementById("content_left");

			for (int i = 1; i < (num + 1); i++) {
				Element result = element.getElementById(String.valueOf(i));
				Elements add = result.select("a");
//				System.out.println(add.first().text());
				attr = add.first().attr("href");
//				System.out.println(getRealUrlFromBaiduUrl(attr));
//				System.out.println();
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
		if (!StringUtils.isEmpty(getNews(url, num))) {
			url = getNews(url, num);
		}

		return url;
	}
//
//	private static String getRealUrlFromBaiduUrl(String url) {
//		Connection.Response res = null;
//		int itimeout = 60000;
//		try {
//			res = Jsoup.connect(url).timeout(itimeout).method(Connection.Method.GET).followRedirects(false).execute();
//			return res.header("Location");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
}