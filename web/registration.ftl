<html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <title>Registration</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <form class="form-group" role="form" href="/registration" method="post">
        <h2 class="header-panel text-center">Registration</h2>
        <input id="login" type="text" class="form-control" placeholder="Login" name="user" oninput="checkLogin()" required autofocus>
        <input id="password" type="password" class="form-control" placeholder="password" name="password" required>
        <input  id="confirm" type="password" class="form-control" placeholder="confirmPassword" name="confirmPassword" required>
        <button class="btn btn-block">Registration</button>
    </form>

</div>
</body>
</html>