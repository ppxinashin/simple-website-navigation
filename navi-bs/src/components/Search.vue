<template>
  <div style="margin-top: 50px;">
    <el-input :placeholder="planceholder"
              class="input-with-select"
              id="keyword"
              v-model="keyword"
              @keyup.enter.native="searchIt()">
      <el-select v-model="select" slot="prepend" placeholder="请选择">
        <el-option v-for="(lab,index) in searchingList"
                   :key="index"
                   :label="lab.name"
                   :value="lab.searchId"
                   :style="{color: lab.color}"
                   @click.native="getSite(lab)"></el-option>

      </el-select>
      <el-button slot="append"
                 icon="el-icon-search"
                 @click.native="searchIt()"
      ></el-button>

    </el-input>

  </div>

</template>

<script>
export default {
  name: "Search",
  components: {},
  data() {
    return {
      searchingList: [],
      link: "https://www.bing.com/search?q=",
      keyword: null,
      color: "#5f5f5f",
      dialogVisible: false,
      planceholder: '搜一搜',
    }
  },
  methods: {
    getSearching() {
      let apiUrl = "http://localhost:8080/search/allSites";
      this.$axios(apiUrl).then(res => {
        this.searchingList = res.data;
      }).catch(e => console.log(e));
    },
    hotWordsJson: function(obj){
      return obj
    },
    getSite(lab) {
      this.planceholder = lab.placeholder;
      this.link = `${lab.searchlink}?${lab.searchname}=`;
    },
    searchIt() {
      window.open(this.link + this.keyword, '_blank')
    },

    addSearch() {

    }


  },
  watch: {
    keyword: function (val) {
      this.keyword = val;
    }
  },
  mounted() {
    this.getSearching();

  }
}
</script>

<style scoped>

</style>