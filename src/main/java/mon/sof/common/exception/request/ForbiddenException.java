package mon.sof.common.exception.request;

/**
 * 服务器拒绝请求，一般为未登录或登录的会话过期了
 * @author zhangxiaomei
 * @created 2015年2月9日 下午8:19:20
 * @since v1.0
 * @history
 * @see
 */
public class ForbiddenException extends RequestException{

	private static final long serialVersionUID = -2713689400642354590L;

	public ForbiddenException(String message) {
		super(message);
	}

	@Override
	public int getStatus() {
		return 403;
	}

}
