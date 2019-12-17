package mon.sof.common.exception.request;

/**
 * 冲突异常
 * @author zhangxiaomei
 * @created 2011-7-12 下午03:10:46
 * @since v1.1
 * @history
 * @see
 */
public class ConflictException extends RequestException {

	private static final long serialVersionUID = -6074083395787188322L;

	/**
	 * @param message
	 *            错误信息
	 * @param cause
	 *            异常
	 * @param errorCode
	 *            错误信息码
	 */
	public ConflictException(String message, Throwable cause, String errorCode) {
		super(message, errorCode, cause);
	}
	
	/**
	 * @param message
	 *            错误信息
	 * @param errorCode
	 *            错误信息码
	 */
	public ConflictException(String message, String errorCode) {
		super(message, errorCode);
	}

	@Override
	final public int getStatus() {
		return 409;
	}
}
