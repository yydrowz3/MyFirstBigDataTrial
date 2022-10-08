import type { FormInstance } from 'element-plus';
import { ref } from 'vue';
export interface changeFormInt {
    id: number;
    password: string;
    newpassword: string;
    rpassword: string;
}

export class InitData {
    changeForm: changeFormInt = {
        id: -1,
        password: '',
        newpassword: '',
        rpassword: '',
    }
    changeFormRef = ref<FormInstance>()
}

export interface changeFormInt1 {
    password: string;
    rpassword: string;
}

export class InitData1 {
    changeForm1: changeFormInt1 = {
        password: '',
        rpassword: '',
    }
    changeFormRef1 = ref<FormInstance>()
}
