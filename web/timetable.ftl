<html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <title>Schedule</title>
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
<h5 class="text-center">${prof.fio}</h5>
<table class="table" width="70%" align="center" border="5">
    <tr>
        <th>Day</th>
        <th>8.30-10.00</th>
        <th>10.10-11.40</th>
        <th>11.50-13.20</th>
        <th>13.35-15.05</th>
        <th>15.20-16.50</th>
        <th>17.00-18.30</th>
    </tr>
    </div>

    <tr>
        <th>Monday</th>
            <#if monday_1 ??>
                <td>${monday_1}</td><#else><td>-</td></#if>
            <#if monday_2 ??>
                <td>${monday_2}</td><#else><td>-</td></#if>
            <#if monday_3 ??>
                <td>${monday_3}</td><#else><td>-</td>
            </#if>
            <#if monday_4 ??>
                <td>${monday_4}</td><#else><td>-</td>
            </#if>
            <#if monday_5 ??>
                <td>${monday_5}</td><#else><td>-</td>
            </#if>
            <#if monday_6 ??>
                <td>${monday_6}</td><#else><td>-</td>
            </#if>
    </tr>

    <tr>
        <th>Tuesday</th>
    <#if tuesday_1 ??>
        <td>${tuesday_1}</td><#else><td>-</td></#if>
    <#if tuesday_2 ??>
        <td>${tuesday_2}</td><#else><td>-</td></#if>
    <#if tuesday_3 ??>
        <td>${tuesday_3}</td><#else><td>-</td>
    </#if>
    <#if tuesday_4 ??>
        <td>${tuesday_4}</td><#else><td>-</td>
    </#if>
    <#if tuesday_5 ??>
        <td>${tuesday_5}</td><#else><td>-</td>
    </#if>
    <#if tuesday_6 ??>
        <td>${tuesday_6}</td><#else><td>-</td>
    </#if>
    </tr>

    <tr>
        <th>Wednesday</th>
    <#if wednesday_1 ??>
        <td>${wednesday_1}</td><#else><td>-</td></#if>
    <#if wednesday_2 ??>
        <td>${wednesday_2}</td><#else><td>-</td></#if>
    <#if wednesday_3 ??>
        <td>${wednesday_3}</td><#else><td>-</td>
    </#if>
    <#if wednesday_4 ??>
        <td>${wednesday_4}</td><#else><td>-</td>
    </#if>
    <#if wednesday_5 ??>
        <td>${wednesday_5}</td><#else><td>-</td>
    </#if>
    <#if wednesday_6 ??>
        <td>${wednesday_6}</td><#else><td>-</td>
    </#if>
    </tr>

    <tr>
        <th>Thursday</th>
    <#if thursday_1 ??>
        <td>${thursday_1}</td><#else><td>-</td></#if>
    <#if thursday_2 ??>
        <td>${thursday_2}</td><#else><td>-</td></#if>
    <#if thursday_3 ??>
        <td>${thursday_3}</td><#else><td>-</td>
    </#if>
    <#if thursday_4 ??>
        <td>${thursday_4}</td><#else><td>-</td>
    </#if>
    <#if thursday_5 ??>
        <td>${thursday_5}</td><#else><td>-</td>
    </#if>
    <#if thursday_6 ??>
        <td>${thursday_6}</td><#else><td>-</td>
    </#if>
    </tr>

    <tr>
        <th>Friday</th>
    <#if friday_1 ??>
        <td>${friday_1}</td><#else><td>-</td></#if>
    <#if friday_2 ??>
        <td>${friday_2}</td><#else><td>-</td></#if>
    <#if friday_3 ??>
        <td>${friday_3}</td><#else><td>-</td>
    </#if>
    <#if friday_4 ??>
        <td>${friday_4}</td><#else><td>-</td>
    </#if>
    <#if friday_5 ??>
        <td>${friday_5}</td><#else><td>-</td>
    </#if>
    <#if friday_6 ??>
        <td>${friday_6}</td><#else><td>-</td>
    </#if>
    </tr>

    <tr>
        <th>Saturday</th>
    <#if saturday_1 ??>
        <td>${saturday_1}</td><#else><td>-</td></#if>
    <#if saturday_2 ??>
        <td>${saturday_2}</td><#else><td>-</td></#if>
    <#if saturday_3 ??>
        <td>${saturday_3}</td><#else><td>-</td>
    </#if>
    <#if saturday_4 ??>
        <td>${saturday_4}</td><#else><td>-</td>
    </#if>
    <#if saturday_5 ??>
        <td>${saturday_5}</td><#else><td>-</td>
    </#if>
    <#if saturday_6 ??>
        <td>${saturday_6}</td><#else><td>-</td>
    </#if>
    </tr>
</table>
<@security.authorize  access="hasRole('ROLE_ADMIN')">
<a class="btn-block btn" href="/admin/edit?id=${prof.id}">Add new lesson</a>
</@security.authorize>
</div>
</body>
</html>