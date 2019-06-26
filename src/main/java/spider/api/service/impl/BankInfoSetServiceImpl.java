package spider.api.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import spider.api.model.BankUrlModel;
import spider.api.mybatis.mapper.BankInfoMapper;
import spider.api.service.BankInfoSetService;
@Service
public class BankInfoSetServiceImpl implements BankInfoSetService{

	@Autowired
	BankInfoMapper bankInfoMapper;

	@Override
	public int setBankInfo() {
		int result = -1;
		List<BankUrlModel> list = new ArrayList<BankUrlModel>();
		list = bankInfoMapper.selectBankNameAndUrl();
		if(list.size() > 0){
			for (BankUrlModel model : list) {
				if(!StringUtils.isEmpty(model.getBankname()) && !StringUtils.isEmpty(model.getBankurl())){
					String bankName = model.getBankname();
					String bankUrl = model.getBankurl();
					result = setBankInfo(bankName,bankUrl);
				}
			}
		}
		return result;
	}

	private int setBankInfo(String Name,String Url){
		int result = -1;
		Connection connect = Jsoup.connect("http://" + Url);
		connect.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
		connect.header("Accept-Encoding", "gzip, deflate");
		connect.header("Accept-Language", "zh-CN,zh;q=0.9,ja;q=0.8,en-US;q=0.7,en;q=0.6");
		connect.header("Cache-Control", "max-age=0");
		connect.header("Connection", "keep-alive");
		connect.header("Host", Url);
		connect.header("Upgrade-Insecure-Requests", "1");
		connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
		try {
			Document document = connect.get();
			Elements urls = document.getElementsByTag("a");
			urls.text().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
