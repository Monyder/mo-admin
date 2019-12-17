package mon.sof.common.exception.request;

/**
 * 未授权的异常
 * @author zhangxiaomei
 * @created 2011-9-1 下午03:48:46
 * @since v1.1
 * @history
 * @see
 */
public class UnauthorizedException extends RequestException{

	private static final long serialVersionUID = -8562595700584100001L;

	@Override
	public int getStatus() {
		return 401;
	}

	public UnauthorizedException(String message, String errorCode) {
		super(message, errorCode);
	}

	public UnauthorizedException(String message, Throwable cause,
			String errorCode) {
		super(message, errorCode, cause);
	}
	
	public UnauthorizedException(String message) {
		super(message);
	}

}
