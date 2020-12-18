package mon.sof.project.sys.sysLog.advice;

import cn.hutool.json.JSONUtil;
import mon.sof.common.tool.token.SessionCache;
import mon.sof.common.tool.token.UserTokenTypeEnum;
import mon.sof.common.util.WebUtil;
import mon.sof.project.sys.sysLog.service.SysLogService;
import mon.sof.project.sys.sysUser.entity.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class SysLogAdvice {

    @Autowired
    private SysLogService logService;

    @AfterReturning(pointcut = "@annotation(Log)")
    public void createAspect(JoinPoint joinPoint) {
        createLog(joinPoint);
    }

    private void createLog(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        mon.sof.project.sys.sysLog.entity.SysLog log = new mon.sof.project.sys.sysLog.entity.SysLog();
        log.setIp(WebUtil.getIp(request));
        log.setFunc(annotation.func());
        log.setRemarks(annotation.remarks());
        log.setOperatingTime(new Date());
        String userJson = SessionCache.get(UserTokenTypeEnum.TOKEN.getName());
        SysUser user = JSONUtil.toBean(userJson, SysUser.class);
        log.setOperator(user.getUsername());
        logService.save(log);

    }
}
