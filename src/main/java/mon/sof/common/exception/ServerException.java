package mon.sof.common.exception;

/**
 * 服务器内部错误
 * @author zhangxiaomei
 * @created 2015年2月9日 下午8:44:06
 * @since v1.0
 * @history
 * @see
 */
public class ServerException extends BaseException{

	private static final long serialVersionUID = 5533956134560026828L;
	
	public ServerException(String msg,Throwable e) {
		super("服务器错误，"+msg,e);
	}

}
