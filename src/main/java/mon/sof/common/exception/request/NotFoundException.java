package mon.sof.common.exception.request;

/**
 * @author zhangxiaomei
 * @created 2011-6-22 上午10:22:43
 * @since v1.1
 * @history
 * @see
 */
public class NotFoundException extends RequestException{

	private static final long serialVersionUID = -2884457073580791714L;
	
	@Override
	final public int getStatus() {
		return 404;
	}

	/**
	 * @param message
	 *            错误信息
	 * @param cause
	 *            异常
	 * @param errorCode
	 *            错误信息码
	 */
	public NotFoundException(String message, Throwable cause, String errorCode) {
		super(message, errorCode, cause);
	}
	
	/**
	 * @param message
	 *            错误信息
	 * @param errorCode
	 *            错误信息码
	 */
	public NotFoundException(String message, String errorCode) {
		super(message, errorCode);
	}
	
	/**
	 * @param message
	 *            错误信息
	 * @param errorCode
	 *            错误信息码
	 */
	public NotFoundException(String message) {
		super(message);
	}

}
