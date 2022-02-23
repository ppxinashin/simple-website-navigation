<template>

  <el-row :gutter="20" >
    <homepage-logo
        v-popover:deletePopoverVisible
        v-for="(ws,index) in homepageWebsites"
        @click.native.stop="jumpTo(ws.link)"

        :key="index"
        :logo-src="require('@/assets/'+ws.icon)"
        :logo-name="ws.name"></homepage-logo>
    <homepage-logo :logo-src="require('@/assets/img/alter.svg')"
                   logo-name="编辑"
                    @click.native="dialogVisible = true"
                   ></homepage-logo>
    <el-dialog
        title="编辑应用"
        :visible.sync="dialogVisible"
        width="70%"
        >
      <span>
        <el-row :gutter="20">
          <homepage-logo
              v-for="(ws,index) in homepageWebsites"
              @click.native="delTip(ws.siteId)"
              :key="index"
              :logo-src="require('@/assets/'+ws.icon)"
              :logo-name="ws.name"></homepage-logo>
          <homepage-logo :logo-src="require('@/assets/img/add-circle.svg')"
                         logo-name="添加"
                         @click.native="addVisible = true"
          ></homepage-logo>
        </el-row>
      </span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
    <el-dialog
        title="添加"
        :visible.sync="addVisible"
        width="50%">
      <span>
        <el-row :gutter="20">
        <el-col :span="6">
          <el-input placeholder="网站名称" v-model="siteName"></el-input>
          <el-input placeholder="网站链接" v-model="siteUrl"></el-input>
        </el-col>
      </el-row></span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelAdd()">取 消</el-button>
    <el-button type="primary" @click="submitAdd()">添 加</el-button>
      </span>
    </el-dialog>
    <el-dialog
        title="编辑网页"
        :visible.sync="altVisible"
        width="50%">
      <span>
        <el-row :gutter="20">
        <el-col :span="6">
          <el-input placeholder="网站名称" v-model="siteName"></el-input>
          <el-input placeholder="网站链接" v-model="siteUrl"></el-input>
        </el-col>
      </el-row></span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelAlt()">取 消</el-button>
    <el-button type="primary" @click="submitAlt()">修 改</el-button>
      </span>
    </el-dialog>
    <msg-box
        msg-title="删除"
        :box-visible="deleteVisible"
        width="30%"
        msg-content="确认删除？也可以点击'取消'跳到修改界面"
        @cancel="cancelDel()"
        @ok="submitDel()"
    ></msg-box>
  </el-row>

</template>


<script>
import HomepageLogo from "@/components/HomepageLogo";
import MsgBox from "@/components/MsgBox";

export default {
name: "HomepageMenu",
  components: {
    MsgBox,

    HomepageLogo},
  data(){
   return{
     homepageWebsites:[],
     deleteId:0,
     addState:false,
     delState:false,
     altVisible:false,
     dialogVisible:false,
     deleteVisible:false,
     addVisible:false,
     siteName:'',
     siteUrl:''
   }
  },
  methods: {
    getSites(){
      let apiUri = "http://localhost:8080/homepageWebsite/allSites";
      this.$axios(apiUri).then(res =>{
        console.log(res.data)
        this.homepageWebsites = res.data;
      }).catch(e => console.log(e))
    },
    jumpTo(link){
      window.open(link,"_blank");

    },
    cancelAlt(){
      this.altVisible = false;
    },
    submitAlt(){
      this.$axios({
        method:'put',
        url:'http://localhost:8080/homepageWebsite/altWebSite/',
        data:{
          siteId:this.deleteId,
          name:this.siteName,
          link:this.siteUrl,
        }
      }).then(res => {
        this.addState = res.data.success;
        if (this.addState){
          this.$message({
            showClose:true,
            message:"修改成功",
            type:"success"
          })

        }
      }).catch(e => console.log(e))
      this.siteName = '';
      this.siteUrl = '';
      this.altVisible = false;
    },
    forbiddenRight(e){

      e.stopPropagation()
    },
    cancelAdd(){
      this.addVisible = false;
    },
    submitAdd(){
      this.$axios({
        method:'post',
        url:'http://localhost:8080/homepageWebsite/addSite/',
        data:{
          name:this.siteName,
          link:this.siteUrl,
          icon:"img/earth.svg",
          userId:1
        }
      }).then(res => {
        this.addState = res.data.success;
        if (this.addState){
          this.$message({
            showClose:true,
            message:"添加成功",
            type:"success"
          })

        }
      }).catch(e => console.log(e))
      this.siteName = '';
      this.siteUrl = '';
      this.addVisible = false;
    },
    delTip(id){
      // window.alert(id);
      this.deleteId = id;
      this.deleteVisible = true;

    },
    cancelDel(){
      this.altVisible = true;
      this.deleteVisible = false;
    },
    submitDel(){
      this.$axios.delete(`http://localhost:8080/homepageWebsite/deleteSite/${this.deleteId}`)
          .then(res => {
            this.delState = res.data.success;
            if (this.delState){
              this.$message({
                showClose: true,
                message: "删除成功",
                type:"success"
              })
            }
          }).catch(e => console.log(e))
      this.deleteVisible = false;
    }

  },
  watch:{
    siteName: function (val) {
      this.siteName = val;
    },
    siteUrl: function (val) {
      this.siteUrl = val;
    }
  },
  mounted() {
  this.getSites();
  }
}
</script>

<style scoped>

</style>