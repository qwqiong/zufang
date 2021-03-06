<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item" style="display:none">
                <div class="layui-input-inline">
                    <input type="text" value="${houseTenant.id}" id="id" name="id" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="customName" class="layui-form-label">租户姓名</label>
                <div class="layui-input-inline">
                    <input type="text" id="customName" name="customName" value="${houseTenant.customName}" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="idNo" class="layui-form-label">身份证号</label>
                <div class="layui-input-inline">
                    <input type="text" id="idNo" name="idNo" value="${houseTenant.idNo}" required="" autocomplete="off"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="mobileNo" class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="mobileNo" name="mobileNo" value="${houseTenant.mobileNo}" required="" autocomplete="off"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="rentPrice" class="layui-form-label">承租价</label>
                <div class="layui-input-inline">
                    <input type="text" id="rentPrice" name="rentPrice" value="${houseTenant.rentPrice}" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="rentStartDate" class="layui-form-label">起租日期</label>
                <div class="layui-input-inline layui-show-xs-block">
                    <input type="date" class="layui-input" lay-verify="required" lay-reqtext="起租日期不能为空!" name="rentStartDate" id="rentStartDate" value="${houseTenant.rentStartDate}"></div>
            </div>
            <div class="layui-form-item">
                <label for="rentEndDate" class="layui-form-label">截止日期</label>
                <div class="layui-input-inline layui-show-xs-block">
                    <input type="date" class="layui-input" lay-verify="required" lay-reqtext="截止日期不能为空!" name="rentEndDate" id="rentEndDate" value="${houseTenant.rentEndDate}"></div>
            </div>
            <div class="layui-form-item">
                <label for="payDate" class="layui-form-label">交款日期</label>
                <div class="layui-input-inline layui-show-xs-block">
                    <input type="date" class="layui-input"  name="payDate" id="payDate" value="${houseTenant.payDate}"></div>
            </div>
            <div class="layui-form-item">
                <label for="comment" class="layui-form-label">备注</label>
                <div class="layui-input-inline layui-show-xs-block">
                    <input type="text" class="layui-input" name="comment" id="comment" value="${houseTenant.comment}"></div>
            </div>
            <div class="layui-form-item">
                <label for="addHouseTenant" class="layui-form-label"></label>
                <button class="layui-btn" id="addHouseTenant" lay-filter="add" lay-submit="">修改</button>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer', 'jquery','laydate'],
    function () {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //监听提交
        form.on('submit(add)',
            function (data) {
                $.post("/houseTenant/add", data.field, function (res) {
                    console.log(res);
                });
                layer.alert("修改成功", {
                        icon: 6
                    },
                    function () {
                        //关闭当前frame
                        xadmin.close();

                        // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    });
                return false;
            });

    });</script>
</body>

</html>