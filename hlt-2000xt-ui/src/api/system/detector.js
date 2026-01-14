import request from '@/utils/request'

// 查询监测仪列表
export function listDetector(query) {
  return request({
    url: '/system/detector/list',
    method: 'get',
    params: query
  })
}

// 查询监测仪详细
export function getDetector(id) {
  return request({
    url: '/system/detector/' + id,
    method: 'get'
  })
}

// 新增监测仪
export function addDetector(data) {
  return request({
    url: '/system/detector',
    method: 'post',
    data: data
  })
}

// 修改监测仪
export function updateDetector(data) {
  return request({
    url: '/system/detector',
    method: 'put',
    data: data
  })
}

// 删除监测仪
export function delDetector(id) {
  return request({
    url: '/system/detector/' + id,
    method: 'delete'
  })
}
