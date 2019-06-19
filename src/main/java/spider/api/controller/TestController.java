package spider.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = TestController.VIEW_INITIAL)
public class TestController {

	static final String VIEW_INITIAL = "/";

	@RequestMapping(VIEW_INITIAL)
	public String index(){
		return "Hello Word!!!!";
	}
}
