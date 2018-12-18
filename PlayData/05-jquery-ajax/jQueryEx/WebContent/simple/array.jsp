<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>


<h2> 배열 - $.each() </h2>


<script type="text/javascript">
//<!--
	$(document).ready(
		function(){
			var result = document.getElementById("result");
			var msg = "";
			var m = ["사과", "딸기", "바나나", "수박"];
			
			// JavaScript
			for(var i=0; i<m.length; i++){
				msg += m[i] + "&nbsp;";
			}
			msg += "<br>";
			
			// forIn
			for(var i in m){
				// i가 값이 아니라 인덱스라 크게 의미가 없다
				msg += m[i] + "&nbsp;";
			}
			msg += "<br>";
			
			// Array 객체
			var w = new Array(10,20,30,40,50);
			for(var i=0; i<w.length; i++){
				msg += w[i] + "&nbsp;";
			}
			msg += "<br>";
			
			// jQuery
			// $.each( object, function(index, item) {} )	// 이미 만들어진 배열을 가지고 돌리는 반복문
			$.each(
				m, 
				function(index, item){
					msg += index + " : " + item + "&nbsp;";
				}
			);
			msg += "<br>";
			
			$.each(
					m, 
					function(index, item){
						msg += index + " : " + m[index] + "&nbsp;";
					}
				);
			msg += "<br>";
			
				// item 자리에 this 를 썼다. this 를 사용할 땐 용법에 주의
			$.each(
					m, 
					function(index){
						msg += index + " : " + this + "&nbsp;";
					}
				);
			msg += "<br>";
			
			// $(selector).each( funtion( index, item ) {} )	// 내가 선택해서 돌리는 반복문
			$('h4').each(
				function(index, item){
					msg += index + " : " + item + "<br>";	// 여기서의 item 은 <h4> 자체가 된 것
				}	
			);
			msg += "<br>";
			
			$('h4').each(
					function(index, item){
						if(index % 2 == 0){
						//	$(item).css('background', 'lightgray');	// 이런걸 많이 쓰게 된다
							$(this).css('background', 'lightgray');
						} else {
						//	$(item).css('background', 'gray');
							$(this).css('background', 'gray');
						}
					}	
				);
			msg += "<br>";
			
			$('h4').each(
				function(index, item){
					msg += $(item).text() + "&nbsp;"	// val() 은 form 에서 입력받은 값만 갖고 오기 때문에 여기엔 부적합
				}	
			);
			msg += "<br>";
				// 활용
			var color = ['red', 'blue', 'green', 'yellow'];
			$('h4').each(
				function(index){
					$(this).css('color', color[index]);
				}	
			);
				// 최종적으로 이런식으로 쓰게된다
				// .each 는 반복문을 돌리는 연습과 감을 익히기 위함
			$('h4').text(
				function(index, item){
					msg += item + "&nbsp;";	// item 은 text
				}	
			);
			
			result.innerHTML = msg;
		}
	);
//-->
</script>

<h4>축구</h4>
<h4>야구</h4>
<h4>농구</h4>
<h4>배구</h4>
<br><br>
<div id="result"></div>