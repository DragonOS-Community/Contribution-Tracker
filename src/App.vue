<template>
  <div class="root">
    <div>
      <el-menu
          default-active="0"
          class="el-menu-demo"
          mode="horizontal"
          :ellipsis="false"
          @select="handleSelect"
      >
        <el-menu-item index="0">
          <img src="@/assets/logo.png" height="30px"/>
          <router-link to="/home"><span style="font-weight: bold">DragonOS 社区贡献</span></router-link>
        </el-menu-item>
        <el-menu-item index="1">
          <router-link to="/community">仓库排行</router-link>
        </el-menu-item>
        <div class="flex-grow" />
        <el-menu-item index="2"><router-link to="/identify">证书验证</router-link></el-menu-item>
      </el-menu>
    </div>
    <div class="page">
      <router-view/>
    </div>
  </div>
</template>

<script lang="ts" setup>

const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style>
.root{
  width:100%;
  height:100vh;
}
.flex-grow {
  flex-grow: 1;
}
.page{
  height: calc(100vh - 60px);
}
</style>
