package com.cm.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.cm.common.annotation.Excel;
import com.cm.common.core.domain.BaseEntity;

/**
 * 设备对象 hlt_equip
 * 
 * @author ruoyi
 * @date 2026-01-14
 */
public class HltEquip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipCode;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private String equipAreaName;

    /** 监测位置 */
    @Excel(name = "监测位置")
    private String equipMonitorPositon;

    /** 设备Ip */
    @Excel(name = "设备Ip")
    private String equipIp;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipName;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String equipStatus;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String equipType;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setEquipCode(String equipCode) 
    {
        this.equipCode = equipCode;
    }

    public String getEquipCode() 
    {
        return equipCode;
    }

    public void setEquipAreaName(String equipAreaName) 
    {
        this.equipAreaName = equipAreaName;
    }

    public String getEquipAreaName() 
    {
        return equipAreaName;
    }

    public void setEquipMonitorPositon(String equipMonitorPositon) 
    {
        this.equipMonitorPositon = equipMonitorPositon;
    }

    public String getEquipMonitorPositon() 
    {
        return equipMonitorPositon;
    }

    public void setEquipIp(String equipIp) 
    {
        this.equipIp = equipIp;
    }

    public String getEquipIp() 
    {
        return equipIp;
    }

    public void setEquipName(String equipName) 
    {
        this.equipName = equipName;
    }

    public String getEquipName() 
    {
        return equipName;
    }

    public void setEquipStatus(String equipStatus) 
    {
        this.equipStatus = equipStatus;
    }

    public String getEquipStatus() 
    {
        return equipStatus;
    }

    public void setEquipType(String equipType) 
    {
        this.equipType = equipType;
    }

    public String getEquipType() 
    {
        return equipType;
    }

    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipCode", getEquipCode())
            .append("equipAreaName", getEquipAreaName())
            .append("equipMonitorPositon", getEquipMonitorPositon())
            .append("equipIp", getEquipIp())
            .append("equipName", getEquipName())
            .append("equipStatus", getEquipStatus())
            .append("equipType", getEquipType())
            .append("creatTime", getCreatTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
