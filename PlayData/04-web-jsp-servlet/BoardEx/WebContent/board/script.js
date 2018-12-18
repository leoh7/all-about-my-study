var writeerror = "작성자를 입력해주세요";
var subjecterror = "글 제목을 입력해주세요";
var contenterror = "글 내용을 입력해주세요";
var passwderror = "글 비밀번호를 입력해주세요";
var writeovererror = "작성자 명이 너무 깁니다 \n10글자 이하로 작성해주세요";
var inserterror = "글쓰기에 실패했습니다 \n잠시 후에 이용해주세요";
var passerror = "비밀번호가 다릅니다 \n다시 확인하세요";
var deleteerror = "글 삭제에 실패했습니다 \n잠시 후 다시 시도하세요";
var replyerror = "답글이 있는 글은 삭제할 수 없습니다";
var list_del_ok = "삭제되었습니다";
var modifyerror = "수정에 실패했습니다 \n잠시 후 다시 시도하세요";
var list_modify_ok = "수정되었습니다";

function erroralert(msg){
	alert(msg);
	history.back();
}

function modifyfocus(){
	modifyform.subject.focus();
}
function modifycheck(){
	// 제목 비밀번호 내용 not null
	if(!modifyform.subject.value){
		alert(subjecterror);
		modifyform.subject.focus();
		return false;
	} else if(!modifyform.content.value){
		alert(contenterror);
		modifyform.content.focus();
		return false;
	} else if(!modifyform.passwd.value){
		alert(passwderror);
		modifyform.passwd.focus();
		return false;
	}
}

function passwdfocus(){
	passwdform.passwd.focus();
}
function passwdcheck(){
	if(!passwdform.passwd.value){
		alert(passwderror);
		passwdform.passwd.focus();
		return false;
	}
}

function writefocus(){
	writeform.writer.focus();
}

function writecheck(){
	if(writeform.writer.value.length > 11){
		alert(writeovererror);
		writeform.writer.focus();
		return false;
	}
	
	if(!writeform.writer.value){
		alert(writeerror);
		writeform.writer.focus();
		return false;
	} else if(!writeform.subject.value){
		alert(subjecterror);
		writeform.subject.focus();
		return false;
	} else if(!writeform.content.value){
		alert(contenterror);
		writeform.content.focus();
		return false;
	} else if(!writeform.passwd.value){
		alert(passwderror);
		writeform.passwd.focus();
		return false;
	}
}