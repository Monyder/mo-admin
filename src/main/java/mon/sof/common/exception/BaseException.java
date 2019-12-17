
package mon.sof.common.exception;

/**
 * 异常基类
 * 
 * @author liyan
 * @created 2012-7-16 下午1:50:25
 * @since v1.0
 * @history
 * @see
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -2786310264145061572L;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
}
