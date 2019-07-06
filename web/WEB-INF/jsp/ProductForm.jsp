<%--
  Created by IntelliJ IDEA.
  User: zhangpeiran
  Date: 2019/6/30
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
<!--product_save与product_save.action效果一样-->
<div id="global">
    <form action="product_save.action" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name"
                       tabindex="1">
            </p>
            <p>
                <label for="description1">Description: </label>
                <input type="text" id="description1"
                       name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price"
                       tabindex="3">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
