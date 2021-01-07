package mon.sof.project.sys.sysMenu.entity;

public enum FuncTypeEnum {
    SYS(0, "系统功能"),
    DEV(1, "开发功能");

    private Integer code;
    private String name;

    FuncTypeEnum(Integer code, String name) {
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
        for (NodeTypeEnum value : NodeTypeEnum.values()) {
            if (value.getCode() == code) return value.getName();
        }
        return "";
    }

}
