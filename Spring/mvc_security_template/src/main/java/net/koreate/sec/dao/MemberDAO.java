package net.koreate.sec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.koreate.sec.vo.AuthDTO;
import net.koreate.sec.vo.ValidationMemberVO;

public interface MemberDAO {

	/*
	u_id VARCHAR(50) NOT NULL UNIQUE,
    u_pw VARCHAR(200) NOT NULL,
    u_profile VARCHAR(200) NULL,
    u_phone VARCHAR(20) NOT NULL,
    u_name VARCHAR(20) NOT NULL,
    u_birth VARCHAR(20) NOT NULL,
	u_post VARCHAR(50), 
    u_addr VARCHAR(100),
    u_addr_detail VARCHAR(100),
	 */
	//회원가입
	@Insert("INSERT INTO validation_member("
	+"u_id,u_pw,u_profile,u_phone,u_name,u_birth,u_post,u_addr,u_addr_detail) "
	+"VALUES(#{u_id},#{u_pw},#{u_profile},#{u_phone},#{u_name},#{u_birth},#{u_post},#{u_addr},#{u_addr_detail})")
	void memberJoin(ValidationMemberVO vo) throws Exception;

	// id로 회원 정보 검색
	@Select("SELECT * FROM validation_member "
			+ " WHERE u_id = #{u_id} "
			+ " AND u_withdraw = 'n'")
	ValidationMemberVO getMemberByID(String u_id) throws Exception;

	// 회원가입한 회원 기본 권한 추가 ROLE_USER
	@Insert("INSERT INTO validation_member_auth "
		   +" VALUES(#{u_id},'ROLE_USER')")
	void insertAuth(String u_id) throws Exception;

	// 로그인 시 최종 방문 시간을 현재시간으로 수정
	@Update("UPDATE validation_member SET "
			+ " u_visit = now() "
			+ " WHERE u_id = #{u_id} ")
	void updateVistDate(String u_id)throws Exception;

	// 등록된 사용자 리스트
	@Select("SELECT * FROM validation_member ORDER BY u_no DESC")
	List<ValidationMemberVO> getMemberList()throws Exception;

	// 활성화 여부 수정
	@Update("UPDATE validation_member "
		  + " SET u_withdraw = #{u_withdraw} "
		  + " WHERE u_id = #{u_id}")
	void deleteYN(ValidationMemberVO vo) throws Exception;
	
	// u_id로 권한 정보 확인
	@Select("SELECT u_auth FROM validation_member_auth "
			+" WHERE u_id = #{u_id}")
	List<String> getAuthList(String u_id) throws Exception;

	// u_id 로 사용자 u_id u_auth 정보 검색
	@Select("SELECT * FROM validation_member_auth "
		  + " WHERE u_id = #{u_id}")
	List<AuthDTO> getAuthDTOList(String u_id) throws Exception;
	
	// 권한 부여
	@Insert("INSERT INTO validation_member_auth "
			+"VALUES(#{u_id}, #{u_auth})")
	void insertMemberAuth(AuthDTO vo) throws Exception;
	
	// 권한 회수
	@Delete("DELETE FROM validation_member_auth "
			+ " WHERE u_id = #{u_id}"
			+ " AND u_auth = #{u_auth}")
	void deleteAuth(AuthDTO auth) throws Exception;
	
	
}









