/* 表单验证 */
window.onload = function () {
    // 获取表单
    let Form = document.querySelector(".separate-form");
    // 获取form中的输入表单
    let pnameInput = document.querySelector(".pname");
    let priceInput = document.querySelector(".price");
    let numberInput = document.querySelector(".number");

    // 获取表单输入的值
    let pname = null;
    let price = null;
    let number = null;

    // 是否提交表单的标识
    let pnameFlag = true;
    let priceFlag = true;
    let numberFlag = true;

    // 表单失去焦点验证
    pnameInput.onblur = function () {
        pname = document.querySelector(".pname").value;
        if (!isEmpty(pname)) {
            // 去除昵称中的空格
            if (/^[A-Za-z\u4e00-\u9fa5]+$/.test(pname)) {
                pnameFlag = true;
            } else {
                pnameFlag = false;
                alert("商品名称格式不合法，名字只能输入中文或英文，请重新输入");
            }
        };
    }

    priceInput.onblur = function () {
        price = document.querySelector(".price").value;
        if (!isEmpty(price)) {
            if (!( /^\d+$|^\d+[.]?\d+$/.test(price))) {
                priceFlag = false;
                alert("价格格式不合法：只能输入数字，请重新输入");
            } else {
                priceFlag = true;
            }
        }
    };

    numberInput.onblur = function () {
        number = document.querySelector(".number").value;
        if (!isEmpty(number)) {
            if (!( /^\d+$|^\d+[.]?\d+$/.test(number))) {
                numberFlag = false;
                alert("数量格式不合法：只能输入数字，请重新输入");
            } else {
                numberFlag = true;
            }
        }
    };

    // 表单提交验证
    Form.onsubmit = function () {
        // 验证是否为空
        if (isEmpty(pname)) {
            pnameFlag = false;
            alert('商品名称不能为空');
            return pnameFlag;
        }
        if (isEmpty(price)) {
            priceFlag = false;
            alert('商品价格不能为空');
            return priceFlag;
        }
        if(isEmpty(number)){
            numberFlag = false;
            alert('商品数量不能为空');
            return numberFlag;
        }
        if(pnameFlag&&priceFlag&&numberFlag){
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