<template>
    <div class="change-box">
        <div>
            <el-form ref="changeFormRef" :model="changeForm" status-icon :rules="rules" label-width="120px"
                class="changeForm">
                <h2 class="change-title">修改密码</h2>

                <el-form-item label="新密码:" prop="newpassword">
                    <el-input v-model="changeForm.newpassword" show-password autocomplete="off" />
                </el-form-item>

                <el-form-item label="确认密码:" prop="rpassword">
                    <el-input v-model="changeForm.rpassword" show-password autocomplete="off" />
                </el-form-item>

                <el-form-item class="btn">
                    <el-button class="btn-1" type="primary" @click="submitForm1">返回</el-button>
                    <el-button class="btn-2" type="primary" @click="submitForm(changeFormRef)">修改密码</el-button>

                </el-form-item>
            </el-form>
        </div>

    </div>
</template>

<script lang = 'ts'>

import { defineComponent, reactive, toRefs } from 'vue'
import router from '@/router';
import { InitData, InitData1 } from "../../types/change";
import { FormInstance, ElMessage } from "element-plus";
import { editOneUser } from '@/http/adminApi';

export default defineComponent({
    setup() {
        const user = JSON.parse(localStorage.getItem("user"));
        if (user == null) {
            router.push("/")
        }
        const submitForm1 = () => {
            if (localStorage.getItem("pass") != null) {
                localStorage.removeItem("pass")
            }
            router.push('user')
        }
        if (localStorage.getItem("pass") == null) {
            submitForm1()
        }
        const data = reactive(new InitData());
        data.changeForm.id = user.id;
        var surePwd = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== data.changeForm.newpassword) {
                callback(new Error('两次输入密码不一致!'));
                console.log(value);
                console.log(data.changeForm.newpassword)

            } else {
                callback();
            }
        }
        const rules = {
            newpassword: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 6, max: 18, message: '密码长度需要介于6-18', trigger: 'blur' },
            ],

            rpassword: [
                // { required: true, message: '请确认密码', trigger: 'blur' },
                { validator: surePwd, trigger: 'blur', required: true }
            ]
        }

        const submitForm = (changeFormRef: FormInstance | undefined) => {
            changeFormRef.validate((valid: boolean) => {
                if (valid) {
                    editOneUser({
                        id: user.id,
                        password: data.changeForm.newpassword
                    }).then(
                        (res) => {
                            if (res.data.code == 200) {
                                ElMessage.success("密码修改成功,请重新登入!")
                                if (localStorage.getItem("pass") != null) {
                                    localStorage.removeItem("pass")
                                }
                                if (localStorage.getItem("user") != null) {
                                    localStorage.removeItem("user")
                                }
                                router.push("/login")
                            }
                            else {
                                ElMessage.error("密码修改失败!")
                            }
                        }
                    ).catch(
                        (err) => {
                            ElMessage.error("其他错误!")
                        }
                    )
                }
            })
        }
        return {
            rules,
            ...toRefs(data),
            submitForm1,
            submitForm
        }
    }
})

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
    height: 50vh;
    width: 60vw;
    background-color: rgb(203, 196, 196);

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
            margin-left: 19vw;
            margin-right: 1vw;
        }
    }
}
</style>