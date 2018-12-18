/* 회원 관리 */
// 메인 페이지
	// 자바가 잘 안먹을 때는 f5 눌러도 안된다. 웹 브라우저가 잡고있는거라
	// 캐쉬를 지워줘야함
var iderror = "아이디를 입력하세요";
var passwderror = "비밀번호를 입력하세요";
var repasswderror = "입력하신 비밀번호와 일치하지 않습니다";
var nameerror = "이름을 입력하세요";
var juminerror = "주민번호를 입력하세요";
var telerror = "전화번호 형식에 맞지 않습니다";
var emailerror = "이메일 형식에 맞지 않습니다";
var emailerror1 = "직접 입력 시, '@' 가 문자열에 포함되어야 합니다";
var emailerror2 = "선택 입력 시, '@' 가 문자열에 포함되면 안됩니다";
var loginiderror = "입력하신 아이디가 없습니다 \n 아이디를 다시 확인하세요"
var loginpasswderror = "입력하신 비밀번호가 다릅니다 \n 비밀번호를 다시 확인하세요";
var inputerror = "회원가입에 실패했습니다 \n잠시 후 다시 시도하세요";
var deleteerror = "회원탈퇴에 실패했습니다 \n잠시 후 다시 시도하세요";
var delete_ok = "회원탈퇴에 성공했습니다";
var confirmidcheckerror = "아이디 중복확인을 해주세요";
var modifyerror = "회원정보수정에 실패했습니다 \n잠시 후 다시 시도하세요";
var modify_ok = "회원정보수정이 성공적으로 완료되었습니다";
function erroralert(msg) {
	alert(msg);
	history.back();
}

// 수정 페이지
function modifyfocus() {
	modifyform.passwd.focus();
}

function modifycheck() {
	if(!modifyform.passwd.value) {
		alert(passwderror);
		modifyform.passwd.focus();
		return false;
	} else if(modifyform.passwd.value != modifyform.repasswd.value) {
		alert(repasswderror);
		modifyform.passwd.focus();
		return false;
	} else if(modifyform.tel1.value || modifyform.tel2.value || modifyform.tel3.value) {
		// 전화번호 입력창에 하나라도 입력이 되어 있으면,
		if( modifyform.tel1.value.length<3 || 
			modifyform.tel2.value.length<3 || 
			modifyform.tel3.value.length<4) {
				alert(telerror);
					switch (true) {
					case modifyform.tel1.value.length<3 : modifyform.tel1.focus(); break;
					case modifyform.tel2.value.length<3 : modifyform.tel2.focus(); break;
					case modifyform.tel3.value.length<4 : modifyform.tel3.focus(); break;
					}
			return false;
		}
		
	}
	if(modifyform.email1.value || modifyform.email2.value) {
		if(	(modifyform.email1.value && !modifyform.email2.value) ||
			(!modifyform.email1.value && modifyform.email2.value) ||
			(modifyform.email1.value.indexOf("@") != -1 || modifyform.email2.value.indexOf("@") != -1) ) {
			alert( emailerror );
			modifyform.email1.focus();
			return false;
		}
	}
}


