package com.dao;

import com.entity.MenzhenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MenzhenView;

/**
 * 门诊 Dao 接口
 *
 * @author 
 */
public interface MenzhenDao extends BaseMapper<MenzhenEntity> {

   List<MenzhenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
