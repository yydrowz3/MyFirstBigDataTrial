import axios from 'axios';
import { ElMessage } from 'element-plus'
import {baseUrl} from '../types/baseUrl'
enum MSGS {
    "操作成功" = 200,
    "密码错误",
    "账号错误",
    "请求异常"
}


// 创建http实例
const $http = axios.create(
    {
        baseURL: baseUrl,
        headers: {
            "Content-Type": "application/json;charset=utf-8"
        }
    })

//请求拦截
$http.interceptors.request.use(config => {
    config.headers = config.headers || {}
    if (localStorage.getItem('token')) {
        config.headers.token = localStorage.getItem('token') || ''
    }

    return config
})

// $http.interceptors.response.use(res => {

//     // {
//     //     code:200,
//     //     data:{},
//     //     msg:"请求成功"
//     // }

//     const code: number = res.data.code
//     if (code != 200) {

//         ElMessage.error(MSGS[code])
//         return Promise.reject(res.data)
//     }
// }, err => {
//     console.log(err);
// })

export default $http