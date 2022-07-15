package net.koreate.di.controller.home;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import net.koreate.di.dao.TestDAO;
import net.koreate.di.service.TestService;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final TestService ts;
	private final TestDAO td;
	
//	@Autowired //@Autowired 생략해도 됨
//	public MainController(TestService ts, TestDAO td) {
//		this.ts = ts;
//		this.td = td;
//		System.out.println("Main 생성완료!");
//	}
	
	@PostConstruct
	public void init() {
		System.out.println("main postConstruct");
		ts.testService("Main ");
		td.select("Main :");
	}
	
}