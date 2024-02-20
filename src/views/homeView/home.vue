<template>
  <div class="homeView">
    <div class="contributor-table">
      <div class="tool-bar">
        <el-input
            v-model="userName"
            placeholder="请输入贡献者"
            :suffix-icon="Search"
        />
        <el-select
            v-model="repo"
            class="m-2"
            placeholder="请选择对应仓库"
        >
          <el-option
              v-for="item in repos"
              :key="item.value"
              :label="item.label"
              :value="item.value"
          />
        </el-select>
      </div>
      <el-table :data="tableData" style="width: 100%;height: 80%;">
        <el-table-column fixed prop="rank" label="排名" sortable />
        <el-table-column prop="id" label="id" :show-overflow-tooltip="false" :visible="false"></el-table-column>
        <el-table-column prop="name" label="贡献者" />
        <el-table-column prop="pr" label="pr数量" />
        <el-table-column prop="issue" label="issue数量" />
        <el-table-column label="操作">
          <template #default="scope">
            <el-link type="primary" size="small" @click="showPersonal(scope.$index, scope.row)">查看详情</el-link>
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
    <div class="ranking-list">
      <p class="title"><span style="font-size: 17px">⭐</span>热门项目</p>
      <div class="list">
        <div class="list-item" v-for="item in list" :key="item.rank">
          <div>
            <el-tag type="warning" size="small" v-if="item.rank==1||item.rank==2||item.rank==3">{{item.rank}}</el-tag>
            <el-tag type="default" v-else size="small">{{item.rank}}</el-tag>
            <router-link to="/repo"><span style="padding-left: 10px;font-size: 13px">{{item.name}}</span></router-link>
            <span style="display: inline-block;margin-left: 3px;font-size: 13px">🔥</span>
          </div>
          <div><span style="font-size: 13px">{{item.mark}}</span></div>
        </div>
        <div style="text-align: center;">
          <el-button type="default" size="small" plain @click="showAllRepos"> 查看全部 </el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { Search, StarFilled } from '@element-plus/icons-vue'
onMounted(()=>{
  document.getElementsByClassName("el-pagination__goto")[0].innerHTML="跳转至"
  document.getElementsByClassName("el-pagination__total is-first")[0].innerHTML="共400条"
})
import {onMounted, ref} from 'vue'
import {useRouter} from "vue-router";
const userName = ref('')
interface Contributor {
  id: string,
  rank: string,
  name: string,
  pr: string,
  issue: string,
}
const repo = ref('')
const repos = [
  {
    value: 'Option1',
    label: 'Option1',
  },
  {
    value: 'Option2',
    label: 'Option2',
  },
  {
    value: 'Option3',
    label: 'Option3',
  },
  {
    value: 'Option4',
    label: 'Option4',
  },
  {
    value: 'Option5',
    label: 'Option5',
  },
]

const showPersonal = (index: number, row: Contributor) => {
  console.log(index, row)
  router.push('/personal');
}
const list = [
  {
    rank:1,
    name:'jiggly',
    mark:3000
  },
  {
    rank:2,
    name:'hohoma',
    mark:3000
  },
  {
    rank:3,
    name:'ahishd',
    mark:3000
  },
  {
    rank:4,
    name:'ddsddi',
    mark:3000
  }
]
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

const router = useRouter();

const showAllRepos = () => {
  router.push('/community');
};
</script>
<style scoped lang="scss" src="./home.scss"></style>