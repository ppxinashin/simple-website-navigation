<template>
  <el-dialog
      :title="msgTitle"
      :visible.sync="boxVisible"
      :width="width">
    <span><el-row :gutter="20" v-html="msgContent"></el-row></span>
    <span slot="footer" class="dialog-footer">
    <el-button @click="cancelListener()">取 消</el-button>
    <el-button type="primary" @click="okListener()">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
export default {
name: "MsgBox",
  data(){
    return{

    }
  },
  methods:{
    cancelListener(){
      return this.$emit("cancel");
    },
    okListener(){
      return this.$emit("ok");
    }
  },
  props:{
    width: String,
    msgTitle: String,
    boxVisible: Boolean,
    msgContent: Object,

  },

}
</script>

<style scoped>

</style>