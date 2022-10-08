<template>
  <div class="change-box">

    <div>
      <el-form ref="changeFormRef1" :model="changeForm1" status-icon :rules="rules1" label-width="120px"
        class="changeForm">
        <h2 class="change-title">修改密码</h2>
        <el-form-item label="请输入原密码:" prop="password">
          <el-input v-model="changeForm1.password" show-password autocomplete="off" />
        </el-form-item>
        <el-form-item class="btn">
          <el-button class="btn-1" type="primary" @click="submitForm1">返回</el-button>
          <el-button class="btn-2" type="primary" @click="next(changeFormRef1)">下一步</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts">
import view from '../../util/view'
import { defineComponent, reactive, toRefs, ref, onBeforeMount } from "vue";
import { InitData, InitData1 } from "../../types/change";
import { FormInstance, ElMessage } from "element-plus";
import { change } from "../../http/api";
import { useRouter } from "vue-router";
import router from '@/router';
import { login } from '../../http/api';

export default defineComponent({
  setup() {
    const mixins = [view]
    const router = useRouter();
    const user = JSON.parse(localStorage.getItem("user"));
    if (user == null) {
      router.push("/")
    }
    const data1 = reactive(new InitData1());
    const rules1 = {
      password: [
        { required: true, message: '请输入密码', trigger: 'blur' }
      ]
    }
    const next = (changeFormRef1: FormInstance | undefined) => {
      changeFormRef1.validate((valid: boolean) => {
        if (valid) {
          login({
            nickName: user.nickName,
            password: data1.changeForm1.password
          }).then(
            (res) => {
              if (res.data.code == 200) {
                ElMessage.success("验证通过");
                router.push("/userchange1")
                localStorage.setItem("pass","pass")
              }
              else {
                ElMessage.error("密码错误,验证不通过");
              }
            }
          ).catch(
            (err) => {
              ElMessage.error("其他错误!");
            }
          )



        }
        else {
          // ElMessage.error("请输入原密码");
        }
      })
    }
    const submitForm1 = () => {
      router.push('user')
    }

    return {
      ...toRefs(data1),
      rules1,
      mixins,
      next,
      submitForm1
    };
  },
});
</script>

<style  lang="scss" scoped>
h2 {
  margin-right: 8vw;
}

.change-box {
  div::-webkit-scrollbar {
    width: 0;
  }

  overflow: auto;
  top: 0;
  left: 0;
  z-index: -10;
  zoom: 1;
  box-sizing: border-box;
  height: 91vh;
  width: 85vw;

  .el-form-item {
    margin-left: 17vw;
    width: 85vw;
    margin-bottom: 10vh;
  }

  ::v-deep .el-input {
    width: 30vw;
  }

  .change-title {
    text-align: center;
    margin-top: 4vh;
    margin-bottom: 7vh;
  }

  .btn {
    margin-top: 7vh;
    margin-bottom: 7vh;

    .btn-1 {
      margin-left: 0.5vw;
    }

    .btn-2 {
      margin-left: 21vw;
      margin-right: 1vw;
    }
  }
}
</style>
