import javax.servlet.annotation.WebServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Servlet implementation class Controller
 */

// WEB-INF/Controller이름-servlet.xml과 연동되어있게 있음.
//       프로젝트 구동 시 servlet.xml 파일을 찾게되므로 만들어줘야함
// ▼ 없는상태서 실행할 경우 
// FileNotFoundException:
// Could not open ServletContext resource [/WEB-INF/Controller-servlet.xml]
@WebServlet("*.inc")
public class Controller extends DispatcherServlet{
	private static final long serialVersionUID = 1L;
	
}
