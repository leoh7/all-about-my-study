<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>

<h2> find() - XML </h2>

<script type="text/javascript">
	//<!--
	// find()
	// 일단 문자열을 XML 인 것 처럼 해볼 거임
	var xml = "<books>"
			+ 	"<book>"
			+ 		"<title>Java 프로그래밍</title>"
			+ 		"<author>홍길동</author>"
			+ 		"<price>25000</price>"
			+ 	"</book>"
			+ 	"<book>"
			+ 		"<title>JSP 웹프로그래밍</title>"
			+ 		"<author>이순신</author>"
			+ 		"<price>40000</price>"
			+ 	"</book>"
			+ 	"<book>"
			+ 		"<title>jQuery AJAX</title>"
			+ 		"<author>김유신</author>"
			+ 		"<price>30000</price>"
			+ 	"</book>"
			+ "</books>";
	
	$(document).ready(
		function(){
			var xmldoc = $.parseXML( xml );	// XML 문서 객체로 변경
			var result = document.getElementById("result");
			var msg = "";
			
			// DOM
			var booklist = xmldoc.getElementsByTagName("book");
			var titlelist = xmldoc.getElementsByTagName("title");
			var authorlist = xmldoc.getElementsByTagName("author");
			var pricelist = xmldoc.getElementsByTagName("price");
			for( var i=0; i<booklist.length; i++){
				msg += "제목 : " + titlelist.item(i).firstChild.nodeValue + "<br>"
					+ "저자 : " + authorlist.item(i).firstChild.nodeValue + "<br>"
					+ "가격 : " + pricelist.item(i).firstChild.nodeValue + "<br><br>";
			}
			
			// jQuery
			$(xmldoc).find('book').each(
					function( index, item ){	// item 은 book 하나
						msg += "제목 : " + $(item).find('title').text() + "<br>"
							+ "저자 : " + $(item).find('author').text() + "<br>"
							+ "가격 : " + $(item).find('price').text() + "<br><br>";
					}
			);
			
		
			
			
			result.innerHTML = msg;
		}
	);
	//-->
</script>

<div id="result"></div>




















