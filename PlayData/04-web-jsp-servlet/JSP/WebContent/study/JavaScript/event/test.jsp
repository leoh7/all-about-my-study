<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	var text = new Array();
	var t0 = 10;
	var t1 = 20;
	var t2 = 30;
	var t3 = 40;
	
	for(var i=0; i<4; i++) {
		 text[i] = String(eval("t"+i));
	}
	
	for(var i=0; i<text.length; i++) {
		document.write(text[i] + "<br>");
		document.write("t"+i +"<br>");
		document.write(String("t"+i) +"<br>");
	}

</script>