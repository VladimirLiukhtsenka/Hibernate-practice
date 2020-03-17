<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/menu.htm" %>

<form class="form-horizontal"action = "do?command=signup" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Form SignUp</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="surname">Surname</label>
  <div class="col-md-4">
  <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="father name">Father name</label>
  <div class="col-md-4">
  <input id="father name" name="father name" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasicGender">Gender</label>
  <div class="col-md-4">
    <select id="selectbasicGender" name="selectbasicGender" class="form-control">
      <option value="1">male</option>
      <option value="2">female</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinputMail">Mail</label>
  <div class="col-md-4">
  <input id="textinputMail" name="textinputMail" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Phone</label>
  <div class="col-md-4">
  <input id="phone" name="phone" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">for example +375251234567</span>
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
  <label class="col-md-4 control-label" for="submitButton"></label>
  <div class="col-md-4">
    <button id="submitButton" name="submitButton" class="btn btn-success">Signup</button>
  </div>
</div>

</fieldset>
</form>


<!-- <p>Cmd Sign-up: ${message}</p>-->
<%@ include file="include/head.htm" %>
</html>




