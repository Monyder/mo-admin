
package mon.sof.common.exception.request;

public class BadRequestException extends RequestException {

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}

	public BadRequestException(String message, String errorCode) {
		super(message, errorCode);
	}

	public BadRequestException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	@Override
	public int getStatus() {

		return 200;
	}

}
