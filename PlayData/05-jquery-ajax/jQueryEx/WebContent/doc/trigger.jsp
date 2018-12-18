<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> trigger - 이벤트 발생 </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function(){
			// $(selector).trigger( eventname )	
			// 이벤트를 강제로 발생
			$('h5').bind(
				'click',
				function( event ){
					$(this).text( $(this).text() + '♪' );
				}
			);
			
			var cnt = 0;
			setInterval(
				function() {
					$('h5:eq('+ parseInt( Math.random() * 4 ) +')').trigger('click');
					cnt++;
			}, 200);
			
			// 트리거를 쓰면서 데이터 넘기기 : 배열을 사용
			// $(selector).trigger( eventname, data1, data2, ... )
			$('h4').bind(
				'click',
				function(event, data1, data2){
					$(this).text( $(this).text() + data1 + data2 );
				}
			);
			
			setInterval(
				function() {
					$('h4').trigger('click', [ parseInt( Math.random() * 4 ), parseInt( Math.random() * 4 )]);
			}, 1000)
			
			
			//preventDefault / stopPropagation
			$('a').bind(
				'click',
				function( event ){
					$(this).css( 'color', 'red' );
					// event.preventDefault();	// 현재 하이퍼링크가 기본기능인데, 그 기능을 막음
					// event.stopPropagation();	// 버블링을 막는다 / 이벤트가 타고 올라가는 것을 막음
					// 이걸 두개 합쳐놓은 것이
					return false;
				}
			);
			$('h3').bind(
				'click',
				function( event ){
					$(this).css( 'background', 'gray' );
					
				}
			);
		}		
	);
	//-->
</script>
<div>
<h3><a href="http://www.daum.net">다음</a></h3>
<h3><a href="http://www.naver.com">네이버</a></h3>

<h4>김치찌개</h4>
<h4>된장찌개</h4>
<h4>순두부찌개</h4>
<h4>부대찌개</h4>

<h5>짜장면</h5>
<h5>짬뽕</h5>
<h5>볶음밥</h5>
<h5>탕수육</h5>
</div>