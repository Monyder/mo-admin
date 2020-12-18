package mon.sof.project.sys.sysInfoItem.entity;

public enum NullableEnum {
    YES(0, "是"),
    NO(1, "否");
    private Integer code;
    private String name;

    NullableEnum(Integer code, String name) {
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
        for (NullableEnum value : NullableEnum.values()) {
            if (value.getCode() == code) {
                return value.getName();
            }
        }
        return "";
    }

    public static Integer findCodeByName(String isSysName) {
        for (NullableEnum value : NullableEnum.values()) {
            if (value.getName().equals(isSysName)) {
                return value.getCode();
            }
        }
        return null;
    }
}
