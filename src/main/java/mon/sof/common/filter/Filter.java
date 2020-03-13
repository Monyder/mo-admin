package mon.sof.common.filter;


import mon.sof.common.exception.BaseException;
import mon.sof.common.tool.token.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(Filter.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws BaseException {
        String url = request.getRequestURI().replace(
            request.getContextPath()+"/",""
        );
        log.debug("**********url**************" + url);
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LoginRequired methodAnnotation = handlerMethod.getMethodAnnotation(LoginRequired.class);
            if(methodAnnotation != null){
                return true;
            }
        }
        /*String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }*/
        /*if(StringUtil.isEmpty(token)){
            if(url.startsWith("main")){
                throw new BaseException("token为空，请重新登录！");
            }
        }*/


        return true;
    }
    

}
