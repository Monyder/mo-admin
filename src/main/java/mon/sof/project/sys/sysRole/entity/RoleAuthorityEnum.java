package mon.sof.project.sys.sysRole.entity;

public enum RoleAuthorityEnum {
    READANDWRITE(0, "读写"),
    READ(1, "只读");

    private int code;
    private String name;

    RoleAuthorityEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findNameByCode(Integer code) {
        for (RoleAuthorityEnum value : RoleAuthorityEnum.values()) {
            if (value.getCode() == code) return value.getName();
        }
        return "";
    }

    public static Integer findCodeByName(String name) {
        for (RoleAuthorityEnum value : RoleAuthorityEnum.values()) {
            if (value.getName().equals(name)) return value.getCode();
        }
        return 0;
    }
}
