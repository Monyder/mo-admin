package mon.sof.common.orm;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

public abstract class AbstractBaseAction<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseAction<T> {


    public abstract IBaseAction<T> getMapper();


    @Override
    public List<T> findByCondition(Map params) {
        return getMapper().findByCondition(params);
    }

    @Override
    public List<T> findByCondition(List list) {
        return getMapper().findByCondition(list);
    }

    @Override
    public List<T> findByCondition(List list,List orders) {
        return getMapper().findByCondition(list,orders);
    }
}
