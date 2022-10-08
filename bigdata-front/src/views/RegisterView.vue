<!--  -->
<template>
  <div class="box">
    <div class="common-layout">
      <el-container>
        <div class="left">
          <div><img src="../assets/images/logo.png" /></div>
          <div class="h">欢迎注册高校招生系统</div>
        </div>
        <el-main class="right">
          <el-form
            ref="registerFormRef"
            label-position="right"
            label-width="5vw"
            :model="registerForm"
            status-icon
            :rules="rules"
          >
            <el-form-item label="用户名:" label-width="6vw" prop="nickName">
              <el-input v-model="registerForm.nickName" autocomplete="off" />
            </el-form-item>

            <el-form-item label="密    码：" label-width="6vw" prop="password">
              <el-input
                v-model="registerForm.password"
                show-password
                autocomplete="off"
              />
            </el-form-item>

            <el-form-item label="确认密码:" label-width="6vw" prop="rpassword">
              <el-input
                v-model="registerForm.rpassword"
                show-password
                autocomplete="off"
              />
            </el-form-item>

            <el-form-item label="邮箱" label-width="6vw" prop="email">
              <el-input
                placeholder="请输入邮箱"
                v-model="registerForm.email"
                autocomplete="off"
              />
            </el-form-item>
            <el-form-item label="性别" label-width="6vw" prop="sex">
              <el-radio-group v-model="registerForm.sex">
                <el-radio :label="'男'" size="large" border>男</el-radio>
                <el-radio :label="'女'" size="large" border>女</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="电话" label-width="6vw" prop="teleNumber">
              <el-input
                placeholder="请输入电话"
                v-model="registerForm.teleNumber"
                autocomplete="off"
              />
            </el-form-item>
            <el-form-item>
              <el-button
                class="btn-1"
                type="primary"
                @click="submitForm(registerFormRef)"
                >注册</el-button
              >
            </el-form-item>
            <el-from-item>
              <div class="toLogin">
                已有账号?<el-link @click="goLogin" type="primary"
                  >点此登录</el-link
                >
              </div>
            </el-from-item>
          </el-form>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, toRefs, ref } from "vue";
import { InitData } from "../types/register";
import { FormInstance, ElMessage } from "element-plus";
import { register } from "../http/api";
import { useRouter } from "vue-router";

export default defineComponent({
  setup() {
    const data = reactive(new InitData());
    const rpassword = ref("");
    const router = useRouter();
    var surePwd = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== data.registerForm.password) {
        callback(new Error("两次输入密码不一致!"));
        // console.log(value);
        // console.log(data.registerForm.password)
      } else {
        callback();
      }
    };
    const rules = {
      nickName: [
        { required: true, message: "请输入账号", trigger: "blur" },
        { min: 4, max: 15, message: "账号长度需要介于4-15", trigger: "blur" },
      ],

      password: [
        { required: true, message: "请输入密码", trigger: "blur" },
        { min: 6, max: 18, message: "密码长度需要介于6-18", trigger: "blur" },
      ],

      rpassword: [
        // { required: true, message: '请确认密码', trigger: 'blur' },
        { validator: surePwd, trigger: "blur", required: true },
      ],
    };
    const submitForm = (registerFormRef: FormInstance | undefined) => {
      if (!registerFormRef) return;

      registerFormRef.validate((valid: boolean) => {
        if (valid) {
          register(data.registerForm)
            .then((res) => {
              // console.log(res);
              if (res.data.code == 200) {
                ElMessage.success({
                  message: "注册成功!正在返回登录页面!",
                  type: "success",
                });
                router.push("/login");
              } else {
                ElMessage.warning({
                  message: res.data.msg,
                  type: "warning",
                });
                return false;
              }
            })
            .catch((err) => {
              // console.log(err);
              ElMessage.warning({
                message: err,
                type: "warning",
              });
            });
        }
      });
    };
    const goLogin = () => {
      router.push("/login");
    };

    return {
      ...toRefs(data),
      rules,
      submitForm,
      goLogin,
      rpassword,
    };
  },
});
</script>

<style lang="less" scoped>
.box {
  background-image: url("../assets/images/signback1.jpeg");
  background-size: 100vw 100vh;
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  /*关键*/
  background-position: center;
  background-image: url("../assets/images/signback1.jpeg");
  height: 100vh;
  width: 100vw;
  position: absolute;
}
.common-layout {
  .el-side{
    height: 100%;
    background: rgb(134, 144, 150);
  }
  width: 64vw;
  height: 60vh;
  margin: auto;
  margin-top: 18vh;
  background: white;
  border-radius: 10px;
  .el-input {
    width: 20vw;
    height: 4vh;
  }
  .el-button {
    margin-left: 1vw;
    width: 20vw;
    height: 4vh;
  }
  .left {
    background: rgb(134, 144, 150);
    overflow: top;
    width: 30vw;
    height: 60vh;
    font-size: 30px;
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
    text-shadow: gray 1px 2px 4px 1px;
    .h {
      height: 10vh;
      width: 24vw;
      overflow: hidden;
      font-size: 3vh;
      color: rgb(0, 0, 0);
      margin-left: 6vw;
      margin-bottom: 0vh;
    }
    img {
      width: 20vh;
      height: 20vh;
      margin-left: 8vw;
      margin-top: 15vh;
      overflow: top;
    }
    .w {
      margin-top: 30%;
      display: flex;
      text-align: center;
      justify-content: center;
    }
  }

  .btn-1 {
    margin-right: 20px;
  }

  .toLogin {
    position: inherit;
    margin-left: 90px;
  }

  .right {
    width: 34vw;

    .el-form {
      margin-left: 3vw;
      margin-top:3vh;
      .registerForm {
        background: white;
      }

      .register-title {
        text-align: center;
        margin-top: 20px;
        margin-bottom: 40px;
      }

      .btn {
        margin-top: 40px;
        margin-bottom: 40px;
      }
    }
  }
}
/deep/ .el-main {
  width:34vw;
  overflow: auto;
  margin: auto;
  --el-main-padding: 0px;
  div::-webkit-scrollbar {
  width: 0;
  }
}
/deep/ .el-container{
  overflow: auto;
  margin: auto;
  padding: 0;
  --el-main-padding: 0px;
  div::-webkit-scrollbar {
  width: 0;
}
}
</style>