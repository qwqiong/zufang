<%--
  Created by IntelliJ IDEA.
  User: qwqiong
  Date: 2020/10/6
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <div class="layui-card-header layui-form-pane">
			            <div class="layui-form-item">
						    <div class="layui-inline">
						      <label class="layui-form-label">小区</label>
						      <div class="layui-input-block">
						        <input type="text" id="village" name="village" value="${houseSource.village}" id="date1" autocomplete="off" class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <label class="layui-form-label">居室</label>
						      <div class="layui-input-inline">
						        <input type="text" id="zoneCount" name="zoneCount" autocomplete="off" class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <label class="layui-form-label">楼号</label>
						      <div class="layui-input-inline">
						        <input type="text" id="buildingNo" name="buildingNo" value="${houseSource.buildingNo}" autocomplete="off" class="layui-input">
						      </div>
						    </div>
						    
						    <div class="layui-inline">
						       	 <button class="layui-btn" onclick="queryList()"><i
	                                class="layui-icon"></i>查询
	                        	 </button>
						    </div>
						  </div>
				            
                    </div>
                    <div class="layui-card-header">
                        <button class="layui-btn" onclick="xadmin.open('添加房源','/houseAdd.html',500,500)"><i
                                class="layui-icon"></i>添加
                        </button>
                    </div>
                    <div class="layui-card-body layui-table-body layui-table-main" id="houseSourceItem">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    layui.use(['laydate', 'form', 'jquery'], function () {
        var laydate = layui.laydate;
        var form = layui.form;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-删除*/
    function itemDel(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.post("/houseSource/delete", {"id": id}, function (response) {
                layer.msg('已删除!', {icon: 1, time: 1000});
                // 可以对父窗口进行刷新
                xadmin.father_reload();
            })
        });
    }
    
    /*查询操作*/
    function queryList(){
    	var village =$("#village").val();
    	var zoneCount =$("#zoneCount").val();
    	var buildingNo =$("#buildingNo").val();
    	$.post("/houseSource/items", {"village": village,"zoneCount": zoneCount,"buildingNo": buildingNo}, function (resonse) {
    		 $("#houseSourceItem").html(resonse);
        })
    }

    $(document).ready(function () {
        $.post("/houseSource/items", function (resonse) {
            $("#houseSourceItem").html(resonse);
        })
    })
</script>
</html>
