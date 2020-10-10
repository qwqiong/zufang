<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
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
                    <input type="text" value="${houseSource.id}" id="id" name="id" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="village" class="layui-form-label">小区</label>
                <div class="layui-input-inline">
                    <input type="text" value="${houseSource.village}" id="village" name="village" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="zoneCount" class="layui-form-label">居室</label>
                <div class="layui-input-inline">
                    <input type="text" id="zoneCount" value="${houseSource.zoneCount}" name="zoneCount" required="" autocomplete="off"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="buildingNo" class="layui-form-label">楼号</label>
                <div class="layui-input-inline">
                    <input type="text" id="buildingNo" value="${houseSource.buildingNo}" name="buildingNo" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="housePrice" class="layui-form-label">价格</label>
                <div class="layui-input-inline">
                    <input type="text" id="housePrice" value="${houseSource.housePrice}" name="housePrice" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orientation" class="layui-form-label">朝向</label>
                <div class="layui-input-inline">
                    <input type="text" id="orientation" value="${houseSource.orientation}" name="orientation" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="mobileNo" class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="mobileNo" value="${houseSource.mobileNo}" name="mobileNo" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="comment" class="layui-form-label">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="comment" value="${houseSource.comment}" name="comment" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="addHouse" class="layui-form-label"></label>
                <button class="layui-btn" id="addHouse" lay-filter="add" lay-submit="">修改</button>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer', 'jquery'],
    function () {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)',
            function (data) {
                $.post("/houseSource/add", data.field, function (res) {
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
