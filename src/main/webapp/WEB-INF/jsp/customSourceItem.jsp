<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="layui-table layui-form">
    <thead>
    <tr>
        <th>姓名</th>
        <th>户型</th>
        <th>位置</th>
        <th>入住时间</th>
        <th>价位</th>
        <th>电话</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.customName}</td>
            <td>${item.requireType}</td>
            <td>${item.requireAddr}</td>
            <td>${item.inTime}</td>
            <td>${item.requirePrice}</td>
            <td>${item.mobileNo}</td>
            <td>${item.comment}</td>
            <td class="td-manage">
                <a title="删除" onclick="itemDel(this,'${item.id}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
                <a title="编辑"  onclick="xadmin.open('编辑房源','/customSource/detail?id=${item.id}',500,500)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


