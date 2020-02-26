package mon.sof.common.exception;


import cn.hutool.http.HttpStatus;
import mon.sof.common.exception.entity.Resp;
import mon.sof.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常统一处理基类
 * @Author  zhangxiaomei
 * @Date    2020-02-25 15:58:36
 * @Param
 * @Return
 */
@RestControllerAdvice
public class BaseControllerAdvice {
    private static Logger Log = LoggerFactory.getLogger(BaseControllerAdvice.class);




    /**
     * 运行时异常
     * @Author  zhangxiaomei
     * @Date    2020-02-25 15:59:09
     * @Param
     * @Return
     */
    @ExceptionHandler(value = BaseException.class)
    public Resp baseExceptionHander(BaseException be){
        Log.error("BaseExceptionHander" , be);
        return Resp.error(HttpStatus.HTTP_INTERNAL_ERROR,be.getMessage(),null);
    }


    /**
     * 全局异常
     * @Author  zhangxiaomei
     * @Date    2020-02-25 17:01:26
     * @Param
     * @Return
     */

    @ExceptionHandler(value = Exception.class)
    public Resp exceptionHander(Exception e){
        Log.error("ExceptionHander",e);
        if(StringUtil.isEmpty(e.getMessage())){
            return Resp.error(HttpStatus.HTTP_INTERNAL_ERROR , "程序异常，请联系管理人员" , null);
        }
        return Resp.error(HttpStatus.HTTP_INTERNAL_ERROR , e.getMessage(), null);
    }

}
