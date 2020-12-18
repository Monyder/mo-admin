package mon.sof.project.sys.sysInfoSet.entity;


/**
 * 信息集字符集枚举
 *
 * @Author zhangxiaomei
 * @Date 2020-12-16 15:10:38
 * @Param
 * @Return
 */
public enum CharacterEnum {
    UTF8("utf8", "utf8"),
    UTF8MB4("utf8mb4", "utf8mb4");
    private String code;
    private String name;

    CharacterEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findNameByCode(String code) {
        for (CharacterEnum characterEnum : CharacterEnum.values()) {
            if (characterEnum.getCode().equals(code)) {
                return characterEnum.getName();
            }
        }
        return "";

    }
}
