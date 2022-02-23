<template>
  <el-col :span="4" type="flex">


    <el-button class="de-border">
    <span ><el-image class="logo" :src="logoSrc"></el-image></span><br>
    <span>{{logoName}}</span>
    </el-button>

  </el-col>

</template>

<script>
export default {
  name: "HomepageLogo",
  props:{
    logoSrc: String,
    logoName: String,
  },
  data(){
    return{
    }
  },
  methods:{

  },
  watch:{

  }
}
</script>

<style scoped>
.logo{
  position: center;
  width: 50px;
  height: 50px;
  margin: 25px;
}
.de-border{
  border: none;
}
</style>