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
import com.cm.system.domain.HltDetector;
import com.cm.system.service.IHltDetectorService;
import com.cm.common.utils.poi.ExcelUtil;
import com.cm.common.core.page.TableDataInfo;

/**
 * 监测仪Controller
 * 
 * @author zw
 * @date 2026-01-14
 */
@RestController
@RequestMapping("/system/detector")
public class HltDetectorController extends BaseController
{
    @Autowired
    private IHltDetectorService hltDetectorService;

    /**
     * 查询监测仪列表
     */
    @PreAuthorize("@ss.hasPermi('system:detector:list')")
    @GetMapping("/list")
    public TableDataInfo list(HltDetector hltDetector)
    {
        startPage();
        List<HltDetector> list = hltDetectorService.selectHltDetectorList(hltDetector);
        return getDataTable(list);
    }

    /**
     * 导出监测仪列表
     */
    @PreAuthorize("@ss.hasPermi('system:detector:export')")
    @Log(title = "监测仪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HltDetector hltDetector)
    {
        List<HltDetector> list = hltDetectorService.selectHltDetectorList(hltDetector);
        ExcelUtil<HltDetector> util = new ExcelUtil<HltDetector>(HltDetector.class);
        util.exportExcel(response, list, "监测仪数据");
    }

    /**
     * 获取监测仪详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detector:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hltDetectorService.selectHltDetectorById(id));
    }

    /**
     * 新增监测仪
     */
    @PreAuthorize("@ss.hasPermi('system:detector:add')")
    @Log(title = "监测仪", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HltDetector hltDetector)
    {
        return toAjax(hltDetectorService.insertHltDetector(hltDetector));
    }

    /**
     * 修改监测仪
     */
    @PreAuthorize("@ss.hasPermi('system:detector:edit')")
    @Log(title = "监测仪", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HltDetector hltDetector)
    {
        return toAjax(hltDetectorService.updateHltDetector(hltDetector));
    }

    /**
     * 删除监测仪
     */
    @PreAuthorize("@ss.hasPermi('system:detector:remove')")
    @Log(title = "监测仪", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hltDetectorService.deleteHltDetectorByIds(ids));
    }
}
