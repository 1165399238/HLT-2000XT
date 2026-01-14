package com.cm.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cm.common.annotation.Log;
import com.cm.common.core.controller.BaseController;
import com.cm.common.core.domain.AjaxResult;
import com.cm.common.enums.BusinessType;
import com.cm.system.domain.HltEquip;
import com.cm.system.service.IHltEquipService;
import com.cm.common.utils.poi.ExcelUtil;
import com.cm.common.core.page.TableDataInfo;

/**
 * 设备Controller
 * 
 * @author ruoyi
 * @date 2026-01-14
 */
@RestController
@RequestMapping("/system/equip")
public class HltEquipController extends BaseController
{
    @Autowired
    private IHltEquipService hltEquipService;

    /**
     * 查询设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:equip:list')")
    @GetMapping("/list")
    public TableDataInfo list(HltEquip hltEquip)
    {
        startPage();
        List<HltEquip> list = hltEquipService.selectHltEquipList(hltEquip);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:equip:export')")
    @Log(title = "设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HltEquip hltEquip)
    {
        List<HltEquip> list = hltEquipService.selectHltEquipList(hltEquip);
        ExcelUtil<HltEquip> util = new ExcelUtil<HltEquip>(HltEquip.class);
        util.exportExcel(response, list, "设备数据");
    }

    /**
     * 获取设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:equip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hltEquipService.selectHltEquipById(id));
    }

    /**
     * 新增设备
     */
    @PreAuthorize("@ss.hasPermi('system:equip:add')")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HltEquip hltEquip)
    {
        return toAjax(hltEquipService.insertHltEquip(hltEquip));
    }

    /**
     * 修改设备
     */
    @PreAuthorize("@ss.hasPermi('system:equip:edit')")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HltEquip hltEquip)
    {
        return toAjax(hltEquipService.updateHltEquip(hltEquip));
    }

    /**
     * 删除设备
     */
    @PreAuthorize("@ss.hasPermi('system:equip:remove')")
    @Log(title = "设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hltEquipService.deleteHltEquipByIds(ids));
    }
}
