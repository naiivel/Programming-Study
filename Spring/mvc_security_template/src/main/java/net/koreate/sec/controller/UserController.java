package net.koreate.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import net.koreate.sec.service.MemberService;
import net.koreate.sec.vo.ValidationMemberVO;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final MemberService ms;
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/user/join")
	public void join() {
	}

	@GetMapping("/user/logout")
	public void logout() {
	}
	
	
	@PostMapping("/user/uidCheck")
	@ResponseBody
	public boolean uidCheck(String u_id) throws Exception{
		boolean isCheck = ms.getMemberByID(u_id);
		System.out.println(isCheck);
		return isCheck;
	}
	
	@PostMapping("/user/joinPost")
	public String joinPost(
				ValidationMemberVO vo
						  )throws Exception{
		ms.memberJoin(vo);
		return "redirect:/user/login";
	}
}


























