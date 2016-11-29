<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
  <form class="form-horizontal" action="loginprocessing" method="post">

    <div class="form-group">
      <label for="username">Login</label>
      <input id="username" type="text" class="form-control" name="username" placeholder="Login">
    </div>

    <div class="form-group">
      <label for="password">Password</label>
      <input id="password" type="password" class="form-control" name="password" placeholder="Password">
    </div>

    <button type="submit" class="btn btn-primary">Sign In</button>
  </form>
</div>
