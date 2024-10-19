const base = {
    get() {
        return {
            url : "http://localhost:8080/yiliaoguahao/",
            name: "yiliaoguahao",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiliaoguahao/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "医疗挂号管理系统"
        } 
    }
}
export default base
