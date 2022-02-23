<template>
  <div id="app">
    <el-container direction="vertical">
      <Header></Header>
      <Container></Container>
      <Footer></Footer>
    </el-container>
  </div>
</template>

<script>


import Container from "@/components/Container";
import Header from "@/components/Header";
import Footer from "@/components/Footer";

export default {
  name: 'App',
  components: {

    Header,
    Container,
    Footer,


  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
