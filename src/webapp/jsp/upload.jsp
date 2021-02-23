<%--
  Created by IntelliJ IDEA.
  User: ldx
  Date: 2019/12/27
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Excel文件上传</title>
    <script src="https://cdn.bootcss.com/vue/2.4.2/vue.min.js"></script>
</head>
<body>
<h1>文件上传实例</h1>
<div id="app">
    <div v-html="msg1"></div>
    <input type="button" :value="bname" v-on:click="show" v-bind:title="msg3">
</div>
<form method="post" action="/upload" enctype="multipart/form-data">
    选择一个文件：
    <input type="file" name="uploadFile" />
    <br/>
    <br/>
    <input type="submit" value="上传" />
</form>


</body>
</html>
