package spider.api.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.mybatis.model.BankInfo;
import spider.api.service.BankMessageService;
import spider.api.util.GetBankUrlUtil;
@Service
public class BankMessageServiceImpl implements BankMessageService{

	@Autowired
	BankInfoMapper bankInfoMapper;

	private static final Logger logger = LogManager.getLogger(BankMessageServiceImpl.class);

	private final String SERVER = "E://spider//wwwroot//pdffile";

	private static final String URL_ADDRESS = "http://www.cbrc.gov.cn/govView_F87A960A1077432192707EEA1CBC64AD.html";

//	private static final String URL_QICHACHA = "https://www.qichacha.com/search?key=";
	private static final String URL_QICHACHA = "https://www.qichacha.com/search";

	@Override
	public int setBankList() {
		int result = setBanks();
//		File file = new File(SERVER);
//		if(file.isFile()){
//			file.delete();
//		} else {
//			String[] childFilePath = file.list();
//			for(String path : childFilePath){
//				File childFile = new File(file.getAbsoluteFile() + "/" + path);
//				childFile.delete();
//			}
//			if(downloadPDF() > 0){
//				System.out.println("hhhhhhh");
//				setBankInfo();
//			}
//		}
		return result;
	}
	
//	private static final String returnCookies() {
//		String Cookie = "";
//		try {
//			Connection conn = Jsoup.connect(URL_ADDRESS);
//			conn.followRedirects(false);
//			Response response = conn.execute();
//			Map<String, String> getCookies = response.cookies();
//			Cookie = getCookies.toString();
//			Cookie = Cookie.substring(Cookie.indexOf("{") + 1, Cookie.lastIndexOf("}"));
//			Cookie = Cookie.replaceAll(",", ";");
//			return Cookie;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return Cookie;
//	}
	
