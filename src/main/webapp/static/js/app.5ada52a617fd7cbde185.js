webpackJsonp([1],{"4+hh":function(t,e){},M8Jc:function(t,e){},NHnr:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s("7+uW"),n={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]},o=s("VU/8")({name:"App"},n,!1,null,null,null).exports,r=s("/ocq"),i=s("mtWM"),c=s.n(i);c.a.defaults.baseURL="/simple-blog-webapp/api",c.a.defaults.headers.post["Content-Type"]="application/json",c.a.defaults.headers.put["Content-Type"]="application/json";var d=c.a,p=s("HhAh"),l={data:function(){return{posts:[],errors:[]}},created:function(){var t=this;d.get("/posts?orderby=created_at_desc").then(function(e){t.posts=e.data}).catch(function(e){t.errors.push(e)})},methods:{debounceSearch:s.n(p)()(function(t){var e=this;d.get("/posts?search="+t.trim()+"&orderby=created_at_desc").then(function(t){e.posts=t.data}).catch(function(t){e.errors.push(t)})},300),deletePost:function(t){var e=this;d.delete("/posts/"+this.posts[t].id).then(function(t){}).catch(function(t){e.errors.push(t)}),this.posts.splice(t,1)}}},u={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"page-container"},[s("md-app",[s("md-app-toolbar",{staticClass:"md-primary"},[s("div",{staticClass:"md-toolbar-section-start"},[s("span",{staticClass:"md-title"},[t._v("Simple Blog Webapp")])]),t._v(" "),s("div",{staticClass:"md-toolbar-section-end"},[s("router-link",{attrs:{to:"/add"}},[s("md-button",{staticClass:"md-primary"},[t._v("Add Post")])],1)],1)]),t._v(" "),s("md-app-content",[s("div",{staticClass:"search"},[s("md-field",[s("label",[t._v("Advanced Search (by Terms)")]),t._v(" "),s("md-input",{on:{input:t.debounceSearch}}),t._v(" "),s("span",{staticClass:"md-helper-text"},[t._v('\n            For partial search use "?" for a single character and "*" for any character sequence\n          ')])],1)],1),t._v(" "),t._l(t.posts,function(e,a){return s("md-card",{key:e.id},[s("md-ripple",[s("md-card-header",[s("div",{staticClass:"md-title"},[t._v(t._s(e.title))]),t._v(" "),s("div",{staticClass:"md-subhead"},[t._v("by "+t._s(e.user.firstName)+" "+t._s(e.user.lastName))])]),t._v(" "),s("md-card-content",[t._v("\n            "+t._s(e.text)+"\n          ")]),t._v(" "),s("md-card-actions",[s("router-link",{attrs:{to:{path:"/edit",query:{id:e.id}}}},[s("md-button",{staticClass:"md-primary"},[t._v("Edit")])],1),t._v(" "),s("md-button",{staticClass:"md-accent",on:{click:function(e){t.deletePost(a)}}},[t._v("Delete")])],1)],1)],1)})],2)],1)],1)},staticRenderFns:[]};var m=s("VU/8")(l,u,!1,function(t){s("M8Jc")},"data-v-134e0aac",null).exports,v={data:function(){return{post:{},errors:[],snackbar:!1}},created:function(){var t=this,e=this.$route.query.id;null!=e&&""!==e.trim()&&d.get("/posts/"+e).then(function(e){t.post=e.data}).catch(function(e){t.errors.push(e)})},methods:{save:function(){var t=this;this.post.hasOwnProperty("id")?d.put("/posts",this.post).then(function(e){t.post=e.data,t.snackbar=!0}).catch(function(e){t.errors.push(e)}):d.post("/posts",this.post).then(function(e){t.post=e.data,t.snackbar=!0}).catch(function(e){t.errors.push(e)})}}},h={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"page-container"},[s("md-app",[s("md-app-toolbar",{staticClass:"md-primary"},[s("div",{staticClass:"md-toolbar-section-start"},[s("router-link",{attrs:{to:"/"}},[s("md-button",{staticClass:"md-icon-button"},[s("md-icon",[t._v("arrow_back")])],1)],1),t._v(" "),s("span",{staticClass:"md-title"},[t.post.id?s("span",[t._v("Edit")]):s("span",[t._v("Add")]),t._v("\n          Post\n        ")])],1),t._v(" "),s("div",{staticClass:"md-toolbar-section-end"},[s("md-button",{staticClass:"md-primary",on:{click:t.save}},[t._v("Save")])],1)]),t._v(" "),s("md-app-content",[s("md-field",[s("label",[t._v("The Title")]),t._v(" "),s("md-input",{model:{value:t.post.title,callback:function(e){t.$set(t.post,"title",e)},expression:"post.title"}}),t._v(" "),s("span",{staticClass:"md-helper-text"},[t._v("Brevity is the soul of wit!")])],1),t._v(" "),s("md-field",[s("md-textarea",{model:{value:t.post.text,callback:function(e){t.$set(t.post,"text",e)},expression:"post.text"}})],1)],1)],1),t._v(" "),s("md-snackbar",{attrs:{"md-position":"center","md-duration":4e3,"md-active":t.snackbar,"md-persistent":""},on:{"update:mdActive":function(e){t.snackbar=e}}},[s("span",[t._v("The post is saved successfully!")])])],1)},staticRenderFns:[]};var f=s("VU/8")(v,h,!1,function(t){s("z135")},"data-v-289bebb4",null).exports;a.default.use(r.a);var _=new r.a({routes:[{path:"/",name:"feed",component:m},{path:"/edit",name:"editPost",component:f},{path:"/add",name:"addPost",component:f}]}),b=s("Lgyv"),C=s.n(b);s("4+hh"),s("giDI");a.default.config.productionTip=!1,a.default.use(C.a),new a.default({el:"#app",router:_,components:{App:o},template:"<App/>"})},giDI:function(t,e){},z135:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.5ada52a617fd7cbde185.js.map