<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	/* var y = new Array();
	for(var i=0; i<2; i++) {
		y[i] = (parseInt(Math.random()*9)+1);
		 for(var j=0; j<i; j++ ) {
			if(y[i] == y[j]) {
			i--;
			break;
			}
		} 
	} */
	
	var numA = function() {
		var i =
		parseInt(Math.random()*9)+1;
		return i;
	}
	var numB = function() {
		var i =
		parseInt(Math.random()*9)+1;
		return i;
	}
	
	function que() {
		document.write(numA() + " * " + numB());
	}
	document.write(numA() + " * " + numB());
	
	function submit() {
		
	}
	

</script>

<form name="form">
	<table border="1">
		<tr>
			<td>
				<input type="hidden" name="que()">
			</td>
			<td>
				<input type="text" name="submitValue">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" value="제출" onclick="submit()">
				<input type="reset" value="취소">
			</th>
		</tr>
	</table>
맞은 개수 : <input type="text" name="resultCorrect" readonly><br>
점수 : <input type="text" name="result" readonly><br>
</form>
