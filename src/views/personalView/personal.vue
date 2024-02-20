<template>
  <div class="personal-view">
    <p class="title">Kkong的个人贡献</p>
    <el-table :data="tableData" style="width: 100%;height: 80%;">
      <el-table-column fixed prop="rank" label="排名" sortable />
      <el-table-column prop="id" label="id" :show-overflow-tooltip="false" :visible="false"></el-table-column>
      <el-table-column prop="name" label="名称" sortable/>
      <el-table-column prop="pr" label="所属仓库" />
      <el-table-column prop="issue" label="时间" sortable/>
      <el-table-column label="操作">
        <template #header>
          <el-input v-model="search" size="small" placeholder="搜索仓库/用户名" />
        </template>
        <template #default="scope">
          <el-link type="primary" size="small" @click="handleEdit(scope.$index, scope.row)">贡献详情</el-link>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[100, 200, 300, 400]"
        :small="small"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </div>
</template>
<script setup lang="ts">
import {onMounted, ref} from 'vue'
import { Link } from '@element-plus/icons-vue'
onMounted(()=>{
  document.getElementsByClassName("el-pagination__goto")[0].innerHTML="跳转至"
  document.getElementsByClassName("el-pagination__total is-first")[0].innerHTML="共400条"
})

const currentPage = ref(4)
const pageSize = ref(100)
const small = ref(false)
const background = ref(true)
const disabled = ref(false)

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
}

const tableData = [
  {
    id:'1',
    rank: '1',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
  {
    id:'1',
    rank: '2',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
  {
    id:'1',
    rank: '3',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
  {
    id:'1',
    rank: '4',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
  {
    id:'1',
    rank: '5',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
  {
    id:'1',
    rank: '6',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
  {
    id:'1',
    rank: '7',
    name: 'Tom',
    pr: '3',
    issue: '4',
  },
]
</script>
<style scoped lang="scss" src="./personal.scss"></style>