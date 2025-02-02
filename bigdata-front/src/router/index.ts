import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router';
import Main from '../views/Main/Main.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'main',
    component: Main,
    // component: () => import('../views/user/UploadImg.vue'),
    children: [
      {
        path: '/display',
        name: 'display',
        component: () => import('../views/display/Display.vue'),
      },
      {
        path: '/analysis',
        name: 'analysis',
        component: () => import('../views/analysis/Index.vue'),
      },
      {
        path: '/user',
        name: 'user',
        component: () => import('../views/user/Index.vue'),
      },
      {
        path: '/userchange',
        name: 'userchange',
        component: () => import('../views/user/userChange.vue'),
      },
      {
        path: '/userchange1',
        name: 'userchange1',
        component: () => import('../views/user/editpassword.vue'),
      },
      {
        path: '/schoolinfo',
        name: 'schoolinfo',
        component: () => import('../views/analysis/SchoolInfo.vue'),
      },
    ],
  },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ '../views/AboutView.vue'),
  // },
  {
    path: '/login',
    name: 'Login',
    component: () =>
      import(/* webpackChunkName: "login" */ '../views/LoginView.vue'),
  },

  // {
  //   path: '/test',
  //   name: 'test',
  //   component: () =>
  //     import(/* webpackChunkName: "login" */ '../views/Test.vue'),
  // },
  {
    path: '/register',
    name: 'Register',
    component: () =>
      import(/* webpackChunkName: "register" */ '../views/RegisterView.vue'),
  },
  {
    path: '/RetrievePassword',
    name: 'RetrievePassword',
    component: () =>
      import(
        /* webpackChunkName: "RetrievePassword" */ '../views/user/RetrievePassword.vue'
      ),
  },

  {
    path: '/admin',
    name: 'Admin',
    component: () => import('../views/AdminView.vue'),
    children: [
      {
        path: 'users',
        name: 'Users',
        component: () => import('../views/admin/users/Index.vue'),
      },
      {
        path: 'settings',
        name: 'Settings',
        component: () => import('../views/admin/settings/Index.vue'),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

// 每次跳转前判断
router.beforeEach((to) => {
  // const user = localStorage.getItem('user');
  // if (!user && to.path !== '/login') {
  //   //如果没登录先跳转登录页面
  //   return '/login';
  // }
});

export default router;
