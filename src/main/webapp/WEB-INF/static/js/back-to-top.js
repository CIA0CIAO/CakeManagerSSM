// ��ȡ��ǰ�ӿڵĴ�С
var viewHeight = document.documentElement.clientHeight/4;
//С�����ӵ����¼�
document.querySelector(".back-to-top").addEventListener("click", () => {
    //С���������,�ص�����
    // document.documentElement.scrollTop = 0;
    //��Ȼ,Ҳ���������ص�����
    slowToTop();
})
//��Ȼ,����ʹ�ý��������
window.onscroll = function () {
    if (document.documentElement.scrollTop >= viewHeight) {
        //��ʾС���Ԫ��
        document.querySelector(".back-to-top").style.display = "block";
    } else {
        //����С���
        document.querySelector(".back-to-top").style.display = "none";
    }
}
window.onresize = function () {
    viewHeight = document.documentElement.clientHeight;
}
/* �����ص����� */
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
