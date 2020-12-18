package mon.sof.project.sys.sysInfoItem.entity;


public enum IsDefaultEnum {
    YES(0, "是"),
    NO(1, "否");
    private Integer code;
    private String name;

    IsDefaultEnum(Integer code, String name) {
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
        for (IsDefaultEnum value : IsDefaultEnum.values()) {
            if (value.getCode() == code) {
                return value.getName();
            }
        }
        return "";
    }

    public static Integer findCodeByName(String isSysName) {
        for (IsDefaultEnum value : IsDefaultEnum.values()) {
            if (value.getName().equals(isSysName)) {
                return value.getCode();
            }
        }
        return null;
    }
}
