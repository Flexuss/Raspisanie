<html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <title>New lesson</title>
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
        <h2 class="header-panel text-center">Lesson</h2>
        <select class="form-control" name="day" id="day">
            <option selected>Day</option>
            <option value="1">Monday</option>
            <option value="2">Tuesday</option>
            <option value="3">Wednesday</option>
            <option value="4">Thursday</option>
            <option value="5">Friday</option>
            <option value="6">Saturday</option>
        </select>
        <select class="form-control" name="time" id="time">
            <option selected>Time</option>
            <option value="1">8.30-10.00</option>
            <option value="2">10.10-11.40</option>
            <option value="3">11.50-13.20</option>
            <option value="4">13.35-15.05</option>
            <option value="5">15.20-16.50</option>
            <option value="6">17.00-18.30</option>
        </select>
        <input id="aud" type="number" class="form-control" name="aud" placeholder="Auditory" required>
        <input id="theme" type="text" class="form-control" name="theme" placeholder="Theme" required>
        <button class="btn btn-block" type="submit">Save</button>
    </div>
    </form>
</div>
</body>
</html>