package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	/**
	 * 전처리기
	 * 컨트롤러가 호출되기 전에 실행
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("============================= START =============================");
			log.debug("Request URI: "+request.getRequestURI());
		}
		return super.preHandle(request, response, handler);
	}
	
	/**
	 * 후처리기 
	 * 컨트롤러가 실행된 후 호출
	 * */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("============================= END =============================");
		}
	}
}
