<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>${project.name}</title>
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
    <a href="/api/v1/projects" class="btn btn-outline-primary btn-rounded" data-mdb-ripple-color="dark">To projects</a>
</div>
<div class="row border-top" style="margin-top:40px;">
    <div class="col-md-8" style="padding-left:200px;">
        <div class="pb-3">
            <div class="d-flex align-items-start flex-column mb-3" style="height: 200px;">
                <div class="p-2"><h2>📝 PROJECT-${project.id}</h2></div>
                <div class="p-2">Name: </div>
                <div class="p-2">${project.name}</div>
            </div>
        </div>
        <div class="pb-3 border-top" style="margin-top:60px;">
            <div class="p-2">Description:</div>
            <div class="p-2">${project.description}</div>
        </div>
        <div class="pb-3 border-top" style="padding-top: 10px">
            <div class="p-2">Tasks</div>
            <#list project.tasks as task>
                <ol class="list-group list-group-light list-group-numbered">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="ms-2 me-auto">
                            <div class="fw-bold">TASK-${task.id}</div>
                            ${task.name}
                        </div>
                        <span class="badge badge-primary rounded-pill">${task.status}</span>
                    </li>
                </ol>
            <#else>
                <div class="p-2">No tasks</div>
            </#list>
        </div>
        <button type="button" class="btn btn-success btn-rounded">Create task</button>
    </div>
    <div class="col-md-4 border-top">
        <div class="d-flex align-items-center" style="margin-top:30px;">
            <div class="p-2">Price</div>
            <div class="ms-3">
                <p class="fw-bold mb-1">${project.price} млн ₽</p>
            </div>
        </div>
        <div class="p-2 border-top" style="margin-top:30px; padding-top: 30px">Users</div>
        <div class="d-flex align-items-center">
                <ol class="list-group list-group-light list-group-numbered">
                    <#list project.users as user>
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="ms-2 me-auto">
                            <div class="fw-bold">${user.lastname} ${user.firstname}</div>
                        </div>
                        <span class="badge badge-primary rounded-pill">${user.role}</span>
                    </li>
                    <#else>
                        <div class="p-2">No users</div>
                    </#list>
                </ol>
        </div>
        <form method="post">
        <select class="form-select" aria-label="Default select example" name="id_user">
            <option value="0">No user</option>
            <#list users as user>
                <#if user.firstname != "Администратор">
                    <option value="${user.userId}">${user.lastname} ${user.firstname}</option>
                </#if>
            </#list>
<#--                <p><input type="submit" value="Отправить"></p>-->
        </select>
        <input type="submit" class="btn btn-primary btn-rounded" role="button" aria-pressed="true" value="Add user"></input>
        </form>
    </div>
</div>


</body>

</html>