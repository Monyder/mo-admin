/**
 * 
 */
package mon.sof.common.util;

/**
 * @Description:
 * @author: Liugang
 * @date: 2015-1-11 下午5:54:07
 * @version: 1.0
 *
 */
public enum YesOrNoEnum {
	NO("否"),YES("是");
	
	private String displayName;
	
	YesOrNoEnum(String displayName){
		this.displayName = displayName;
	}
	
	public String getDisplayName(){
		return this.displayName;
	}
}
