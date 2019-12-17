package mon.sof.common.web.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ResultObj {
	private String result = "success";

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private Long total;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private Map<String, Object> dataList;

	private Object data;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Map<String, Object> getDataList() {
		return dataList;
	}

	public void setDataList(Map<String, Object> dataList) {
		this.dataList = dataList;
	}

	public void setItem(List<?> item) {
		if (dataList == null) {
			dataList = new HashMap<String, Object>();
		}
		dataList.put("item", item);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getItems() {
		if (dataList == null) {
			return null;
		}
		return (List<T>)dataList.get("item");
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
