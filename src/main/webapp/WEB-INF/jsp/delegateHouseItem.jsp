<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="layui-table layui-form">
    <thead>
    <tr>
        <th>委托价</th>
        <th>打款日</th>
        <th>起租期</th>
        <th>截止日期</th>
        <th>配送成本</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.delegatePrice}</td>
            <td>${item.payDate}</td>
            <td>${item.rentStartDate}</td>
            <td>${item.rentEndDate}</td>
            <td>${item.deliveryPrice}</td>
            <td>${item.comment}</td>
            <td class="td-manage">
                <a title="删除" onclick="itemDel(this,'${item.id}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
                <a title="编辑"  onclick="xadmin.open('编辑房源','/delegateHouse/detail?id=${item.id}',500,500)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>