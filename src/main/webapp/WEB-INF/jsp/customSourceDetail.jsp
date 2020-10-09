<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
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
                    <input type="text" value="${customSource.id}" id="id" name="id" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="customName" class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" id="customName" name="customName" value="${customSource.customName}" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="requireType" class="layui-form-label">需求户型</label>
                <div class="layui-input-inline">
                    <input type="text" id="requireType" name="requireType" value="${customSource.requireType}" required="" autocomplete="off"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="requirePrice" class="layui-form-label">需求价位</label>
                <div class="layui-input-inline">
                    <input type="text" id="requirePrice" name="requirePrice" value="${customSource.requirePrice}" required="" autocomplete="off"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="mobileNo" class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="mobileNo" name="mobileNo" value="${customSource.mobileNo}" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="visitTime" class="layui-form-label">看房时间</label>
                <div class="layui-input-inline layui-show-xs-block">
                    <input type="date" class="layui-input" placeholder="看房时间" value="${customSource.visitTime}" name="visitTime" id="visitTime"></div>
            </div>
            <div class="layui-form-item">
                <label for="inTime" class="layui-form-label">入住时间</label>
                <div class="layui-input-inline layui-show-xs-block">
                    <input type="date" class="layui-input" placeholder="入住时间" name="inTime" value="${customSource.inTime}" id="inTime"></div>
            </div>
            <div class="layui-form-item">
                <label for="comment" class="layui-form-label">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="comment" name="comment" value="${customSource.comment}" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="customSourceAdd" class="layui-form-label"></label>
                <button class="layui-btn" id="customSourceAdd" lay-filter="add" lay-submit="">增加</button>
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
                $.post("/customSource/add", data.field, function (res) {
                    console.log(res);
                });
                layer.alert("增加成功", {
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