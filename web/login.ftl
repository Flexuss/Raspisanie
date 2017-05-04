<html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <title>Login</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <form method="post" class="form-group" href="/login/process">
    <div class="form-group">
        <h2 class="header-panel text-center">Login</h2>
        <#if error ??><h4 class="text-center">${error}</h4></#if>
        <#if message ??><h4 class="text-center">${message}</h4></#if>
    <input id="username" type="text" class="form-control" placeholder="Login" name="username" required autofocus>
    <input id="password" type="password" class="form-control" placeholder="Password" name="password" required>
    <button class="btn btn-block" type="submit">Login</button>
    <h4 class="text-center"><a href="/registration">Create an account</a></h4>
    </div>
    </form>
</div>
</body>
</html>