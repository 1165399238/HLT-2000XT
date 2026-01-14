<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备编号" prop="equipCode">
        <el-input
          v-model="queryParams.equipCode"
          placeholder="请输入设备编号"
          :maxlength="50"
          show-word-limit
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属区域" prop="equipAreaName">
        <el-select v-model="queryParams.equipAreaName" placeholder="请选择所属区域" clearable>
          <el-option
            v-for="dict in dict.type.sys_area_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="监测位置" prop="equipMonitorPositon">
        <el-select v-model="queryParams.equipMonitorPositon" placeholder="请选择监测位置" clearable>
          <el-option
            v-for="dict in dict.type.sys_area_name"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="设备Ip" prop="equipIp">
        <el-input
          v-model="queryParams.equipIp"
          placeholder="请输入设备Ip"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="equipName">
        <el-select v-model="queryParams.equipName" placeholder="请选择设备名称" clearable>
          <el-option
            v-for="dict in dict.type.sys_equip_name"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="设备状态" prop="equipStatus">
        <el-select v-model="queryParams.equipStatus" placeholder="请选择设备状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_equip_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="设备类型" prop="equipType">
        <el-select v-model="queryParams.equipType" placeholder="请选择设备类型" clearable>
          <el-option
            v-for="dict in dict.type.sys_equip_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="daterangeCreatTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:equip:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:equip:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:equip:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:equip:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="equipList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="设备编号" align="center" prop="equipCode" />
      <el-table-column label="所属区域" align="center" prop="equipAreaName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_area_type" :value="scope.row.equipAreaName"/>
        </template>
      </el-table-column>
      <el-table-column label="监测位置" align="center" prop="equipMonitorPositon">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_area_name" :value="scope.row.equipMonitorPositon"/>
        </template>
      </el-table-column>
      <el-table-column label="设备Ip" align="center" prop="equipIp" />
      <el-table-column label="设备名称" align="center" prop="equipName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_equip_name" :value="scope.row.equipName"/>
        </template>
      </el-table-column>
      <el-table-column label="设备状态" align="center" prop="equipStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_equip_status" :value="scope.row.equipStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="设备类型" align="center" prop="equipType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_equip_type" :value="scope.row.equipType"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="creatTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.creatTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:equip:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:equip:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改设备对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备编号" prop="equipCode">
          <el-input v-model="form.equipCode" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="所属区域" prop="equipAreaName">
          <el-radio-group v-model="form.equipAreaName">
            <el-radio
              v-for="dict in dict.type.sys_area_type"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="监测位置" prop="equipMonitorPositon">
          <el-select v-model="form.equipMonitorPositon" placeholder="请选择监测位置">
            <el-option
              v-for="dict in dict.type.sys_area_name"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="设备Ip" prop="equipIp">
          <el-input v-model="form.equipIp" placeholder="请输入设备Ip" />
        </el-form-item>
        <el-form-item label="设备名称" prop="equipName">
          <el-select v-model="form.equipName" placeholder="请选择设备名称">
            <el-option
              v-for="dict in dict.type.sys_equip_name"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="设备状态" prop="equipStatus">
          <el-radio-group v-model="form.equipStatus">
            <el-radio
              v-for="dict in dict.type.sys_equip_status"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="设备类型" prop="equipType">
          <el-select v-model="form.equipType" placeholder="请选择设备类型">
            <el-option
              v-for="dict in dict.type.sys_equip_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="创建时间" prop="creatTime">
          <el-date-picker clearable
            v-model="form.creatTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEquip, getEquip, delEquip, addEquip, updateEquip } from "@/api/system/equip"

export default {
  name: "Equip",
  dicts: ['sys_area_name', 'sys_area_type', 'sys_equip_status', 'sys_equip_type', 'sys_equip_name'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 设备表格数据
      equipList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeCreatTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipCode: null,
        equipAreaName: null,
        equipMonitorPositon: null,
        equipIp: null,
        equipName: null,
        equipStatus: null,
        equipType: null,
        creatTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        equipName: [
          { required: true, message: "设备名称不能为空", trigger: "change" }
        ],
        equipType: [
          { required: true, message: "设备类型不能为空", trigger: "change" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询设备列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeCreatTime && '' != this.daterangeCreatTime) {
        this.queryParams.params["beginCreatTime"] = this.daterangeCreatTime[0]
        this.queryParams.params["endCreatTime"] = this.daterangeCreatTime[1]
      }
      listEquip(this.queryParams).then(response => {
        this.equipList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        equipCode: null,
        equipAreaName: null,
        equipMonitorPositon: null,
        equipIp: null,
        equipName: null,
        equipStatus: null,
        equipType: null,
        creatTime: null,
        createBy: null,
        updateTime: null,
        updateBy: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreatTime = []
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加设备"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getEquip(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改设备"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEquip(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addEquip(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除设备编号为"' + ids + '"的数据项？').then(function() {
        return delEquip(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/equip/export', {
        ...this.queryParams
      }, `equip_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
