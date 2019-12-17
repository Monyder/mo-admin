package mon.sof.common.orm;

import mon.sof.common.orm.search.Condition;
import mon.sof.common.orm.search.Sort;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseAction<T> {


    /**
     * 添加实体
     *
     * @param t
     */
    void addEntity(T t);

    /**
     * 批量添加实体
     * @param list
     */
    void batchAddEntity(List<T> list);

    /**
     * 更新实体
     *
     * @param t
     */
    void updateEntity(T t);

    /**
     * 删除实体
     *
     * @param id
     */
    void deleteEntity(Serializable id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void bulkDelete(Serializable[] ids);

    /**
     * 根据Id获取实体
     *
     * @param id
     * @return
     */
    T findById(Serializable id);

    /**
     * 断言指定ID的实体存在，如果不存在将抛出 NotFoundException
     *
     * @param id
     * @return
     */
    T assertEntityExistById(Serializable id);

    /**
     * 查询所有数据
     *
     * @return
     */
    List<T> findAll();



    /**
     * @Title: findByCondition
     * @Description: 根据条件查询信息
     * @param conditions
     * @return
     */
    <O> List<O> findByCondition(@Param("conditions")List<Condition> conditions);

    /**
     * @Title: findByCondition
     * @Description: 根据条件查询信息
     * @param conditions
     * @return
     */
    <O> List<O> findByCondition(@Param("conditions")List<Condition> conditions,@Param("orders")List<Sort> orders);

    /**
     * @Description: 根据条件查询信息
     * @param params
     * @return
     */
    <O> List<O> findByCondition(Map<String, Object> params) ;


}
