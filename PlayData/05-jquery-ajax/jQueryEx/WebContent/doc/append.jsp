<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="/jQueryEx/jquery-3.3.1.js"></script>
    
<h2> append / appendTo</h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function (){
			//// DOM
			// 뒤에 붙일 span : appendChild()
			var dom = document.getElementById("dom");	// id="dom" 받아오기
			var spanA = document.createElement("span");	// span node 만들기
				//var spantext = document.createTextNode("DOM append : div 뒤에 붙었다");
				//spanA.appendChild( spantext );	// span text node를 span에 붙이고
			spanA.innerHTML = "DOM appendChild : div 뒤에 붙었다"
			dom.appendChild( spanA );		// 그걸 문서에 붙이기
			
			// 앞에 붙일 span : insertBefore()
			var spanB = document.createElement("span");
			spanB.innerHTML = "DOM insertBefore : div 앞에 붙었다"
			dom.parentNode.insertBefore(spanB, dom);
			
			
			////jquery
			// append
			$('#append').append('<span>jQuery append : div 앞에 붙었다</span>');	// 태그를 주면 태그도 먹음
			$('#append').prepend('<span>jQuery prepend : div 앞에 붙었다</span>');
			$('#append').after('<span>jQuery after : div 뒤에 붙었다</span>');
			$('#append').before('<span>jQuery before1 : div 뒤에 붙었다</span>');
			$('#append').before('<span>jQuery before2 : div 뒤에 붙었다</span>');
		
			// appendTo
			$('<span> appendTo </span>').appendTo('#appendto');
			$('<span> prependTo </span>').prependTo('#appendto');
			$('<span> insertBefore </span>').insertBefore('#appendto');
			$('<span> insertAfter </span>').insertAfter('#appendto');
	
			// 응용?
			// $(selector).append(content, content, ...)
			$('#img').append(
				'<br>','<br>',
				$('<img>').attr(
						{
							src : '/jQueryEx/images/images1.jpg',
							width : '150px',
							height : '200px',
							border : 0
						}
				)
			);
			// prependTo
//			$('<img src=>'/jQueryEx/images/images1.jps=g').prependTo('#img')
			$('<img>').attr(
					{
						src : "/jQueryEx/images/images1.jpg",
						width : '200px',
						height : '100px'
					}	
			).prependTo('#img');
			
			// $(selector).append( function(index){})
			var emp = [
				{name:'홍길동', age:30},
				{name:'이순신', age:31},
				{name:'김유신', age:32},
			];
			$('h5').append(
				function(index){	// 작업을 해야하는 앤지($(this).기능), 
									// 리턴해서 위에 있는 .() 따위에게 데이터를 던져줘야 하는건지(return)를 잘 생각해야 한다
					return "이름 : " + emp[index].name + "<br>"
							+ "나이 : " + emp[index].age;
				}
			);
		
		}	
	);
	//-->
</script>

<h5></h5>
<h5></h5>
<h5></h5>
<br><br>

<div id='img'>
<hr size="3" align="left" color="yellow">
</div>
<br><br>


<div id="dom">
<hr size="3" align="left" color="red">
</div>
<br><br>


<div id="append">
<hr size="3" align="left" color="yellow">
</div>
<br><br>


<div id="appendto">
<hr size="3" align="left" color="gray">
</div>
<br><br>