<html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <title>Home</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
<h4 class="text-center">Welcome ${userdet.getUsername()}</h4>
<a class="btn btn-block" href="/logout">Logout</a>
    <a class="btn btn-block" href="/home">Home</a>
<@security.authorize  access="hasRole('ROLE_ADMIN')">
    <a class="btn-block btn" href="/admin/addnew">Add new professor</a>
</@security.authorize>
<ul class="list-group">
    <h4 class="text-center header-panel">Cities</h4>
<#list cities as c>
    <li class="text-center list-group-item"><a class="text-center" href="/search/university?id=${c.id}">${c.cityName}</a></li>
</#list>
</ul>
</div>
</body>
</html>