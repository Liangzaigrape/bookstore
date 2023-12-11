<template>
  <div class="tabComponent">
    <button
      v-for="tab in tabs"
      :key="tab.title"
      :class="['tab-button', { active: currentTab === tab.title }]"
      @click="currentTab = tab.title">
      {{ tab.displayName }}
    </button>

    <keep-alive>
      <component :is="currentTabComponent" :content="content" class="tab"></component>
    </keep-alive>
  </div>
</template>

<script>
  import BookIntroduction from './BookIntroduction.vue'
  import BookCommentList from './BookCommentList.vue'
  import BookQA from './BookQA.vue'

  export default {
    name:'TabComponent',
    props: {
      content: {
        type: String,
        default: ''
      }
    },
    data () {
      return {
        currentTab: 'introduction',
        tabs: [
          {title: 'introduction', displayName: '图书介绍'}, 
          {title: 'comment', displayName: '图书评价'},
          {title: 'qa', displayName: '图书问答'}
        ]
      };
    },

    components: {
      BookIntroduction,
      BookComment: BookCommentList,
      BookQa : BookQA
    },

    computed: {
      currentTabComponent: function () {
        return 'book-' + this.currentTab
      }
    }
  }
</script>
<style scoped>
.tabComponent{
  border-radius: 10px;
  margin-top: 10px;
  float: left;
  width: 100%;
  text-align: left;
  margin-left: 80px;
}
.tab-button {
  border-radius: 10px;
  margin-top: 10px;
  padding: 6px 10px;
  border: solid 1px #ccc;
  cursor: pointer;
  background: #f0f0f0;
  margin-bottom: -1px;
  margin: 10px;
}
.tab-button:hover {
  border-radius: 10px;
  margin-top: 10px;
  background: #e0e0e0;
}
.tab-button.active {
  border-radius: 10px;
  margin-top: 10px;
  background: #cdcdcd;
}
.tab {
  margin-top: 10px;
  border-radius: 10px;
  border: 2px solid #ccc;
  padding: 10px;
}
</style>