	private int downloadPDF(){
		int result = -1;
		Date SysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String pdfName = sdf.format(SysDate) + ".pdf";
		try {
			Connection connect = Jsoup.connect(URL_ADDRESS);
			connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
			connect.header("Accept-Encoding", "gzip, deflate");
			connect.header("Accept-Language", "zh-CN,zh;q=0.9,ja;q=0.8,en-US;q=0.7,en;q=0.6");
			connect.header("Cache-Control", "max-age=0");
			connect.header("Connection", "keep-alive");
			//--------------------------------------------cookie TODO------------------------------------------
			connect.header("Cookie", "__jsluid=788dfba37b2fbbb8be557e4ed40467c3; __jsl_clearance=1561362901.476|0|05bYW%2BUW1C4UP283IKJeaLl2Aik%3D; td_cookie=18446744070226683091");
			connect.header("Host", "www.cbrc.gov.cn");
			connect.header("Referer", "http://www.cbrc.gov.cn/govView_F87A960A1077432192707EEA1CBC64AD.html");
			connect.header("Upgrade-Insecure-Requests", "1");
			connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
			Document document = connect.get();
			Elements pdfs = document.getElementsByTag("a");
			for (Element element : pdfs) {
				String pdfHref = element.attr("abs:href");
				if(pdfHref.indexOf("pdf") != -1){
					File file = new File(SERVER + File.separator + pdfName);
					try {
						URL url = new URL(pdfHref);
						URLConnection connection = url.openConnection();
						connection.setConnectTimeout(10 * 1000);
						connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
						InputStream in = connection.getInputStream();
						BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
						byte[] buf = new byte[1024];
						int size;
						while (-1 != (size = in.read(buf))) {
							out.write(buf, 0, size);
						}
						out.close();
						in.close();
						result = 1;
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			 }
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	private int setBanks(){
		int result = -1;
		try{
			File file = new File(SERVER);
			if(file.isDirectory()){
				String[] childFilePath = file.list();
				if(childFilePath.length == 0){
					setBankList();
				} else{
					for(String path : childFilePath){
						File childFile = new File(file.getAbsoluteFile() + "/" + path);
						
						PDDocument document = PDDocument.load(childFile);
						document.getClass();
						if(!document.isEncrypted()) {
							PDFTextStripperByArea stripper = new PDFTextStripperByArea();
							stripper.setSortByPosition(true);
							PDFTextStripper tStripper = new PDFTextStripper();
							String pdfFileInText = tStripper.getText(document);
							if(document != null){
								document.close();
							}
							String[] lines = pdfFileInText.split("\\r?\\n");
							int count = 0;
							for(int i=0; i<lines.length - 1; i++) {
								String[] bankInfos = lines[i].split(" ");
								String bankName = "";
								if(bankInfos.length > 4){
									bankName = bankInfos[1].toString();
									if(isSelectBank(bankInfos[bankInfos.length - 1])){
										System.out.println(bankName);
										if(!StringUtils.isEmpty(bankName)){
											result = setBankInfo(bankName);
										}
										count++;
										System.out.println(count);
									}
								} else {
									if(isNumericzidai(bankInfos[0].toString())){
										if (i<(lines.length-1) && !isNumericzidai(lines[i+1].split(" ")[0].toString()) && isSelectBank(lines[i+1].split(" ")[lines[i+1].split(" ").length-1])) {
											bankName = bankInfos[1].toString();
											System.out.println(bankName);
											if(!StringUtils.isEmpty(bankName)){
												result = setBankInfo(bankName);
											}
											count++;
											System.out.println(count);
										} else if (i<(lines.length-2) && !isNumericzidai(lines[i+2].split(" ")[0].toString()) && isSelectBank(lines[i+2].split(" ")[lines[i+2].split(" ").length-1])) {
											bankName = bankInfos[1].toString();
											System.out.println(bankName);
											if(!StringUtils.isEmpty(bankName)){
												result = setBankInfo(bankName);
											}
											count++;
											System.out.println(count);
										} else if (i<(lines.length-3) && !isNumericzidai(lines[i+3].split(" ")[0].toString()) && isSelectBank(lines[i+3].split(" ")[lines[i+3].split(" ").length-1])) {
											bankName = bankInfos[1].toString();
											System.out.println(bankName);
											if(!StringUtils.isEmpty(bankName)){
												result = setBankInfo(bankName);
											}
											count++;
											System.out.println(count);
										} else if (i<(lines.length-4) && !isNumericzidai(lines[i+4].split(" ")[0].toString()) && isSelectBank(lines[i+4].split(" ")[lines[i+4].split(" ").length-1])) {
											bankName = bankInfos[1].toString();
											System.out.println(bankName);
											if(!StringUtils.isEmpty(bankName)){
												result = setBankInfo(bankName);
											}
											count++;
											System.out.println(count);
										} 
									}
								}
							}
							//------------------------TODO-------------------------
//							result = count;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return result;
	}

	private boolean isNumericzidai(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	private boolean isSelectBank(String str) {
		if(str.equals("国有大型商业银行") || str.equals("邮储银行") || str.equals("股份制商业银行") || str.equals("城市商业银行")){
			return true;
		}
		return false;
	}

	private int setBankInfo(String bankName) throws IOException{
//		getbankInfo(bankName);
		int result = -1;
		Date sysDate = new Date();
		String url = GetBankUrlUtil.getBankUrl(bankName);
		if(!StringUtils.isEmpty(url)){
			BankInfo record = new BankInfo();
			record.setBankname(bankName);
			record.setBankurl(url);
			record.setCreatetime(sysDate);
			record.setUpdatetime(sysDate);
			record.setIsdelete(false);
			try {
				result = bankInfoMapper.insertSelective(record);
			} catch (Exception e){
				logger.error(e.getMessage());
			}
		}
//		try {
//			if (!StringUtils.isEmpty(getHtmlByUrl(bankName))) {
//				Document doc = Jsoup.parse(getHtmlByUrl(bankName));
//				Elements hrefs = doc.getElementsByClass("ma_h1").select("href");
////				for () {
//					System.out.println(hrefs);
////				}
//			}
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
		return result;
	}

	private String getHtmlByUrl(String bankName) throws IOException{
		String html = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String URL = URL_QICHACHA + bankName;
		HttpGet httpget = new HttpGet(URL);
//		httpget.setHeader("Referer", "https://www.qichacha.com/search?key=%E5%8E%A6%E9%97%A8%E5%9B%BD%E9%99%85%E9%93%B6%E8%A1%8C%E8%82%A1%E4%BB%BD%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8");
		httpget.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
		try {
			HttpResponse response = httpClient.execute(httpget);
			int resStatu = response.getStatusLine().getStatusCode();
			if (resStatu == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					html = EntityUtils.toString(entity);
				}
			} 
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			httpClient.close();
		}
		return html;
	}

	private void getbankInfo(String bankName) throws IOException{
//		Connection conn = Jsoup.connect(URL_QICHACHA);
//		conn.data("key", bankName);
//		conn.method(Method.GET);
//		conn.followRedirects(false);
//		Response response;
//		response = conn.execute();
//		String Cookie = "";
//		if (StringUtils.isEmpty(response.cookies().toString())) {
//			Cookie = response.cookies().toString();
//		}

		Connection connect = Jsoup.connect(URL_QICHACHA);
		connect.data("key", bankName);
		connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
		connect.header("Accept-Encoding", "gzip, deflate, br");
		connect.header("Accept-Language", "zh-CN,zh;q=0.9,ja;q=0.8,en-US;q=0.7,en;q=0.6");
		connect.header("Cache-Control", "max-age=0");
		connect.header("Connection", "keep-alive");
//		//--------------------------------------------cookie TODO------------------------------------------
//		connect.header("Cookie", Cookie);
		connect.header("Host", "www.qichacha.com");
//		connect.header("Referer", "https://www.qichacha.com/search?key=%E5%90%89%E6%9E%97%E9%95%87%E8%B5%89%E5%86%9C%E6%9D%91%E5%95%86%E4%B8%9A%E9%93%B6%E8%A1%8C%E8%82%A1%E4%BB%BD%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8");
		connect.header("Upgrade-Insecure-Requests", "1");
		connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
		connect.method(Connection.Method.GET);
		connect.timeout(4000);
		
		try {
			Document document = connect.get();
			Elements hrefs = document.getElementsByTag("tablee").select("td").select("a").select("href");
			for (Element e : hrefs) {
				String href = e.toString();
				System.out.println(href);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
