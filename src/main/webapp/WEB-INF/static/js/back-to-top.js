// 获取当前视口的大小
var viewHeight = document.documentElement.clientHeight/4;
//小火箭添加单击事件
document.querySelector(".back-to-top").addEventListener("click", () => {
    //小火箭被单击,回到顶部
    // document.documentElement.scrollTop = 0;
    //当然,也可以慢慢回到顶部
    slowToTop();
})
//当然,这里使用节流会更好
window.onscroll = function () {
    if (document.documentElement.scrollTop >= viewHeight) {
        //显示小火箭元素
        document.querySelector(".back-to-top").style.display = "block";
    } else {
        //隐藏小火箭
        document.querySelector(".back-to-top").style.display = "none";
    }
}
window.onresize = function () {
    viewHeight = document.documentElement.clientHeight;
}
/* 缓慢回到顶部 */
function slowToTop() {
    setTimeout(() => {
        let value = document.documentElement.scrollTop;
        if(value<=0){
            document.documentElement.scrollTop = 0;
        }else{
            document.documentElement.scrollTop -= 40;
            slowToTop();
        }
    }, 1000/50);
}
