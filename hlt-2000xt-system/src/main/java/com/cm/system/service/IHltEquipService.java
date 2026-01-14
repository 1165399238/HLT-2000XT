package com.cm.system.service;

import java.util.List;
import com.cm.system.domain.HltEquip;

/**
 * 设备Service接口
 * 
 * @author ruoyi
 * @date 2026-01-14
 */
public interface IHltEquipService 
{
    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    public HltEquip selectHltEquipById(Long id);

    /**
     * 查询设备列表
     * 
     * @param hltEquip 设备
     * @return 设备集合
     */
    public List<HltEquip> selectHltEquipList(HltEquip hltEquip);

    /**
     * 新增设备
     * 
     * @param hltEquip 设备
     * @return 结果
     */
    public int insertHltEquip(HltEquip hltEquip);

    /**
     * 修改设备
     * 
     * @param hltEquip 设备
     * @return 结果
     */
    public int updateHltEquip(HltEquip hltEquip);

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的设备主键集合
     * @return 结果
     */
    public int deleteHltEquipByIds(Long[] ids);

    /**
     * 删除设备信息
     * 
     * @param id 设备主键
     * @return 结果
     */
    public int deleteHltEquipById(Long id);
}
