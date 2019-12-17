package mon.sof.common.exception.SysUser;

public class SysUserExceptionType {

    private String errorCode ;
    private String errorMsg ;

    public static SysUserExceptionType USER_REGIST_NULL = new SysUserExceptionType("10000", "参数为空，注册失败...");
    public static SysUserExceptionType USER_REGIST_SAMENAME = new SysUserExceptionType("10001", "账户已经存在");
    public static SysUserExceptionType USER_REGIST_SAMEMAIL = new SysUserExceptionType("10002", "邮件已经注册");
    public static SysUserExceptionType USER_LOGIN_NONAME = new SysUserExceptionType("10010", "用户名不存在");
    public static SysUserExceptionType USER_LOGIN_NOPASSWORD = new SysUserExceptionType("10011", "密码错误");
    public static SysUserExceptionType USER_LOGIN_NULL = new SysUserExceptionType("10012", "参数为空，登录失败...");
    public static SysUserExceptionType ACCOUNT_LOCKED = new SysUserExceptionType("10013", "用户已被锁定,请联系管理员修改密码.");

    public static SysUserExceptionType USER_LOGOUT_NOID = new SysUserExceptionType("10020", "用户id不存在");
    public static SysUserExceptionType USER_LOGOUT_NULL = new SysUserExceptionType("10021", "用户id不可以为空");
    public static SysUserExceptionType USER_CHANGEPWD_NONAME = new SysUserExceptionType("10030", "用户名不存在");
    public static SysUserExceptionType USER_CHANGEPWD_DIFPASSWORD = new SysUserExceptionType("10031", "旧密码输入错误");
    public static SysUserExceptionType USER_CHANGEPWD_SAMEPASSWORD = new SysUserExceptionType("10032", "旧密码和新密码重复");
    public static SysUserExceptionType USER_PWD_NOT_SAME = new SysUserExceptionType("10033", "新密码和确认密码不一致");

    public static SysUserExceptionType USER_CHANGEPWD_NULL = new SysUserExceptionType("10032", "请输入密码");
    public static SysUserExceptionType USER_GETBYID_NULL = new SysUserExceptionType("10050", "请输入用户id");
    public static SysUserExceptionType USER_GETBYID_EMPTY = new SysUserExceptionType("10051", "用户信息获取失败");
    public static SysUserExceptionType USER_EDIT_SAMENAME = new SysUserExceptionType("10061", "用户名已经存在");
    public static SysUserExceptionType USER_EDIT_SAMEMAIL = new SysUserExceptionType("10062", "邮件已经注册");
    public static SysUserExceptionType USER_EDIT_NULL = new SysUserExceptionType("10063", "参数为空，修改失败...");
    public static SysUserExceptionType USER_DELBYID_NULL = new SysUserExceptionType("10070", "请输入用户id");

    public static SysUserExceptionType USER_UPLOAD_NULL = new SysUserExceptionType("10080", "上传失败：文件为空");
    public static SysUserExceptionType USER_UPLOAD_TOOBIG = new SysUserExceptionType("10080", "上传失败：文件过大");
    public static SysUserExceptionType USER_RESETPASS_NULL = new SysUserExceptionType("10090", "密码为空，重置密码失败...");
    public static SysUserExceptionType USER_RESETPASS_NOAUTH = new SysUserExceptionType("10091", "没有权限修改密码");


    public static SysUserExceptionType USER_TOKEN_TIME = new SysUserExceptionType("10191", "token已失效，请重新登录！！！");
    public static SysUserExceptionType USER_TOKEN_NULL = new SysUserExceptionType("10192", "token为空，登录失败！！！");

    public static SysUserExceptionType USER_TOKEN_EXCEPTION = new SysUserExceptionType("10193", "Token异常！,请重新登录！");


    private SysUserExceptionType(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
