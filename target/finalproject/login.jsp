<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/menu.htm" %>

<form class="form-horizontal"action = "do?command=login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Form Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinputMail">Mail</label>
  <div class="col-md-4">
  <input id="textinputMail" name="textinputMail" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password </label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">no less than 8 characters</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="LoginButton"></label>
  <div class="col-md-4">
    <button id="LoginButton" name="LoginButton" class="btn btn-success">Login</button>
  </div>
</div>

</fieldset>
</form>


<!-- <p>Cmd Sign-up: ${message}</p>-->
<%@ include file="include/head.htm" %>
</html>

