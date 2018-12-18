<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 프로젝트 경로
	String project = "/JSP/board/";

	// 페이지
	String page_list = "글 목록";
	String page_write = "글 작 성";
	String page_content = "글 보 기";
	String page_delete = "글 삭 제";
	String page_modify = "글 수 정";

	// str
	String str_count = "전체글";		// 전체글 갯수용
	String str_write = "글쓰기";
	
	String str_num = "번호";
	String str_subject = "제목";
	String str_writer = "작성자";
	String str_reg_date = "게시일";
	String str_readcount = "조회수";
	String str_ip = "IP";
	
	String str_list = "글목록";
	String str_email = "E-mail";
	String str_content = "글내용";
	String str_passwd = "비밀번호";
	
	String str_number = "글번호";
	
	// msg
	String msg_passwd = "비밀번호를 입력해주세요";
	String msg_modify = "수정할 정보를 입력하세요";
	
	// str_msg
	String str_msg_list_x = "게시판에 글이 없습니다";
	
	
	// button
	String btn_write = "글쓰기";
	String btn_cancel = "취소";
	String btn_list = "목록";
	String btn_modify = "글수정";
	String btn_delete = "글삭제";
	String btn_reply = "답글";
	String btn_del = "삭제";
	String btn_del_cancel = "삭제취소";
	String btn_mod = "수정";
	String btn_mod_cancel = "수정취소";
	
%>