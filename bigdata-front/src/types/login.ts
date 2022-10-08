import type {FormInstance} from 'element-plus';
import {ref}from 'vue';
export interface LoginFormInt{
    nickName:string;
    password:string;
}

export class InitData{
    loginForm:LoginFormInt ={
        nickName:'',
        password:''
    }
    loginFormRef = ref<FormInstance>()
}
