package handler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDataBean;
import board.Dao;

@Controller
public class ListHandler implements CommandHandler {

	@Resource
	private Dao dao;
	
	@RequestMapping("list")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		int pageSize = 5;
		int pageBlock = 3;	// [1][2][3]...[10]

		int count = 0;	// 전체 글 갯수 파악 모양새 잡기
		int start = 0;
		int end = 0;
		String pageNum = null; 	// 넘어오는게 String이니까
		int currentPage = 0;	// 정수로 바꿔줄 꺼야
		int number = 0;			// 글번호(출력용 값일 뿐 PK와는 상관없는 번호)
		// rowNum 정렬이 다 된 다음 붙이는 번호
		int startPage = 0;		// [startPage][][] (pageBlock=3)...[endPage]
		int endPage = 0;
		int pageCount = 0;		// 페이지 갯수 페이지 3개밖에 없는데 10개 찍어라 이러면 안되니깐
		
		count = dao.getCount();			// 실질적인 전체 글 갯수 파악

		pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")){
			pageNum = "1";
		} 
		currentPage = Integer.parseInt(pageNum);	// pageNum을 연산가능하게 해서 start 랑 end 를 계산할 것임
		pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0);
		if(currentPage > pageCount) currentPage = pageCount;
		
		start = (currentPage -1)*pageSize +1;	// (5 -1 )*10 + 1 = 41 현재 보겠다는 페이지(5) 에서 1을 빼고 10개씩 보는 것에다 1을 더해
		end = start + pageSize -1;				// 41 에서 10을 덜한다음 1을 빼 41 + 10 -1= 50
		// 이렇게 10개씩 가져오라고 했는데 만약에 한 페이지에 10개가 안되면 에러가 난다 
		if(end > count){		// end 페이지가 글의 수count 보다 커
			end = count;	// 3 페이지면 30이지, 글이 25개 있으면 25개 까지가 end 가 되어야 하는 것.
		}
		
		number = count - (currentPage - 1)*pageSize;	// 전체글 - 현재 내가 보겠다는 수 / ex) 50 - (5-1)*10 = 5페이지는 10부터 1까지 / 1페이지는 50번 부터

		
		startPage = (currentPage / pageBlock)*pageBlock + 1;	// 5페이지 보겠다. (5/10)*10+1	11
		if(currentPage % pageBlock == 0){	// 현재 페이지가 페이지 블럭의 배수일 경우 계산이 오류가 난다
			startPage -= pageBlock;
		}
		endPage = startPage + pageBlock - 1;					// 11 + 10 - 1 = 20
		// endPage 보정
		if(endPage > pageCount){ // 내가 실제로 갖고 있는 페이지보다 endPage가 커
			endPage = pageCount; // 그럼 있는 페이지 까지만
		}
		
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("number", number);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		if( count > 0 ) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("start", start);
			map.put("end", end);
			List<BoardDataBean> articles = dao.getArticles( map );
			request.setAttribute("articles", articles);

		}
		
		return new ModelAndView("board/list");
	}

}
