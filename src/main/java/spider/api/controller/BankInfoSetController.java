package spider.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spider.api.ErrorMessage;
import spider.api.model.UpdateModel;
import spider.api.service.BankInfoSetService;

@RestController
@RequestMapping(value = BankInfoSetController.VIEW_INITIAL)
public class BankInfoSetController {

	static final String VIEW_INITIAL = "/";

	@Autowired
	private BankInfoSetService bankInfoSetService;


	@RequestMapping(value = "/SetBankListsss", method = RequestMethod.POST)
	public String hello(){
		return "hello";
	}

	@RequestMapping(value = "/SetBankInfo", method = RequestMethod.POST)
	public UpdateModel setBankInfo(){
		UpdateModel model = new UpdateModel();
		int result = -1;
		result = bankInfoSetService.setBankInfo();
		if(result > 0){
			model.setResult(1);
		} else {
			model.setResult(0);
			model.setErrCode(ErrorMessage.ERROR_CODE002);
			model.setErrDetail(ErrorMessage.ERROE_DETAIL002);
		}

		return model;
	}
}
