<html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <title>New Schedule</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h4 class="text-center">Welcome ${userdet.getUsername()}</h4>
<a class="btn btn-block" href="/logout">Logout</a>
<a class="btn btn-block" href="/home">Home</a>
<@security.authorize  access="hasRole('ROLE_ADMIN')">
<a class="btn-block btn" href="/admin/addnew">Add new professor</a>
</@security.authorize>
<div class="container">
    <form method="post" class="form-group" href="/admin/addnew">
    <div class="form-group">
        <h2 class="header-panel text-center">Professor</h2>
        <input id="city" type="text" class="form-control" name="city" placeholder="City" required autofocus>
        <input id="university" type="text" class="form-control" name="university" placeholder="Univercity" required>
        <input id="faculty" type="text" class="form-control" name="faculty" placeholder="Faculty" required>
        <input id="professor" type="text" class="form-control" name="professor" placeholder="Professors Name" required>
        <input id="professorAge" type="number" class="form-control" name="professorAge" placeholder="Professors Age" required>
        <input id="professorExp" type="number" class="form-control" name="professorExp" placeholder="Professors Experience" required>
        <input id="professorTheme" type="text" class="form-control" name="professorTheme" placeholder="Professors Theme" required>
        <input id="ProfessorReg" type="text" class="form-control" name="professorRegalia" placeholder="Professors Regalia" required>
        <button class="btn btn-block" type="submit">Save</button>
    </div>
    </form>
</div>
</body>
</html>