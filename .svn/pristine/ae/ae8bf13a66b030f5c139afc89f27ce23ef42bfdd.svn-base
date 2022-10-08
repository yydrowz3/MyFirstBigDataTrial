import type { FormInstance } from 'element-plus';
import { ref } from 'vue';

export interface SchoolInfoListInt {
  id: number;
  schoolCode: string;
  schoolName: string;
  province: string;
  majorCode: string;
  profess: string;
  subject: string;
  batch: number;
  plan: number;
}

interface selectDataInt {
  schoolName: string;
  profess: string;
  province: string;
  // page: number;
  // count: number;
}

interface queryDataInt {
  schoolName: string;
  profess: string;
  province: string;
  // page: number;
  // count: number;
}

export interface activeDataInt {
  id: number;
  schoolCode: string;
  schoolName: string;
  province: string;
  majorCode: string;
  profess: string;
  subject: string;
  batch: number;
  plan: number;
}

export class InitData {
  selectData: selectDataInt = {
    schoolName: '',
    profess: '',
    province: '',
  };
  queryData: queryDataInt = {
    schoolName: '',
    profess: '',
    province: '',
  };
  activeData: activeDataInt = {
    id: 0,
    schoolCode: '',
    schoolName: '',
    province: '',
    majorCode: '',
    profess: '',
    subject: '',
    batch: 0,
    plan: 0,
  };
  activeDataPointer: activeDataInt = null;
  // userlist: [UserListInt][] = [];
  // rolelist: RoleListInt[] = [];
  // listData: [UserListInt][] = [];
  // active: ActiveInt = {
  //   id: 0,
  //   nickname: '',
  //   userName: '',
  //   role: [],
  // };
  infoTotalList: SchoolInfoListInt[] = [];
  // infoPageList: [SchoolInfoListInt][] = [];  //存储分好页的数据的二维数组（已弃用）
  enrollmentInfo: SchoolInfoListInt;
  isShow = false;
  status = 0; // 0为add 1为edit
  currentPage = 1; //当前页
  pageSize = 10;
  totalNum = 0;
  formRef = ref<FormInstance>();
  isLoading = false;

  provinceList = [
    { label: '全部', value: '' },
    { label: '北京', value: '北京' },
    { label: '天津', value: '天津' },
    { label: '河北', value: '河北' },
    { label: '山西', value: '山西' },
    { label: '内蒙古', value: '内蒙古' },
    { label: '辽宁', value: '辽宁' },
    { label: '吉林', value: '吉林' },
    { label: '黑龙江', value: '黑龙江' },
    { label: '上海', value: '上海' },
    { label: '江苏', value: '江苏' },
    { label: '浙江', value: '浙江' },
    { label: '安徽', value: '安徽' },
    { label: '福建', value: '福建' },
    { label: '江西', value: '江西' },
    { label: '山东', value: '山东' },
    { label: '河南', value: '河南' },
    { label: '湖北', value: '湖北' },
    { label: '湖南', value: '湖南' },
    { label: '广东', value: '广东' },
    { label: '广西', value: '广西' },
    { label: '海南', value: '海南' },
    { label: '重庆', value: '重庆' },
    { label: '四川', value: '四川' },
    { label: '贵州', value: '贵州' },
    { label: '云南', value: '云南' },
    { label: '西藏', value: '西藏' },
    { label: '陕西', value: '陕西' },
    { label: '甘肃', value: '甘肃' },
    { label: '青海', value: '青海' },
    { label: '宁夏', value: '宁夏' },
    { label: '新疆', value: '新疆' },
    { label: '香港', value: '香港' },
    { label: '澳门', value: '澳门' },
    { label: '台湾', value: '台湾' },
  ];
}
