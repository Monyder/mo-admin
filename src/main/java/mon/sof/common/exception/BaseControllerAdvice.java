package mon.sof.common.exception;


import cn.hutool.http.HttpStatus;
import cn.hutool.log.LogFactory;
import mon.sof.common.orm.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常统一处理基类
 *
 * @Author zhangxiaomei
 * @Date 2020-02-25 15:58:36
 * @Param
 * @Return
 */
@RestControllerAdvice
public class BaseControllerAdvice {

    /**
     * 运行时异常
     *
     * @Author zhangxiaomei
     * @Date 2020-02-25 15:59:09
     * @Param
     * @Return
     */
    @ExceptionHandler(value = BaseException.class)
    public Resp baseExceptionHander(BaseException be) {
        LogFactory.get().error("BaseExceptionHander", be);
        return Resp.err(0, be.getMessage());
    }


    /**
     * 全局异常
     *
     * @Author zhangxiaomei
     * @Date 2020-02-25 17:01:26
     * @Param
     * @Return
     */

    @ExceptionHandler(value = Exception.class)
    public Resp exceptionHander(Exception e) {
        LogFactory.get().error("ExceptionHander", e);
        return Resp.err(HttpStatus.HTTP_INTERNAL_ERROR, "程序异常，请联系管理人员");
    }

}
