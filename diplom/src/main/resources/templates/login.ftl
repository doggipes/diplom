<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Login</title>
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
      <div class="container py-5 h-100 col-4">
         <h1>Welcome</h1>
         <form action="/login" method="post">
            <!-- Email input -->
            <div class="form-outline mb-4">
               <input type="email" id="form2Example1" class="form-control" name="email"/>
               <label class="form-label" for="form2Example1">Email address</label>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
               <input type="password" id="form2Example2" class="form-control" name="password"/>
               <label class="form-label" for="form2Example2">Password</label>
            </div>

            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

            <!-- Register buttons -->
            <div class="text-center">
               <p>Not a member? <a href="/auth">Register</a></p>
            </div>
         </form>
      </div>
   </body>

</html>