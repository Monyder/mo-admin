package mon.sof.common.exception.request;


import mon.sof.common.exception.BaseException;

/**
 * 请求异常
 * 
 * @author zhangxiaomei
 * @created 2012-8-3 上午11:18:16
 * @since v2.0
 * @history
 * @see
 */
public abstract class RequestException extends BaseException {

	private static final long serialVersionUID = 846590208260610899L;

	/**
	 * 内部定义的错误信息码
	 */
	protected String errorCode;

	/**
	 * 
	 * @param message
	 *            错误信息
	 * @param cause
	 *            异常
	 * @param errorCode
	 *            错误信息码
	 */
	protected RequestException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param errorCode
	 *            错误信息码
	 * @param cause
	 *            异常
	 */
	protected RequestException(String errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	/**
	 * 
	 * @param message
	 *            错误信息
	 * @param errorCode
	 *            错误信息码
	 */
	protected RequestException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	protected RequestException(String message) {
		super(message);
	}

	/**
	 * 获取错误分类码
	 * 
	 * @return
	 * @author zhangxiaomei
	 * @created 2012-8-3 上午11:18:16
	 */
	public abstract int getStatus();

	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		String s = getClass().getName() + "[status:" + getStatus()
				+ " errorCode:" + errorCode + "]";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}

}
