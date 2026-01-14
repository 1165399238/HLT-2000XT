package com.cm.system.mapper;

import java.util.List;
import com.cm.system.domain.HltDetector;

/**
 * 监测仪Mapper接口
 * 
 * @author zw
 * @date 2026-01-14
 */
public interface HltDetectorMapper 
{
    /**
     * 查询监测仪
     * 
     * @param id 监测仪主键
     * @return 监测仪
     */
    public HltDetector selectHltDetectorById(Long id);

    /**
     * 查询监测仪列表
     * 
     * @param hltDetector 监测仪
     * @return 监测仪集合
     */
    public List<HltDetector> selectHltDetectorList(HltDetector hltDetector);

    /**
     * 新增监测仪
     * 
     * @param hltDetector 监测仪
     * @return 结果
     */
    public int insertHltDetector(HltDetector hltDetector);

    /**
     * 修改监测仪
     * 
     * @param hltDetector 监测仪
     * @return 结果
     */
    public int updateHltDetector(HltDetector hltDetector);

    /**
     * 删除监测仪
     * 
     * @param id 监测仪主键
     * @return 结果
     */
    public int deleteHltDetectorById(Long id);

    /**
     * 批量删除监测仪
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHltDetectorByIds(Long[] ids);
}
