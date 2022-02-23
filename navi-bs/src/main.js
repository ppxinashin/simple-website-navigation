import Vue from 'vue'
import Vuex from 'vuex';
import Qs from 'qs';
import App from './App.vue'
//导入element-ui
import Eui from 'element-ui';
import '../node_modules/element-ui/lib/theme-chalk/index.css'
import '../node_modules/element-ui/lib/index.js'
//导入Axios
import Axios from "axios";
Vue.use(Eui);
Vue.use(Vuex);
Vue.use(Qs);
Vue.prototype.$axios = Axios;
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
