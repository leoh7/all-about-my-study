<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
//<!--
	var request = null;
	if(window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		request = new XMLHttpRequest();
	}
	
	request.onreadystatechange = function () {
		var result = document.getElementById("result");
		var msg = "";

		if(request.readyState == 4) {	//4: request finished and response is ready
			msg += "통신 준비 완료<br>";
			if(request.status == 200) {
				msg += "status : 200 , OK <br>";
				var xmlDoc = request.responseXML;
				var studentList = xmlDoc.getElementsByTagName("student");
				var nameList = xmlDoc.getElementsByTagName("name");
				var korList = xmlDoc.getElementsByTagName("kor");
				var engList = xmlDoc.getElementsByTagName("eng");
				var matList = xmlDoc.getElementsByTagName("mat");
				
				var t = document.getElementById("t");
				
				
				for(var i=0; i<studentList.length; i++) {
					/* msg +=  "title : " +nameList.item(i).nodeName + "<br>" +
							"이름  : " +nameList.item(i).firstChild.nodeValue + "<br>" +
							"국어 : " +korList.item(i).firstChild.nodeValue + "<br>" +
							"영어 : " +engList.item(i).firstChild.nodeValue + "<br>" +
							"수학 : " +matList.item(i).firstChild.nodeValue + "<br><br>"; */
					var trtag = document.createElement("tr");
					var nameTag = document.createElement("td");
					var korTag = document.createElement("td");
					var engTag = document.createElement("td");
					var matTag = document.createElement("td");
					
					var sumTag = document.createElement("td");
					var avgTag = document.createElement("td");
					
					nameTag.innerHTML = nameList.item(i).firstChild.nodeValue;
					korTag.innerHTML = korList.item(i).firstChild.nodeValue;
					engTag.innerHTML = engList.item(i).firstChild.nodeValue;
					matTag.innerHTML = matList.item(i).firstChild.nodeValue;
					
					sumTag.innerHTML = eval(korList.item(i).firstChild.nodeValue) +
							eval(engList.item(i).firstChild.nodeValue) +
							eval(matList.item(i).firstChild.nodeValue);
					avgTag.innerHTML = parseInt(( eval(korList.item(i).firstChild.nodeValue) +
							eval(engList.item(i).firstChild.nodeValue) +
							eval(matList.item(i).firstChild.nodeValue) ) /3);
					
					trtag.appendChild(nameTag);
					trtag.appendChild(korTag);
					trtag.appendChild(engTag);
					trtag.appendChild(matTag);
					trtag.appendChild(sumTag);
					trtag.appendChild(avgTag);
					
					t.appendChild(trtag);
				}
			
			
			
				msg += "정상종료<br>";
			}
		} else {
			// request.readyState == 0: request not initialized 
			// 1: server connection established
			// 2: request received 
			// 3: processing request 
			msg += "통신 연결중<br>";
		}
		result.innerHTML = msg;
	}
	
	
	// open(method, url, async)
	request.open("GET", "score.xml", true);
	request.send();
	
//-->
</script>


<table border="1">
	<tbody id="t">
	</tbody>
</table>


<div id="result">

</div>