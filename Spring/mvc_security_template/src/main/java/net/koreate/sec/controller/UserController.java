package net.koreate.sec.controller;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import net.koreate.file.utils.FileUtils;
import net.koreate.sec.service.MemberService;
import net.koreate.sec.vo.ValidationMemberVO;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final MemberService ms;
	private final String uploadPath;
	private final ServletContext servletContext;
	
	// 완성된 실제 저장 폴더 경로
	private String realPath;
	
	@PostConstruct
	public void initPath() {
		realPath = servletContext.getRealPath(
			File.separator+uploadPath
		);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
			System.out.println("경로 생성 완료");
		}
		System.out.println("user controller 초기화 완료");
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/user/join")
	public void join() {
	}

	@GetMapping("/user/logout")
	public void logout() {}
	
	@PostMapping("/user/uidCheck")
	@ResponseBody
	public boolean uidCheck(String u_id) throws Exception{
		boolean isCheck = ms.getMemberByID(u_id);
		System.out.println(isCheck);
		return isCheck;
	}
	
	@PostMapping("/user/joinPost")
	public String joinPost(
				ValidationMemberVO vo,
				MultipartFile profileImage
						  )throws Exception{
		System.out.println(vo);
		System.out.println(profileImage);
		if(profileImage != null && 
		   !profileImage.isEmpty()) {
			String u_profile
				= FileUtils.uploadFile(
						realPath, 
						profileImage
				  );
			System.out.println(u_profile);
			vo.setU_profile(u_profile);
		}
		ms.memberJoin(vo);
		return "redirect:/user/login";
	}
	
	@GetMapping("/logOff")
	public String logOff() {
		return "/user/logOff";
	}
}


























