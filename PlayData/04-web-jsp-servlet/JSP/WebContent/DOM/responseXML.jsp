<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> XML 데이터 처리 </h2>

<script type="text/javascript">
//<!--
	// XMLHTTPrequest? requestHttp 뭐시기라고 원래 이름은
	var request = null;
	if(window.ActiveXObject) {
		// 있으면 IE / 있으면 ActiveX 그냥 쓰면 됨
		request = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		// 없으면 IE가 아닌경우 / 없으면 그냥 만들어 주면 됨
		request = new XMLHttpRequest();
	}
	
	// 응답을 받을 수 있는 메서드가 정해져 있다. / 요청이 왔을 때 실행이 되는 메서드
	request.onreadystatechange = function () {
		var result = document.getElementById("result");
		var msg = "";
		if(request.readyState == 4) {	// 4가 아니면 문제가 있는 것
			if(request.status == 200) {	// 200은 정상종료
				// xml데이터를 받기 responseText 로 받으면 text, responseXML
				/* var xmldoc = request.responseText;
				msg += xmldoc; */
				var xmldoc = request.responseXML;
				var subjectlist = xmldoc.getElementsByTagName("subject");
				var codelist = xmldoc.getElementsByTagName("code");
				var titlelist = xmldoc.getElementsByTagName("title");
				var roomlist = xmldoc.getElementsByTagName("room");
				
				// 테이블 만들어 찍기
				var t = document.getElementById("t");
				
				for(var i=0; i<subjectlist.length; i++) {
					/* 	// 모니터링 하기 위해 체크해봤던 소스
						msg += "코드 : " +codelist.item(i).firstChild.nodeValue + "<br>"
							+ "과목 : " + titlelist.item(i).firstChild.nodeValue + "<br>"
							+ "강의실 : " + roomlist.item(i).firstChild.nodeValue + "<br><br>"; */
					var trtag = document.createElement("tr");
					var tdtag1 = document.createElement("td");
					var tdtag2 = document.createElement("td");
					var tdtag3 = document.createElement("td");
					
					tdtag1.innerHTML = codelist.item(i).firstChild.nodeValue;
					tdtag2.innerHTML = titlelist.item(i).firstChild.nodeValue;
					tdtag3.innerHTML = roomlist.item(i).firstChild.nodeValue;
					
					trtag.appendChild(tdtag1);
					trtag.appendChild(tdtag2);
					trtag.appendChild(tdtag3);
					
					t.appendChild(trtag);
				}
				
				msg += "<br>정상종료<br>";
			}
			
		} else {	
			// 0,1,2,3 은 통신 중이라는 소리
			msg += "통신중<br>";
		}
		result.innerHTML = msg;
	}
	
	
	// 요청을 보낼 때 / get 방식, table.xml을 받아서 request.onreadystatechange에서 받을거야
	// open(method, url, async)
	request.open("GET", "table.xml", true);
	request.send();

	// AJAX 로 JSP 에게 데이터를 넘겨서 실시간 처리를 할 수가 있어.
	// 지금
	//-->
</script>


<table border="1">
<!-- 미리 만들어놓고 테이블 만들어 쓰고 싶을 때 쓰는 것. -->
	<tbody id="t">
	</tbody>
</table>

<!-- 모니터용 -->
<div id="result">
</div>