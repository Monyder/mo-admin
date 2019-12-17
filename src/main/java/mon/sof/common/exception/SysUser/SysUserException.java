package mon.sof.common.exception.SysUser;

import mon.sof.common.exception.request.BadRequestException;

public class SysUserException extends BadRequestException {


    public SysUserException(SysUserExceptionType exceptionType){
        this(exceptionType.getErrorMsg(),exceptionType.getErrorCode());
    }

    public SysUserException(String message) {
        super(message);
    }

    public SysUserException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    public SysUserException(String message, String errorCode) {
        super(message, errorCode);
    }

    public SysUserException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
