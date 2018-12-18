<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 프로젝트 경로
	String project = "/JSP/member/";
	
	// 한글은 전부 세팅으로 빼줄거임
	String page_main = "메인 페이지";
	String page_input = "회 원 가 입";
	String page_confirm = "아이디 중복확인";
	String page_login = "로 그 인";
	String page_delete = "회 원 탈 퇴";
	String page_modify = "회원 정보 수정";
	
	// 메세지 모음
	String msg_main = "비회원이시면 회원가입을 해주세요";
	String msg_input = "회원정보를 입력해주세요";
	String msg_confirm_x = " 는 사용할 수 없는 아이디입니다";
	String msg_confirm_o = " 는 사용할 수 있는 아이디입니다";
	String msg_login = "로그인 정보를 입력하세요";
	String msg_main_login = " 님 안녕하세요";
	String msg_passwdform = "비밀번호를 한번 더 입력해 주세요";
	String msg_modify = "수정할 정보를 입력하세요";
	//// str, btn_str 값 모음

	String btn_login = "로그인";
	String btn_cancel = "취소";
	String btn_join = "가입";
	String btn_join_cancel = "가입취소";
	String btn_confirm = "중복확인";
	String btn_confirm_cancel = "확인취소";
	String btn_ok = "확인";
	String btn_modify = "정보수정";
	String btn_delete = "회원탈퇴";
	String btn_logout = "로그아웃";
	String btn_mod = "수정";
	String btn_mod_cancel = "수정취소";
	
	String btn_del = "탈퇴";
	String btn_del_cancel = "탈퇴취소";
	
	String str_id = "아이디";
	String str_passwd = "비밀번호";
	String str_name = "이름";
	String str_jumin = "주민등록번호";
	String str_tel = "전화번호";
	String str_email = "이메일";
	String str_manual = "직접입력";
	String str_reg_date = "가입일자";
%>