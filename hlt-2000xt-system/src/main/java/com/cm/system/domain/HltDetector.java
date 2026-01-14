package com.cm.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.cm.common.annotation.Excel;
import com.cm.common.core.domain.BaseEntity;

/**
 * 监测仪对象 hlt_detector
 * 
 * @author zw
 * @date 2026-01-14
 */
public class HltDetector extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipName;

    /** 监测仪ip */
    @Excel(name = "监测仪ip")
    private String detectorIp;

    /** 监测仪类型 */
    @Excel(name = "监测仪类型")
    private String detectorType;

    /** 监测仪名称 */
    @Excel(name = "监测仪名称")
    private String detectorName;

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

    public void setEquipName(String equipName) 
    {
        this.equipName = equipName;
    }

    public String getEquipName() 
    {
        return equipName;
    }

    public void setDetectorIp(String detectorIp) 
    {
        this.detectorIp = detectorIp;
    }

    public String getDetectorIp() 
    {
        return detectorIp;
    }

    public void setDetectorType(String detectorType) 
    {
        this.detectorType = detectorType;
    }

    public String getDetectorType() 
    {
        return detectorType;
    }

    public void setDetectorName(String detectorName) 
    {
        this.detectorName = detectorName;
    }

    public String getDetectorName() 
    {
        return detectorName;
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
            .append("equipName", getEquipName())
            .append("detectorIp", getDetectorIp())
            .append("detectorType", getDetectorType())
            .append("detectorName", getDetectorName())
            .append("creatTime", getCreatTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
