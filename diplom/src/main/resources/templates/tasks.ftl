<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Tasks</title>
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.css"
            rel="stylesheet"
    />
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
    <!-- Navbar -->
</header>
<div class="container py-5 h-100 col-4">
    <div class="input-group rounded">
        <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
        <span class="input-group-text border-0" id="search-addon">
    <i class="fas fa-search"></i>
  </span>
    </div>
        <#list projects as project>
            <h4 class="mt-5">PROJECT-${project.id}/${project.name}</h4>
            <div class="row row-cols-1 row-cols-md-3 g-4">
            <#list tasks as task>
            <#if task.project == project.id>
                <a href="<@spring.url '/api/v1/task/${task.taskId}'/>">
                        <div class="col">
                            <div class="card" style="height: 131px">
                                <div class="card-body">
                                    <h5 class="card-title">TASK-${task.taskId}</h5>
                                    <p class="card-text">
                                        ${task.name}
                                    </p>
                                </div>
                            </div>
                        </div>
                </a>
    <#--            <a href="<@spring.url '/api/v1/task/${task.taskId}'/>">${task.taskId} / ${task.name}</a>-->
            </#if>
        <#else>
        <p>No tasks
            </#list>
        </div>
        <#else>
        <p>No projects
            </#list>
</div>



<#--<#list projects as project>-->
<#--    <ul class="roman">-->
<#--        <li>${project.name}-->
<#--            <ul class="square">-->
<#--                <#list tasks as task>-->
<#--                    <li>-->
<#--                        <#if task.project == project.id>-->
<#--                            <a href="<@spring.url '/api/v1/task/${task.taskId}'/>">${task.taskId} / ${task.name}</a>-->
<#--                        </#if>-->
<#--                    </li>-->
<#--                <#else>-->
<#--                    <p>No tasks-->
<#--                </#list>-->
<#--            </ul>-->
<#--        </li>-->
<#--    </ul>-->
<#--<#else>-->
<#--    <p>No projects-->
<#--</#list>-->


</body>

</html>