package spider.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spider.api.ErrorMessage;
import spider.api.model.ResultModel;
import spider.api.mybatis.model.BankInfo;
import spider.api.service.BankInfoService;

@RestController
@RequestMapping(value = BankInfoController.VIEW_INITIAL)
public class BankInfoController {

	static final String VIEW_INITIAL = "/";

	@Autowired
	private BankInfoService bankInfoService; 

	@RequestMapping(VIEW_INITIAL)
	public String index(){
		return "Hello Word!!!!";
	}

	@RequestMapping(value = "/GetBankList", method = RequestMethod.GET)
	public ResultModel getBankList(){
		ResultModel model = new ResultModel();
		List<BankInfo> list = new ArrayList<BankInfo>();
		list = bankInfoService.getBankList();
		if(list.size() > 0){
			model.setResult(1);
			model.setBaseModelList(list);
		} else {
			model.setResult(0);
			model.setErrCode(ErrorMessage.ERROR_CODE001);
			model.setErrDetail(ErrorMessage.ERROE_DETAIL001);
		}
		return model;
	}
}
