<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/css/layui.css"  media="all">
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
						      <label class="layui-form-label">起租开始</label>
						      <div class="layui-input-block">
						        <input type="text" name="rentStartDate" id="rentStartDate" value="${delegateHouse.rentStartDate}" autocomplete="off" class="layui-input">
						      </div>
						    </div>
						    <div class="layui-inline">
						      <label class="layui-form-label">起租截止</label>
						      <div class="layui-input-inline">
						        <input type="text" name="rentEndDate" id="rentEndDate" value="${delegateHouse.rentEndDate}" autocomplete="off" class="layui-input">
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
                        <button class="layui-btn" onclick="xadmin.open('添加委托房源','/delegateHouseAdd.html',500,500)"><i
                                class="layui-icon"></i>添加
                        </button>
                    </div>
                    <div class="layui-card-body layui-table-body layui-table-main" id="delegateHouseItem">

                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    /*用户-删除*/
    function itemDel(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.post("/delegateHouse/delete", {"id": id}, function (response) {
                layer.msg('已删除!', {icon: 1, time: 1000});
                // 可以对父窗口进行刷新
                xadmin.father_reload();
            })
        });
    }

    $(document).ready(function () {
        $.post("/delegateHouse/items", function (resonse) {
            $("#delegateHouseItem").html(resonse);
        })
    })
    
    layui.use('laydate', function(){
  		  var laydate = layui.laydate;
	  	  //常规用法
		  laydate.render({
		    elem: '#rentStartDate'
		  });
	  	  
		  laydate.render({
		    elem: '#rentEndDate'
		  });
    });
    
    /*查询操作*/
    function queryList(){
    	var rentStartDate =$("#rentStartDate").val();
    	var rentEndDate =$("#rentEndDate").val();
    	$.post("/delegateHouse/items", {"rentStartDate":rentStartDate,"rentEndDate":rentEndDate}, function (resonse) {
    		 $("#delegateHouseItem").html(resonse);
        })
    }
</script>