////////////////////////////////  가입 페이지  //////////////////////////////////
function inputfocus() {
	inputform.id.focus();
}
function inputcheck() {
	if(inputform.confirm.value == 0) {
		alert(confirmidcheckerror);
		inputform.confirm.focus();
		return false;
	}
	
	// submit 눌렀을 때
	if(!inputform.id.value) {
		// id 입력값 없을 때
		alert(iderror);
		inputform.id.focus();
		return false;
	} else if(!inputform.passwd.value) {
		// passwd 입력값 없을 때
		alert(passwderror);
		inputform.passwd.focus();
		return false;
	} else if(inputform.passwd.value != inputform.repasswd.value) {
		// passwd 입력값과 repasswd 입력값 다를 때
		alert(repasswderror);
		inputform.repasswd.focus();
		return false;
	} else if(!inputform.name.value) {
		// name 입력값 없을 때
		alert(nameerror);
		inputform.name.focus();
		return false;
	} else if(inputform.jumin1.value.length < 6 || inputform.jumin2.value.length < 7) {
		// jumin1 이 6 미만, jumin2 가 7 미만 일 때
		alert(juminerror);
		inputform.jumin1.focus();
		return false;
	
		
	} else if(inputform.tel1.value || inputform.tel2.value || inputform.tel3.value) {
		// 전화번호 입력창에 하나라도 입력이 되어 있으면,
		if( inputform.tel1.value.length<3 || 
			inputform.tel2.value.length<3 || 
			inputform.tel3.value.length<4) {
	//			alert(telerror);
				alert(inputform.email1.value.indexOf("@") + inputform.email2.value);
					switch (true) {
					case inputform.tel1.value.length<3 : inputform.tel1.focus(); break;
					case inputform.tel2.value.length<3 : inputform.tel2.focus(); break;
					case inputform.tel3.value.length<4 : inputform.tel3.focus(); break;
					}
			return false;
		}
	}
	if( inputform.email1.value ) {
		if( inputform.email2.value == "0") {
			if(inputform.email1.value.indexOf("@") == -1) {
				alert( emailerror1 );
				return false;
			}
		} else {
			if(inputform.email1.value.indexOf("@") != -1) {
				alert(emailerror2);
				return false;
			}
		}
	}
}



// 회원 탈퇴
function passwdfocus() {
	passwdform.passwd.focus();
}
function passwdcheck() {
	if(!passwdform.passwd.value) {
		alert(passwderror);
		passwdform.passwd.focus();
		return false;
	}
}

// 로그인
function loginfocus() {
	loginform.id.focus();
}

function logincheck() {
	if(!loginform.id.value) {
		alert(iderror);
		loginform.id.focus();
		return false;
	} else if(!loginform.passwd.value) {
		alert(passwderror);
		loginform.passwd.focus();
		return false;
	}
}


// 중복확인 페이지
function setid(id) {
	opener.document.inputform.id.value = id;
	opener.document.inputform.passwd.focus();
	opener.document.inputform.confirm.value = 1;
	self.close();
}
function setcancel() {
	opener.document.inputform.id.focus();
	opener.document.inputform.id.value = "";
	self.close();
}

function confirmfocus() {
	confirmform.id.focus();
}

function confirmcheck() {
	if(!confirmform.id.value) {
		alert(iderror);
		confirmform.id.focus();
		return false;
	}
}

function confirmid() {
	if(!inputform.id.value) {
		alert(iderror);
//		return false; 	// submit 처럼 넘어가라는 기능이 원래 달려있는게 아니어서 넣어줄 필요가 없다.
	} else {
		var url = "memberConfirmId.do?id=" + inputform.id.value;
		open(url,"confirm window" ,"toolbar=no, scrollbar=no, status=no, menubar=no, width=500px, height=300px");
	}
}

// 메인 페이지 
function mainfocus() {
	mainform.id.focus();
}
function maincheck() {
	if(!mainform.id.value) {
		alert(iderror);
		mainform.id.focus();
		// return false 란 이벤트를 막겠다는 뜻. 
		// 메서드에서 리턴이 자동적으로 생기는 이벤트를 막아준다.Jquery에서 볼거
		return false;
	} else if(!mainform.passwd.value) {
		alert(passwderror);
		mainform.passwd.focus();
		return false;
	}
}



/* 입력 칸 자동 옮겨가기 */
function nextjumin2() {
	if(inputform.jumin1.value.length == 6) {
		inputform.jumin2.focus();
	}
}
function nexttel1() {
	if(inputform.jumin2.value.length == 7) {
		inputform.tel1.focus();
	}
}
function nexttel2() {
	if(inputform.tel1.value.length == 3) {
		inputform.tel2.focus();
	}
}
function nexttel3() {
	if(inputform.tel2.value.length == 4) {
		inputform.tel3.focus();
	}
}
function nextemail1() {
	if(inputform.tel3.value.length == 4) {
		inputform.email1.focus();
	}
}
/* /입력 칸 자동 옮겨가기 */