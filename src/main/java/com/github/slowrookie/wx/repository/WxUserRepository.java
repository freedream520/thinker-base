package com.github.slowrookie.wx.repository;

import com.github.slowrookie.base.persistence.entity.Menu;
import com.github.slowrookie.repository.DefaultRepository;
import com.github.slowrookie.wx.persistence.entity.WxUser;
import org.springframework.stereotype.Repository;

/**
 * 微信
 *
 * @author 刘佳兴
 */
@Repository
public interface WxUserRepository extends DefaultRepository<WxUser> {

}
