<template>

    <el-main>

      <site-logo></site-logo>
      <search></search>
      <homepage-menu></homepage-menu>

    </el-main>

</template>

<script>
import Search from "@/components/Search";
import SiteLogo from "@/components/SiteLogo";
import HomepageMenu from "@/components/HomepageMenu";

export default {
name: "Container",
  components: {HomepageMenu, SiteLogo, Search}
}
</script>

<style scoped>

</style>