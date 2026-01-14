package com.cm.system.service.impl;

import java.util.List;
import com.cm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cm.system.mapper.HltEquipMapper;
import com.cm.system.domain.HltEquip;
import com.cm.system.service.IHltEquipService;

/**
 * 设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-14
 */
@Service
public class HltEquipServiceImpl implements IHltEquipService 
{
    @Autowired
    private HltEquipMapper hltEquipMapper;

    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    @Override
    public HltEquip selectHltEquipById(Long id)
    {
        return hltEquipMapper.selectHltEquipById(id);
    }

    /**
     * 查询设备列表
     * 
     * @param hltEquip 设备
     * @return 设备
     */
    @Override
    public List<HltEquip> selectHltEquipList(HltEquip hltEquip)
    {
        return hltEquipMapper.selectHltEquipList(hltEquip);
    }

    /**
     * 新增设备
     * 
     * @param hltEquip 设备
     * @return 结果
     */
    @Override
    public int insertHltEquip(HltEquip hltEquip)
    {
        return hltEquipMapper.insertHltEquip(hltEquip);
    }

    /**
     * 修改设备
     * 
     * @param hltEquip 设备
     * @return 结果
     */
    @Override
    public int updateHltEquip(HltEquip hltEquip)
    {
        hltEquip.setUpdateTime(DateUtils.getNowDate());
        return hltEquipMapper.updateHltEquip(hltEquip);
    }

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的设备主键
     * @return 结果
     */
    @Override
    public int deleteHltEquipByIds(Long[] ids)
    {
        return hltEquipMapper.deleteHltEquipByIds(ids);
    }

    /**
     * 删除设备信息
     * 
     * @param id 设备主键
     * @return 结果
     */
    @Override
    public int deleteHltEquipById(Long id)
    {
        return hltEquipMapper.deleteHltEquipById(id);
    }
}
