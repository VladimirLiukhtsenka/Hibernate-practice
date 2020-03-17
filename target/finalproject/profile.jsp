<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/menu.htm" %>
<body>

<p>Cmd Profile: Добро пожаловать! ${user}</p>
<form class="form-horizontal" action = "do?command=profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Exit</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout">Single Button</label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>
</fieldset>
</form>
<%@ include file="include/head.htm" %>
</body>
</html>