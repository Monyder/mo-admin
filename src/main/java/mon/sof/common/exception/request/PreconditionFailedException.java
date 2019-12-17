package mon.sof.common.exception.request;

/**
 * 前置条件不满足异常
 * @author zhangxiaomei
 * @created 2011-9-6 下午02:45:52
 * @since v1.1
 * @history
 * @see
 */
public class PreconditionFailedException extends RequestException {

	private static final long serialVersionUID = 3786662913851931345L;

	/**
	 * 
	 * @param message 错误信息
	 * @param errorCode CIC内部错误信息码
	 */
	public PreconditionFailedException(String message, String errorCode) {
		super(message, errorCode);
	}
	
	/**
	 * @param message
	 *            错误信息
	 * @param cause
	 *            异常
	 * @param errorCode
	 *            CIC内部错误信息码
	 */
	public PreconditionFailedException(String message, Throwable cause, String errorCode) {
		super(message, errorCode, cause);
	}

	@Override
	public int getStatus() {
		return 412;
	}

}
