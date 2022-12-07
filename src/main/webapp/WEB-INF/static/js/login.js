/* 注册验证 */
window.onload = function () {
    // 获取表单
    let registerForm = document.querySelector(".login-form");
    // 获取form中的输入表单
    let userNameInput = document.querySelector(".userName");
    let passwordInput = document.querySelector(".password");
    // 获取表单输入的值
    let userName = null;
    let password = null;

    // 是否提交表单的标识
    let userNameFlag = true;
    let passwordFlag = true;

    // 表单失去焦点验证
    userNameInput.onblur = function () {
        userName = document.querySelector(".userName").value;
        if (!isEmpty(userName)) {
            // 去除昵称中的空格
            if (/\s/.test(userName)) {
                userName = userName.replace(/\s/g, '');
                userNameInput.value = userName;
            }
            if (!(userName.length >= 1 && userName.length <= 10)) {
                userNameFlag = false;
                alert("用户名长度不合法,长度只能在：【1 ~ 10】之间");
            }else {
                userNameFlag = true;
            }
            // 验证昵称字符是否合法
            if (!(/^[A-Za-z0-9\u4e00-\u9fa5]+$/.test(userName))) {
                userNameFlag = false;
                alert('用户名只能使用中文、英文或数字');
            }else {
                userNameFlag = true;
            }
        }
    };
    passwordInput.onblur = function () {
        password = document.querySelector(".password").value;
        if (!isEmpty(password)) {
            // 去除密码中的空格
            if (/\s/g.test(password)) {
                password = password.replace(/\s/g, '');
                passwordInput.value = password;
            }
            // 必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 6-10 之间
            if (!(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,10}$/.test(password))) {
                passwordFlag = false;
                alert("密码格式错误：必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 6-10 之间");
            }else {
                passwordFlag = true;
            }
        }

    };


    // 表单提交验证
    registerForm.onsubmit = function () {
        // 验证是否为空
        if (isEmpty(userName)) {
            userNameFlag = false;
            alert('用户名不能为空');
            return userNameFlag;
        }
        if (isEmpty(password)) {
            passwordFlag = false;
            alert('密码不能为空');
            return passwordFlag;
        }
        if(userNameFlag && passwordFlag){
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
