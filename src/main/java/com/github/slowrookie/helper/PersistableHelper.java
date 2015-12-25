package com.github.slowrookie.helper;

import com.github.slowrookie.persistence.AuditablePersistable;
import com.github.slowrookie.base.persistence.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 持久化对象帮助类
 * Created by 刘佳兴 on 15-12-21.
 */
public class PersistableHelper {

    /**
     * 给默认的对象赋值
     * @param request request
     * @param entity  业务实体
     */
    public static void setDefaultFields(HttpServletRequest request, AuditablePersistable entity){

        User user = null == request.getSession().getAttribute("currentUser") ? new User(1L) :
                (User) request.getSession().getAttribute("currentUser");

        if (entity.isNew()) {
            entity.setCreatedBy(user.getCreatedBy());
            entity.setLastModifiedBy(user.getLastModifiedBy());
            entity.setCreatedDate(new Date());
            entity.setLastModifiedDate(new Date());
        } else {
            entity.setLastModifiedBy(user.getLastModifiedBy());
            entity.setLastModifiedDate(new Date());
        }

        if(null == entity.getActivity()) entity.setActivity(1);
    }


    /**
     * 批量设置
     * @param request 请求
     * @param entities 数组
     */
    public static void setDefaultFields(HttpServletRequest request, List<? extends AuditablePersistable> entities){
        for (AuditablePersistable entity: entities) {
            setDefaultFields(request, entity);
        }
    }

}
