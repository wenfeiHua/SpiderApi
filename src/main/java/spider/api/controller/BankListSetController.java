package spider.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spider.api.ErrorMessage;
import spider.api.model.UpdateModel;
import spider.api.service.BankMessageService;

@RestController
@RequestMapping(value = BankListSetController.VIEW_INITIAL)
public class BankListSetController {

	static final String VIEW_INITIAL = "/";

	@Autowired
	private BankMessageService bankMessageService; 

	@RequestMapping(value = "/SetBankList", method = RequestMethod.POST)
	public UpdateModel setBankList(){
		UpdateModel model = new UpdateModel();
		int result = -1;
		result = bankMessageService.setBankList();
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
