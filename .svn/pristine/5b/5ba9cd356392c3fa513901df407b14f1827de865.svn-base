<template>
  <el-menu
    router
    :default-active="current.fullPath"
    class="el-menu-vertical-demo"
    :collapse="false"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <h3>
      管理员后台<el-icon><Avatar /></el-icon>
    </h3>

    <el-menu-item index="/admin/users">
      <el-icon><User /></el-icon>
      <span>用户管理</span>
    </el-menu-item>
    <el-sub-menu index="1">
      <template #title>
        <el-icon><setting /></el-icon>
        <span>系统维护</span>
      </template>
      <el-menu-item index="/admin/settings">
        <el-icon><Document /></el-icon>
        <span>招生计划信息</span>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue';
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'AdminAside',
  components: {
    // HelloWorld,
  },
  setup() {
    const router = useRouter();
    const data = reactive({
      current: router.currentRoute,
    });
    // const list = router.getRoutes().filter((v) => v.meta.isShow === true);
    // console.log(list);
    return {
      ...toRefs(data),
    };
  },
});
</script>

<style lang="less" scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.el-menu {
  height: 100%;
  border: none;
  h3 {
    color: #fff;
    text-align: center;
    line-height: 48px;
  }
}
</style>
