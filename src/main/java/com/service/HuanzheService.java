package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuanzheEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 患者 服务类
 */
public interface HuanzheService extends IService<HuanzheEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}