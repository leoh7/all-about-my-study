<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/jQueryEx/jquery-3.3.1.js"></script>


<h2> 문서 객체 탐색 </h2>

<script type="text/javascript">
	//<!--
		/* $(this).css('background', 'red').css('color', 'blue'); *//* 비효율적 */
		
	$(document).ready(
		function(){
			$('h4').each(
				function(){
					$(this).css(
							{
								color : 'red',
								background : 'gray'
							}
					);
				}
			);
			
			//// filter
			// $(selector).filter(selector)
			$('h5:first').css('color', 'red');
			$('h5:even').css('background', 'lightgray');
			
			$('h5').filter(':first').css('color', 'blue');
			$('h5').filter(':eq(1)').css('color', 'blue');
			$('h5').filter(':odd').filter(':even').css('color', 'red');
			
			// $(selector).filter(function(index) {} )
			$('h4').filter( // 이 안에 골라낸 값(return)을 줘야 한다
					function( index, item ) {	// 골라내는 역할을 하는 function
						// return index % 2 == 0;
						// return this;
						return item;
					} 
			).css('color', 'green');
			
			// eq() first() last()	// 이렇게 연결하면 되서 filter 잘 안 쓴다
			$('h4').eq(1).css('color', 'pink');
			$('h4').first().css('color', 'pink');
			$('h4').last().css('color', 'pink');
			
			// end() add()
				// end() 이전으로 한 단계 돌아가라
			//$('h4').filter(':even').filter(':odd').css('color', 'yellow')
			//.end().filter(':odd').filter(':even').css('background', 'red');
			
				// add() 맨 처음으로 돌아가라
			$('h4').filter(':even').filter(':odd').css('color', 'yellow')
			.add('h4').filter(':odd').filter(':even').css('background', 'red');
		
			// is
			$('h4').each(
					function( index ){
						if( $(this).is('.point') ){
							//$(this).css('background', 'black');
							$('h4').css('background', 'black');
						}
					}
			);
		}
	);
	//-->
</script>

<h4 class="point"> 독서 </h4>
<h4> 등산 </h4>
<h4> 운동 </h4>
<h4> 낚시 </h4>
<br>
<h5> 바나나 </h5>
<h5> 사과 </h5>
<h5> 딸기 </h5>
<h5> 복숭아 </h5>











