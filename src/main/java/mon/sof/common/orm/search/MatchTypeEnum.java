package mon.sof.common.orm.search;

/**
 * sql查询，字段比较类型
 * 
 * @author Johnson
 * @created 2014-5-23 下午03:53:01
 * @since v1.1
 * @history
 * @see
 */
public enum MatchTypeEnum {
	EQ(" =  "), //
	NE(" <> "), //
	LIKE(" LIKE "), //
	LT(" < "), //
	GT(" > "), //
	LE(" <= "), //
	GE(" >= "), //
	IN(" IN "), //
	NOT_IN(" NOT IN "), //
	NULL(" IS NULL "), //
	NOT_NULL(" IS NOT NULL ");

	private String operator;

	private MatchTypeEnum(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

}
