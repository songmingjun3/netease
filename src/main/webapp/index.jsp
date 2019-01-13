<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
stringmvc上传文件
<form name="form1" action="/seller/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="上传文件" />
</form>
</body>
</html>
