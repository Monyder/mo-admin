package mon.sof.project.common.sysMenu.entity;

public enum NodeTypeEnum {
    MENU(0,"菜单"),
    BUTTON(1,"按钮");

    private Integer code;
    private String name;

    NodeTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findNameByCode(Integer code){
        for (NodeTypeEnum value : NodeTypeEnum.values()) {
            if (value.getCode() == code) return value.getName();
        }
        return "";
    }

}
