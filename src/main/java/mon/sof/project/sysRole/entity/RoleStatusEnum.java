package mon.sof.project.sysRole.entity;

public enum RoleStatusEnum {
    valid(0, "有效"),
    invalid(1, "无效");

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    RoleStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String findNameByCode(Integer code) {
        for (RoleStatusEnum value : RoleStatusEnum.values()) {
            if (value.getCode() == code) return value.getName();
        }
        return "";

    }

    public static Integer findCodeByName(String name) {
        for (RoleStatusEnum value : RoleStatusEnum.values()) {
            if (value.getName().equals(name)) return value.getCode();
        }
        return 0;

    }
}
