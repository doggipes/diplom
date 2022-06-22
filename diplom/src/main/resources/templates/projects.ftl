<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Projects</title>
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
    <form action="/api/v1/project/create">
        <button type="submit" class="btn btn-outline-secondary btn-rounded" data-mdb-ripple-color="dark">Create project</button>
    </form>
<#--    <#list projects as project>-->
<#--    <h4 class="mt-5">💼 PROJECT-${project.id}/${project.name}</h4>-->
<#--    <div class="row">-->
<#--        <#list projects as project>-->
<#--        <div class="col-xl-4 col-lg-6 mb-4">-->
<#--            <div class="card">-->
<#--                <div class="card-body">-->
<#--                    <div class="d-flex align-items-center">-->
<#--                        <div class="ms-3">-->
<#--                            <h4 class="mt-5">💼 PROJECT-${project.id}/${project.name}</h4>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
<#--        <#else>-->
<#--            <h4 class="mt-5">No projects</h4>-->
<#--        </#list>-->
<#--        </div>-->
    <ul class="list-group list-group-light">
        <#list projects as project>
        <li class="list-group-item d-flex justify-content-between align-items-center">
            <a href="<@spring.url '/api/v1/project/${project.id}'/>">
            <h4 class="mt-5">💼 PROJECT-${project.id}/${project.name}</h4>
            </a>
            <span class="badge badge-primary rounded-pill">${project.tasks?size}</span>
        </li>
        <#else>
            <h4 class="mt-5">No projects</h4>
        </#list>
    </ul>
<#--    <div class="row row-cols-1 row-cols-md-3 g-4">-->
<#--        <#list tasks as task>-->
<#--        <#if task.project == project.id>-->
<#--            <a href="<@spring.url '/api/v1/task/${task.taskId}'/>">-->
<#--                <div class="col">-->
<#--                    <div class="card" style="height: 131px">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">TASK-${task.taskId}</h5>-->
<#--                            <p class="card-text">-->
<#--                                ${task.name}-->
<#--                            </p>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </a>-->
<#--        &lt;#&ndash;            <a href="<@spring.url '/api/v1/task/${task.taskId}'/>">${task.taskId} / ${task.name}</a>&ndash;&gt;-->
<#--        </#if>-->
<#--        <#else>-->
<#--        <p>No tasks-->
<#--            </#list>-->
<#--    </div>-->
<#--</div>-->



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