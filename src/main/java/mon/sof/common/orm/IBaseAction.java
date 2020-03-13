package mon.sof.common.orm;

import mon.sof.common.orm.search.Condition;
import mon.sof.common.orm.search.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IBaseAction<T> {


    /**
     * @Title: findByCondition
     * @Description: 根据条件查询信息
     * @param conditions
     * @return
     */
    List<T> findByCondition(@Param("conditions")List<Condition> conditions);

    /**
     * @Title: findByCondition
     * @Description: 根据条件查询信息
     * @param conditions
     * @return
     */
    List<T> findByCondition(@Param("conditions")List<Condition> conditions,@Param("orders")List<Sort> orders);

    /**
     * @Description: 根据条件查询信息
     * @param params
     * @return
     */
    List<T> findByCondition(Map<String, Object> params);


}
