import $http from './index';

// 以下为用户管理部分接口

export const getUsers = (data) =>
  $http({
    url: '/user/selectUserListByPage',
    method: 'post',
    data,
  });


export const reliveOneUser = (data) =>
  $http({
    url: '/user/relive',
    method: 'post',
    data,
  });

export const deleteOneUser = (data) =>
  $http({
    url: '/user/logout',
    method: 'post',
    data,
  });

export const editOneUser = (data) =>
  $http({
    url: '/user/updata',
    method: 'post',
    data,
  });

export const addOneUser = (data) =>
  $http({
    url: '/user/register',
    method: 'post',
    data,
  });

// 以下为用户招生信息部分接口

export const getSchoolInfo = (data) =>
  $http({
    url: '/selectEnrollmentInfo',
    method: 'post',
    data,
  });

export const deleteOneSchoolInfo = (data) =>
  $http({
    // 未调试
    url: '/admin/api/deleteOneSchoolInfo',
    method: 'post',
    data,
  });

export const editOneSchoolInfo = (data) =>
  $http({
    // 未调试
    url: '/upEnrollmentInfo',
    method: 'post',
    data,
  });

export const addOneSchoolInfo = (data) =>
  $http({
    // 未调试
    url: '/admin/api/addOneSchoolInfo',
    method: 'post',
    data,
  });
