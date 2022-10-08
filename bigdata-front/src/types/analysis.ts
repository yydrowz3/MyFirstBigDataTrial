import type { FormInstance } from 'element-plus';
import { ref } from 'vue';

export interface selectDataInt {
    enrollmentInfo: {
        schoolName: string;
        province: string;
        profess: string;
        subject:string;
    }
    pageNum: number;
    pageSize: number;
}

export class InitData {
    selectData: selectDataInt = {
        enrollmentInfo: {
            schoolName: '',
            province: '',
            profess: '',
            subject:''
        },
        pageNum: 1,
        pageSize: 10
    }
    pager={
        prev:0,
        pager:1,
        next:2
    }
    list: []
    page:'0'
}
