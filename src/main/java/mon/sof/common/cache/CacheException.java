
package mon.sof.common.cache;


import mon.sof.common.exception.BaseException;

/**
 * 缓存异常
 * 
 * @author zhangxiaomei * @created 2012-7-16 下午1:53:13
 * @since v1.0
 * @history
 * @see
 */
public class CacheException extends BaseException {

	private static final long serialVersionUID = 8198692257719377285L;

	public CacheException() {
		super();
	}

	public CacheException(String message, Throwable cause) {
		super(message, cause);
	}

	public CacheException(String message) {
		super(message);
	}

	public CacheException(Throwable cause) {
		super(cause);
	}

}
