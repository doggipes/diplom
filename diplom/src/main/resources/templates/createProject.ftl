<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Create Project</title>
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
<div class="container py-5 h-100 col-4">
    <div class="d-flex flex-row mb-3">
        <div class="p-2"><h1>Create project</h1></div>
        <div class="p-2"><form action="/api/v1/project/template/create" style="padding-top: 9px;">
                <button type="submit" class="btn btn-outline-secondary btn-rounded" data-mdb-ripple-color="dark">with template</button>
            </form></div>
    </div>

    <form method="post" action="/api/v1/project/create">
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="text" id="form2Example1" class="form-control" name="name"/>
            <label class="form-label" for="form2Example1">Name</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="number" id="form2Example2" class="form-control" name="price"/>
            <label class="form-label" for="form2Example2">Price</label>
        </div>

        <div class="form-outline mb-4">
            <textarea class="form-control" id="form4Example3" rows="4" name="description"></textarea>
            <label class="form-label" for="form4Example3">Description</label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Create</button>
    </form>
</div>
</body>

</html>