package com.dao;

import com.entity.HuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuanzheView;

/**
 * 患者 Dao 接口
 *
 * @author 
 */
public interface HuanzheDao extends BaseMapper<HuanzheEntity> {

   List<HuanzheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
