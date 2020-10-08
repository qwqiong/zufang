<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="layui-table layui-form">
    <thead>
    <tr>
        <th>小区</th>
        <th>居室</th>
        <th>楼号</th>
        <th>价格</th>
        <th>朝向</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.village}</td>
            <td>${item.zoneCount}</td>
            <td>${item.buildingNo}</td>
            <td>${item.housePrice}</td>
            <td>${item.orientation}</td>
            <td>${item.mobileNo}</td>
            <td class="td-manage">
                <a title="删除" onclick="itemDel(this,'${item.id}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
                <a title="编辑"  onclick="xadmin.open('编辑房源','/houseSource/detail?id=${item.id}',500,500)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


