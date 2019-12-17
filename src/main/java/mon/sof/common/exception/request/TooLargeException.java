package mon.sof.common.exception.request;

/**
 * @author zhangxiaomei
 * @created 2011-9-1 下午03:44:34
 * @since v1.1
 * @history
 * @see
 */
public class TooLargeException extends RequestException {

	private static final long serialVersionUID = -6625888180572131146L;

	@Override
	public int getStatus() {
		return 413;
	}

	public TooLargeException(String message, String errorCode) {
		super(message, errorCode);
	}

	public TooLargeException(String message, Throwable cause, String errorCode) {
		super(message, errorCode, cause);
	}

}
