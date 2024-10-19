package com.dao;

import com.entity.HuajiarenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuajiarenyuanView;

/**
 * 划价人员 Dao 接口
 *
 * @author 
 */
public interface HuajiarenyuanDao extends BaseMapper<HuajiarenyuanEntity> {

   List<HuajiarenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
