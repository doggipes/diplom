<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>${task.project.name}-${task.id}</title>
<#--    <link rel="stylesheet"-->
<#--          type="text/css"-->
<#--          href="<@spring.url '/css/style.css'/>"/>-->
    <!-- Font Awesome -->
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
<div style="padding-left:50px; padding-top:30px;">
    <a href="/api/v1/tasks" class="btn btn-outline-primary btn-rounded" data-mdb-ripple-color="dark">To tasks</a>
</div>
<div class="row border-top" style="margin-top:40px;">
    <div class="col-md-8" style="padding-left:200px;">
        <div class="pb-3">
            <div class="d-flex align-items-start flex-column mb-3" style="height: 200px;">
                <div class="p-2"><h2>📝 TASK-${task.id}</h2></div>
                <div class="p-2">Project: </div>
                <div class="p-2">${task.project.id}</div>
                <div class="p-2">Name: </div>
                <div class="p-2">${task.name}</div>
                <div class="ms-auto p-2 badge badge-primary rounded-pill">
                    <form method="post" action="" name="status">
                    <select class="form-select" aria-label="Default select example" name="status" onchange="this.form.submit();">
                        <option value="0">${task.status}</option>
                        <option value="IN_PROGRESS">IN_PROGRESS</option>
                        <option value="DONE">DONE</option>
                    </select>
                        </form>
                </div>
            </div>
        </div>
        <div class="pb-3 border-top" style="margin-top:60px;">
            <div class="p-2">Description:</div>
            <div class="p-2">${task.description}</div>
        </div>
        <div class="pb-3 border-top" style="padding-top: 10px">
            <div class="p-2">Sub tasks</div>
            <#list task.subTask as subTask>
            <ol class="list-group list-group-light list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">TASK-${subTask.id}</div>
                        ${subTask.name}
                    </div>
                    <span class="badge badge-primary rounded-pill">${subTask.status}</span>
                </li>
            </ol>
            <#else>
            <div class="p-2">No sub tasks</div>
            </#list>
            <div class="p-2">Next tasks</div>
                <#list task.nextTask as nextTask>
            <ol class="list-group list-group-light list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">TASK-${nextTask.id}</div>
                        ${nextTask.name}
                    </div>
                    <span class="badge badge-primary rounded-pill">${nextTask.status}</span>
                </li>
            </ol>
            <#else>
            <div class="p-2">No next tasks</div>
            </#list>
        </div>
    </div>
    <div class="col-md-4 border-top">
        <div class="d-flex align-items-center" style="margin-top:30px;">
            <div class="p-2">Assignee</div>
            <img src="http://cdn.onlinewebfonts.com/svg/img_415638.png" alt="" style="width: 45px; height: 45px"
                 class="rounded-circle" />
            <select class="form-select" aria-label="Default select example" name="userId">
                <#if (task.assignee)??>
                <option value="0">${task.assignee.lastname} ${task.assignee.firstname}</option>
                </#if>
                <option value="0">No user</option>
                <#list users as user>
                    <#if user.firstname != "Администратор">
                    <option value="${user.userId}">${user.lastname} ${user.firstname}</option>
                    </#if>
                </#list>
            </select>
        </div>
        <div class="d-flex align-items-center" style="margin-top:10px;">
            <div class="p-2">Reporter</div>
            <img src="http://cdn.onlinewebfonts.com/svg/img_415638.png" alt="" style="width: 45px; height: 45px"
                 class="rounded-circle" />
            <select class="form-select" aria-label="Default select example" name="userId">
                <#if (task.reporter)??>
                <option value="0">${task.reporter.lastname} ${task.reporter.firstname}</option>
                </#if>
                <option value="0">No user</option>
                <#list users as user>
                    <#if user.firstname != "Администратор">
                    <option value="${user.userId}">${user.lastname} ${user.firstname}</option>
                    </#if>
                </#list>
            </select>
        </div>
        <div class="d-flex align-items-center border-top" style="margin-top:30px; padding-top: 30px">
            <div class="p-2">Date start</div>
            <div class="ms-3">
                <p class="fw-bold mb-1">${task.dateStart}</p>
            </div>
        </div>
        <div class="d-flex align-items-center" style="margin-top:10px;">
            <div class="p-2">Date end</div>
            <div class="ms-3">
                <p class="fw-bold mb-1">${task.dateEnd}</p>
            </div>
        </div>
    </div>
</div>


</body>

</html>