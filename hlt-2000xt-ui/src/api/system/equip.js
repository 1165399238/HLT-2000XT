import request from '@/utils/request'

// 查询设备列表
export function listEquip(query) {
  return request({
    url: '/system/equip/list',
    method: 'get',
    params: query
  })
}

// 查询设备详细
export function getEquip(id) {
  return request({
    url: '/system/equip/' + id,
    method: 'get'
  })
}

// 新增设备
export function addEquip(data) {
  return request({
    url: '/system/equip',
    method: 'post',
    data: data
  })
}

// 修改设备
export function updateEquip(data) {
  return request({
    url: '/system/equip',
    method: 'put',
    data: data
  })
}

// 删除设备
export function delEquip(id) {
  return request({
    url: '/system/equip/' + id,
    method: 'delete'
  })
}
