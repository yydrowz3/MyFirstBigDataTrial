<template>
  <div class="common-layout">
    <el-container style="height: 100%">
      <el-aside width="auto">
        <admin-aside></admin-aside>
      </el-aside>
      <el-container style="height: 100vh">
        <el-header>
          <common-header></common-header>
        </el-header>
        <el-main>
          <div v-show="currentPath === '/admin'">
            <el-row :gutter="20">
              <el-col :span="12">
                <el-row :gutter="20">
                  <el-card>
                    <el-row :gutter="50">
                      <el-col :span="6">
                        <el-image
                          src="https://picture-1305384466.cos.ap-nanjing.myqcloud.com/QQ%E5%9B%BE%E7%89%8720220527171824.gif"
                          fit="contain"
                        />
                      </el-col>
                      <el-col :span="18">
                        <el-row>
                          <h1>欢迎访问管理员后台！</h1>
                        </el-row>
                        <el-row>
                          <h3>
                            你好!
                            <el-tag>{{ nickName }}</el-tag>
                          </h3>
                        </el-row>
                      </el-col>
                    </el-row>
                  </el-card>
                </el-row>
                <el-row>
                  <el-timeline>
                    <el-timeline-item
                      timestamp="2022/5/29"
                      placement="top"
                      type="danger"
                      :hollow="true"
                    >
                      <el-card>
                        <h4>最终答辩</h4>
                        <p>软通动力 2022/5/29 09:00</p>
                      </el-card>
                    </el-timeline-item>
                    <el-timeline-item
                      timestamp="2022/5/26"
                      placement="top"
                      type="primary"
                      :hollow="true"
                    >
                      <el-card>
                        <h4>中期线下检查 任务完成情况</h4>
                        <p>双中心A307 2022/5/26 14:30</p>
                      </el-card>
                    </el-timeline-item>
                    <el-timeline-item
                      timestamp="2022/5/19"
                      placement="top"
                      type="primary"
                      :hollow="true"
                    >
                      <el-card>
                        <h4>中期线下检查 story列表 + 数据字典</h4>
                        <p>双中心A307 2022/5/19 14:30</p>
                      </el-card>
                    </el-timeline-item>
                    <el-timeline-item
                      timestamp="2022/5/7"
                      placement="top"
                      type="primary"
                      :hollow="true"
                    >
                      <el-card>
                        <h4>工程实践宣讲会</h4>
                        <p>线上腾讯会议 2022/5/7 19:30</p>
                      </el-card>
                    </el-timeline-item>
                  </el-timeline>
                </el-row>
              </el-col>
              <el-col :span="12">
                <el-card>
                  <el-calendar :v-model="date" />
                </el-card>
              </el-col>
            </el-row>
          </div>
          <router-view></router-view>
        </el-main>
        <el-footer>
          <my-footer></my-footer>
        </el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<style lang="scss" scoped>
.el-header {
  background-color: rgb(58, 58, 58);
  color: rgb(255, 255, 255);
}

.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>

<script lang="ts">
import AdminAside from '@/components/admin/AdminAside.vue';
import CommonHeader from './components/CommonHeader.vue';
import MyFooter from '../components/MyFooter.vue';
import { useRoute, useRouter } from 'vue-router';
import { reactive, toRefs, onMounted } from 'vue';
// import { Avatar } from '@element-plus/icons-vue';
// import { defineComponent } from 'vue';
// import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

export default {
  name: 'AdminView',
  components: {
    AdminAside,
    CommonHeader,
    MyFooter,
  },
  // data() {
  //   const route = useRoute();
  //   let currentPath = route.path;
  //   const date = new Date();
  //   return { currentPath, date };
  // },
  setup() {
    const route = useRoute();
    const router = useRouter();
    const userInfo = JSON.parse(localStorage.getItem('user'));
    const data = reactive({
      currentPath: route.path,
      nickName: userInfo.nickName,
    });

    // onMounted(() => {
    //   console.log(userInfo.nickName);
    // });

    router.afterEach(() => {
      data.currentPath = route.path;
    });

    return { ...toRefs(data), onMounted };
  },
};
</script>
