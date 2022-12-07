/* 表单验证 */
window.onload = function () {
    // 获取表单
    let Form = document.querySelector(".profile");
    // 获取form中的输入表单
    let realnameInput = document.querySelector(".realname");
    let phoneInput = document.querySelector(".phone");
    let addressInput = document.querySelector(".address");

    // 获取表单输入的值
    let realname = null;
    let phone = null;
    let address = null;

    // 是否提交表单的标识
    let realnameFlag = true;
    let phoneFlag = true;
    let addressFlag = true;

    // 表单失去焦点验证
    realnameInput.onblur = function () {
        realname = document.querySelector(".realname").value;
        if (!isEmpty(realname)) {
            // 去除昵称中的空格
            if (/^[A-Za-z\u4e00-\u9fa5]+$/.test(realname)) {
                realnameFlag = true;
            } else {
                realnameFlag = false;
                alert("名字格式不合法，名字只能输入中文或英文，请重新输入");
            }
            if (realname.length < 2) {
                realnameFlag = false;
                alert("姓名长度不能少于2个字符，请重新输入");
            } else if (realname.length > 4) {
                realnameFlag = false;
                alert("姓名长度不能超过4个字符，请重新输入");
            } else {
                realnameFlag = true;
            }
        };
    }

    phoneInput.onblur = function () {
        phone = document.querySelector(".phone").value;
        if (!isEmpty(phone)) {
            if (!(/^1[3-9][0-9]{9}$/.test(phone))) {
                phoneFlag = false;
                alert("手机号码格式不合法：只能输入数字，且长度为11位，请重新输入");
            } else {
                phoneFlag = true;
            }
        }
    };

    addressInput.onblur = function () {
        address = document.querySelector(".address").value;
        if (!isEmpty(address)) {
            if (!(/^[A-Za-z0-9\u4e00-\u9fa5]+$/.test(address))) {
                addressFlag = false;
                alert("收件地址不合法，请重新输入");
            } else {
                addressFlag = true;
            }
        }
    };

    // 表单提交验证
    Form.onsubmit = function () {
        // 验证是否为空
        if (isEmpty(realname)) {
            realnameFlag = false;
            alert('收件人不能为空');
            return realnameFlag;
        }
        if (isEmpty(phone)) {
            phoneFlag = false;
            alert('手机号不能为空');
            return phoneFlag;
        }
        if(isEmpty(address)){
            addressFlag = false;
            alert('地址不能为空');
            return addressFlag;
        }
        if(realnameFlag&&phoneFlag&&addressFlag){
            return true;
        }else {
            alert("填写的数据格式有误，请重新输入");
            return false;
        }
    }
};
// 判断字符串是否为空
function isEmpty(value) {
    if (value === null || value === "" || value.length === 0) {
        return true;
    }
    return false;
}