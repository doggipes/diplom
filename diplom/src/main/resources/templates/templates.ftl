<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Create tasks from templates</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>

<body>
<header>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container-fluid">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="/api/v1/tasks">Tasks</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/api/v1/projects">Projects</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/api/v1/template/create">Templates</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<form method="post" th:action="/api/v1/template/{template_id}">
    <p><select name="template_id">
            <#list templates as template>
                <option value=${template.id}>${template.name}</option>
            </#list>
        </select></p>
    <p><input type="submit" value="Отправить"></p>
</form>


</body>

</html>