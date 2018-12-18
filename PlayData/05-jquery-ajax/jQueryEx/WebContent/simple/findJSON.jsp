<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> find() - JSON</h2>
실시간으로 처리하는 것과 같은 구조 <br><br>

<script type="text/javascript">
	//<!--
	var xml = "<books>"
			+ 	"<![CDATA["	// c 데이터 섹션을 줌. 이건 XML 데이터다 라는 선언이 됨 / ! 설정 /
			+		"{"		// JSON 선언
			+			"book : ["	// key : [Array] 구조
			+				"{"		// book : Array[0]
			+					"title : 'Java 프로그래밍',"
			+					"author : '홍길동',"
			+					"price : 30000,"
			+				"},"
			+				"{"		// book[1]
			+					"title : 'JSP 웹프로그래밍',"
			+					"author : '이순신',"
			+					"price : 25000,"
			+				"},"
			+				"{"		// book[2]
			+					"title : 'jQuery AJAX',"
			+					"author : '김유신',"
			+					"price : 50000,"
			+				"},"
			+			"]"
			+		"}"
			+	"]]>"
			+ "</books>";
	
	
	
	$(document).ready(
		function(){
			var xmldoc = $.parseXML( xml );
			var result = document.getElementById("result");
			var msg = "";
			
			
			// DOM
			var books = eval( "(" + xmldoc.getElementsByTagName("books").item(0).firstChild.nodeValue + ")" );
			for( var i=0; i<books.book.length; i++){
				msg += "제목 : " + books.book[i].title + "<br>"
					+ "저자 : " + books.book[i].author + "<br>"
					+ "가격 : " + books.book[i].price + "<br><br>";
			}
			
			// jQuery
			// key : [{0},{1},{2}]
			
			var bs = eval("(" + $(xmldoc).find('books').text() + ")");
			for( var i=0; i<bs.book.length; i++){
				msg += "제목 : " + bs.book[i].title + "<br>"
					+ "저자 : " + bs.book[i].author + "<br>"
					+ "가격 : " + bs.book[i].price + "<br><br>";
			}
			
			$.each( 
				bs.book, 
				function( index, item ){
					msg += "제목 : " + item.title + "<br>"
						+ "저자 : " + item.author + "<br>"
						+ "가격 : " + item.price + "<br><br>";
				}		
			);
			
			
			result.innerHTML = msg;
		}		
	);
	//-->
</script>

<div id="result"></div>













