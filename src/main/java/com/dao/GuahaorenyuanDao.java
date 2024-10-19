package com.dao;

import com.entity.GuahaorenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuahaorenyuanView;

/**
 * 挂号人员 Dao 接口
 *
 * @author 
 */
public interface GuahaorenyuanDao extends BaseMapper<GuahaorenyuanEntity> {

   List<GuahaorenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
