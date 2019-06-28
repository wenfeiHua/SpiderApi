package spider.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//声明该类是一个springboot的引导类
@SpringBootApplication
public class SpiderApiApplication {

	public static void main(String[] args) {
		//run方法的参数是springboot引导类的字节码对象
		SpringApplication.run(SpiderApiApplication.class, args);
	}

}
