package net.koreate.sec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import net.koreate.sec.service.MemberService;
import net.koreate.sec.vo.AuthDTO;
import net.koreate.sec.vo.ValidationMemberVO;

@Controller
@RequestMapping("/mngt/*")
@RequiredArgsConstructor
public class ManagementMemberController {
	
	private final MemberService ms;
	
	@GetMapping("main")
	public void main(Model model)throws Exception{
		List<ValidationMemberVO> 
			memberList = ms.getMemberList();
		model.addAttribute("memberList",memberList);
	}

	@PostMapping("user/delete")
	@ResponseBody
	public String deleteYN(
			ValidationMemberVO vo
			)throws Exception{
		ms.deleteYN(vo);
		return vo.getU_withdraw();
	}
	
	
	@PostMapping("user/changeAuth")
	@ResponseBody
	public List<AuthDTO> changeAuth(
			AuthDTO dto
			) throws Exception{
		List<AuthDTO> list = ms.updateAuth(dto);
		System.out.println(list);
		return list;
	}
}








