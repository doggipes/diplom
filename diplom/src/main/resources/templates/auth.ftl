<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Register</title>
<#--    <link rel="stylesheet"-->
<#--          type="text/css" href="<@spring.url '/css/style.css'/>"/>-->
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
<#--<form action="/auth" method="post">-->
<#--    <input type="text" name="email" placeholder="Email">-->
<#--    <input type="text" name="login" placeholder="Login">-->
<#--    <input type="text" name="firstname" placeholder="Firstname">-->
<#--    <input type="text" name="lastname" placeholder="Lastname">-->
<#--    <input type="password" name="password" placeholder="Password">-->
<#--    <input type="submit" class="send" value="Register">-->
<#--</form>-->

<div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
    <div class="container">
        <div class="row gx-lg-5 align-items-center">
            <div class="col-lg-6 mb-5 mb-lg-0">
                <h1 class="my-5 display-3 fw-bold ls-tight">
                    Модуль управления проектами и задачами  <br />
                    <span class="text-primary">для системы автоматизации проектной организации</span>
                </h1>
            </div>

            <div class="col-lg-6 mb-5 mb-lg-0">
                <div class="card">
                    <div class="card-body py-5 px-md-5">
                        <h1>Register</h1>
                        <form action="/auth" method="post">
                            <!-- 2 column grid layout with text inputs for the first and last names -->
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="form3Example1" class="form-control" name="firstname"/>
                                        <label class="form-label" for="form3Example1">First name</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="form3Example2" class="form-control" name="lastname"/>
                                        <label class="form-label" for="form3Example2">Last name</label>
                                    </div>
                                </div>
                            </div>

                            <!-- Login input -->
                            <div class="form-outline mb-4">
                                <input type="text" id="form3Example3" class="form-control" name="login"/>
                                <label class="form-label" for="form3Example3">Login</label>
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="email" id="form3Example3" class="form-control" name="email"/>
                                <label class="form-label" for="form3Example3">Email address</label>
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <input type="password" id="form3Example4" class="form-control" name="password"/>
                                <label class="form-label" for="form3Example4">Password</label>
                            </div>

                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-block mb-4">
                                Sign up
                            </button>

                            <!-- Login buttons -->
                            <div class="text-center">
                                <p>Already registered? <a href="/login">Login</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>