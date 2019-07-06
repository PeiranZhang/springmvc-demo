<%--
  Created by IntelliJ IDEA.
  User: zhangpeiran
  Date: 2019/6/30
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Product</title>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
    <h5>Details:</h5>
    <%--
    Controller里面的Model中的product对象其实是作为request属性传递给jsp的，所以这里用requestScope来引用--%>
    Product Name: ${requestScope.product.name}<br/>
    Description: ${requestScope.product.description}<br/>
    Price: $${requestScope.product.price}
    </p>
</div>
</body>
</html>
