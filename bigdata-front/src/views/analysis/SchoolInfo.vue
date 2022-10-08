<template>
    <!-- 学校资料卡：正上方 -->
    <el-row class="schoolInfoHeader">
        <el-col :span="22" style="margin-top: 10px;" :offset="1">
            <el-card shadow="never">
                <el-descriptions title="学校信息" border>
                    <el-descriptions-item label="学校名称" style="margin: 5px;">{{ schoolName }}</el-descriptions-item>
                    <el-descriptions-item label="学校代码">{{ schoolCode }}</el-descriptions-item>
                    <el-descriptions-item label="所在省份">{{ schoolProvince }}</el-descriptions-item>
                    <el-descriptions-item label="标签">
                        <el-tag size="small" style="margin: 5px;">985高校</el-tag>
                        <el-tag size="small" style="margin: 5px;">211高校</el-tag>
                        <el-tag size="small" style="margin: 5px;">双一流</el-tag>
                    </el-descriptions-item>
                    <el-descriptions-item label="招生总人数">{{ schoolTotalNumber }}人</el-descriptions-item>
                </el-descriptions>
            </el-card>
        </el-col>
    </el-row>
    <!-- 中间区分横条 -->
    <el-row class="schoolInfoIntro">
        <el-col :span="1" style="margin-top: 10px;background-color: orange;height: 20px;width: 1px;" :offset="1">
        </el-col>
        <el-col :span="2">
            <div class="majorTitle">
                <p>开设专业</p>
            </div>
        </el-col>
        <el-col :span="19" style="margin-top: 10px;background-color: orange;height: 20px;width: 1px;">
        </el-col>
    </el-row>
    <!-- 下方展示学校招生专业、专业代码、招生人数等的表格 -->
    <el-row class="majorCatalogue">
        <el-col :span="22" style="margin-top: 10px;" :offset="1">
            <el-table :data="tableData.slice((current - 1) * pageSize, current * pageSize)" border style="width: 100%">
                <el-table-column prop="date" label="专业名" width="250" />
                <el-table-column prop="date" label="类别" width="250" />
                <el-table-column prop="name" label="专业代码" width="250" />
                <el-table-column prop="address" label="招生人数" />
            </el-table>
        </el-col>
    </el-row>
    <!-- 分页、返回分析查询页面组件 -->
    <el-row class="pages">
        <el-col :span="5" style="margin-top: 10px;height: 10px;" :offset="1">
            <el-page-header title="返回" @back="backPage(analyse)" />
        </el-col>
        <el-col :span="5" style="height: 10px;" :offset="15">
            <el-pagination background v-model:currentPage="current" layout="prev, pager, next" :page-size="5"
                :total="100" />
        </el-col>
    </el-row>
</template>

<script lang="ts">
import { useRouter } from 'vue-router'
import { defineComponent, toRefs, reactive, ref, onMounted, getCurrentInstance, watch } from 'vue'

export default defineComponent({

    setup() {

        const tableData = [
            {
                date: '2016-05-03',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-02',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-04',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-05',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-06',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-07',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-08',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-09',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-10',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-11',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
            {
                date: '2016-05-12',
                name: 'Tom',
                address: 'No. 189, Grove St, Los Angeles',
            },
        ]

        const pageSize = 5
        const current = ref(1)
        const router = useRouter()
        const schoolName = '四川大学'
        const schoolCode = '10610'
        const schoolProvince = '四川省'
        const schoolTotalNumber = 19846

        const analyse = [
            {
                name: 'returnAnalysisPage',
                path: 'analysis'
            }
        ]

        const backPage = (item) => {
            router.push({ path: 'analysis' })
        }


        return {
            tableData,
            pageSize,
            current,
            analyse,
            schoolCode,
            schoolProvince,
            schoolTotalNumber,
            backPage,
            schoolName
        }


    }
})

</script>

<style>
.schoolTitle {
    background-color: whitesmoke;
    border-radius: 4px;
}

.majorTitle {
    text-align: center;
    margin-top: 10px;
    font-family: 'Courier New', Courier, monospace;
    font-weight: bold;
    font-size: larger;
}
</style>