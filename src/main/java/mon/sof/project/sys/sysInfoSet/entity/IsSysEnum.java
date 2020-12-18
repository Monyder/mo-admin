package mon.sof.project.sys.sysInfoSet.entity;

/**
 * 是否是系统表枚举
 *
 * @Author zhangxiaomei
 * @Date 2020-12-16 15:47:48
 * @Param
 * @Return
 */
public enum IsSysEnum {
    YES(0, "是"),
    NO(1, "否");
    private Integer code;
    private String name;

    IsSysEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findNameByCode(Integer code) {
        for (IsSysEnum value : IsSysEnum.values()) {
            if (value.getCode() == code) {
                return value.getName();
            }
        }
        return "";
    }

    public static Integer findCodeByName(String isSysName) {
        for (IsSysEnum value : IsSysEnum.values()) {
            if (value.getName().equals(isSysName)) {
                return value.getCode();
            }
        }
        return null;
    }
}
