<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
//<!--
	// 답 저장 배열(전역변수)
	var answer = new Array;
	var inAnswer = 0;
	var cnt = 0;
	var corrAnswer = 0;
	// 문제 출제
	function queStart() {
	//createElement?
		cnt++;
		// 문제 출제 창
		// 답 입력 창
		// 제출 버튼
			// onclick 시 judge function
		// 종료 버튼
			// onclick 시 집계 function
			// 총 몇 문제 중, 몇 문제 맞춤
			// 푼 시간 있으면 재밌겠다 + 1문제당 걸린 평균
	}
	 function judge(){
		 if(answer[cnt] == inAnswer){
			 // 맞았으면
			 cnt++;
			 corrAnswer++;
			 queStart();
			 
		 } else {
			 // 틀렸으면
			 
		 }
	 }
	
	
//-->
</script>

<body onload="queStart()">

</body>