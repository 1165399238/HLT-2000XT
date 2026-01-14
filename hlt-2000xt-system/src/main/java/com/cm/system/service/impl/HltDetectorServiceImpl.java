package com.cm.system.service.impl;

import java.util.List;
import com.cm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cm.system.mapper.HltDetectorMapper;
import com.cm.system.domain.HltDetector;
import com.cm.system.service.IHltDetectorService;

/**
 * 监测仪Service业务层处理
 * 
 * @author zw
 * @date 2026-01-14
 */
@Service
public class HltDetectorServiceImpl implements IHltDetectorService 
{
    @Autowired
    private HltDetectorMapper hltDetectorMapper;

    /**
     * 查询监测仪
     * 
     * @param id 监测仪主键
     * @return 监测仪
     */
    @Override
    public HltDetector selectHltDetectorById(Long id)
    {
        return hltDetectorMapper.selectHltDetectorById(id);
    }

    /**
     * 查询监测仪列表
     * 
     * @param hltDetector 监测仪
     * @return 监测仪
     */
    @Override
    public List<HltDetector> selectHltDetectorList(HltDetector hltDetector)
    {
        return hltDetectorMapper.selectHltDetectorList(hltDetector);
    }

    /**
     * 新增监测仪
     * 
     * @param hltDetector 监测仪
     * @return 结果
     */
    @Override
    public int insertHltDetector(HltDetector hltDetector)
    {
        return hltDetectorMapper.insertHltDetector(hltDetector);
    }

    /**
     * 修改监测仪
     * 
     * @param hltDetector 监测仪
     * @return 结果
     */
    @Override
    public int updateHltDetector(HltDetector hltDetector)
    {
        hltDetector.setUpdateTime(DateUtils.getNowDate());
        return hltDetectorMapper.updateHltDetector(hltDetector);
    }

    /**
     * 批量删除监测仪
     * 
     * @param ids 需要删除的监测仪主键
     * @return 结果
     */
    @Override
    public int deleteHltDetectorByIds(Long[] ids)
    {
        return hltDetectorMapper.deleteHltDetectorByIds(ids);
    }

    /**
     * 删除监测仪信息
     * 
     * @param id 监测仪主键
     * @return 结果
     */
    @Override
    public int deleteHltDetectorById(Long id)
    {
        return hltDetectorMapper.deleteHltDetectorById(id);
    }
}
