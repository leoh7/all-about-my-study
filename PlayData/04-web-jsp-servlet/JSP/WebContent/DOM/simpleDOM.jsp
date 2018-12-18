<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2> Document Object Model </h2>


<script type="text/javascript">
	//<!-- 
	function start() {
		var result = document.getElementById("result");
		var msg = "";
		// 제일 위의 노드를 얻을 수 있다. / document 의 documentElement
		var htmlnode = document.documentElement;
		msg += "document 의 최상위 노드 : " + htmlnode.nodeName + "<br>";
		
		// HTML 의 첫번째 자식 : head
		var headnode = htmlnode.firstChild;
		msg += "HTML 의 첫번째 자식 : " + headnode.nodeName + "<br>";
		// HTML 의 마지막 자식 : body
		var bodynode = htmlnode.lastChild;
		msg += "HTML 의 마지막 자식 : " + bodynode.nodeName + "<br>";
		
		
/* 		var bodylist = bodynode.childNodes;
		for(var i=0; i<bodylist.length; i++) {
			if(bodylist.item(i).nodeType == 1) {
				// 태그 / element / element는 value를 못찍는다 = null
				msg += "Element : " + bodylist.item(i).nodeName + "<br>";
			} else if(bodylist.item(i).nodeType == 3) {
				// 텍스트 / text는 못 찍는다 = null
				msg += "Text : " + bodylist.item(i).nodeValue + "<br>";
			}
		} */
		
		// id a 의 nodeValue 값을 가져와 보자
		var anode = document.getElementById("a");
		msg += "anode : " + anode.firstChild.nodeValue + "<br>";
		
		// span 태그를 리스트로 얻어오기
		var spanlist = document.getElementsByTagName("span");
		for(var i=0; i<spanlist.length; i++) {
			msg +="span 리스트의" + i + "번째 인덱스 : " + spanlist.item(i).firstChild.nodeValue + "<br>";
		}

		// innerHTML 은 메서드로 실행을 하고 출력을 해야한다. 페이지가 넘어가서 되기 때문에 document를 안쓰고
		result.innerHTML = msg;
		
		
		//img 태그 붙이기
		msg += "<br><br>";
		//result 밑으로 붙일거다
		var imga = document.createElement("img");
		var imgb = document.createElement("img");
		
		result.appendChild(imga);
		imga.setAttribute("src","/JSP/images/sh01.jpg");
		imga.setAttribute("width", "200");
		result.appendChild(imgb);
		imgb.setAttribute("src","/JSP/images/sh02.jpg");
		imgb.setAttribute("width", "200");
				
		
	}
	
	

	//-->
</script>


<body onload="start()">
	<p>
		<span id="a">a</span>
	</p>
	<div>
		<p>
			<span id="b">b</span>
		</p>
	</div>
	<div>
		<span id="c">c</span>
		<p> p </p>
	</div>
	<br><br>
	<!-- 출력 자리 -->
	<div id="result">
	</div>
</body>
