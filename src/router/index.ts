import {
    createRouter,
    createWebHashHistory,
    RouteRecordRaw,
} from "vue-router";

const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        redirect: "/home",
    },
    {
        path: "/home",
        name: "home",
        component: ()=> import('../views/homeView/home.vue'),
    },
    {
        path: "/personal",
        name: "personal",
        component: ()=> import('../views/personalView/personal.vue'),
    },
    {
        path: "/community",
        name: "community",
        component: ()=> import('../views/communityView/community.vue'),
    },
    {
        path: "/identify",
        name: "identify",
        component: ()=> import('../views/identifyView/identify.vue'),
    },
    {
        path: "/repo",
        name: "repo",
        component: ()=> import('../views/repoView/repo.vue'),
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;
