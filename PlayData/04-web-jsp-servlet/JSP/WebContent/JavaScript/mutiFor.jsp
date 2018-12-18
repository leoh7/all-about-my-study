<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 구구단 </h2>

<script type="text/javascript">

	/* document.write("<table border=1>");
		document.write("<tr>");
		for(var i=2; i<10; i++) {
			document.write("<th>"+i+"단</th>");
		}
		document.write("</tr>");
		
		for(var i=1; i<10; i++) {
				document.write("<tr>");
			for(var j=2; j<10; j++) {
				document.write("<td>"+j+" * "+i+" = "+(i*j)+"</td>");
			}
			document.write("</tr>");
		}
	document.write("</table>"); */
	
	document.write("<table border='1'>");
	document.write("<tr>");
	for(var i=2; i<10; i++) {
		document.write("<th>");
		document.write(i + "단");
		document.write("</th>");
	}
	document.write("</tr>");
	
	for(var i=1; i<10; i++) {
		document.write("<tr>");
		for(var j=2; j<10; j++) {
			document.write("<td>");
			document.write(j + " * " + i + " = " + i*j );
			document.write("</td>");
		}
		document.write("</tr>");
	}
	document.write("</table>");
</script>