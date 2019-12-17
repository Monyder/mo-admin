package mon.sof.common.orm;


import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseAction<T> implements IBaseAction<T> {


    public abstract IBaseAction<T> getDao();


    @Transactional
    @Override
    public void addEntity(T t) {
        getDao().addEntity(t);
    }

    @Transactional
    @Override
    public void batchAddEntity(List<T> list) {
        getDao().batchAddEntity(list);
    }

    @Transactional
    @Override
    public void updateEntity(T t) {
        getDao().updateEntity(t);
    }

    @Transactional
    @Override
    public void deleteEntity(Serializable id) {
        getDao().deleteEntity(id);
    }

    @Transactional
    @Override
    public void bulkDelete(Serializable[] ids) {
        getDao().bulkDelete(ids);
    }

    @Override
    public T findById(Serializable id) {
        return getDao().findById(id);
    }

    @Override
    public T assertEntityExistById(Serializable id) {
        return getDao().assertEntityExistById(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public List findByCondition(Map params) {
        return getDao().findByCondition(params);
    }

    @Override
    public List findByCondition(List list) {
        return getDao().findByCondition(list);
    }

    @Override
    public List findByCondition(List list,List orders) {
        return getDao().findByCondition(list,orders);
    }
}
