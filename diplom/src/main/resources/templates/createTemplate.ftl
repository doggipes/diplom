<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Create Task</title>
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
<div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
    <div class="container">
        <div class="row gx-lg-5 align-items-center">
            <div class="col-lg-6 mb-5 mb-lg-0">
                <h1 class="my-5 display-3 fw-bold ls-tight">
                    Create template  <br />
                </h1>
            </div>

            <div class="col-lg-6 mb-5 mb-lg-0">
                <div class="card">
                    <div class="card-body py-5 px-md-5">
        <form action="/api/v1/projects">
            <!-- 2 column grid layout with text inputs for the first and last names -->

            <!-- Text input -->
            <div class="form-outline mb-4">
                <input type="text" id="form6Example3" class="form-control"/>
                <label class="form-label" for="form6Example3">Name</label>
            </div>

            <!-- Message input -->
            <div class="form-outline mb-4">
                <textarea class="form-control" id="form6Example7" rows="4"></textarea>
                <label class="form-label" for="form6Example7">Description</label>
            </div>
            <div class="row mb-4">
                <div class="col">
                    <div class="d-flex align-items-center" style="margin-top:30px;">
                        <div class="p-2">Assignee</div>
                        <img src="http://cdn.onlinewebfonts.com/svg/img_415638.png" alt="" style="width: 45px; height: 45px"
                             class="rounded-circle" />
<#--                        <div class="ms-3">-->
<#--                            <p class="fw-bold mb-1">Рахимов Джалил</p>-->
<#--                        </div>-->
                        <select class="form-select" aria-label="Default select example" name="userId">
                            <option value="0">No user</option>
                            <#list users as user>
                                <option value="${user.userId}">${user.lastname} ${user.firstname}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <div class="d-flex align-items-center" style="margin-top:30px;">
                        <div class="p-2">Reporter</div>
                        <img src="http://cdn.onlinewebfonts.com/svg/img_415638.png" alt="" style="width: 45px; height: 45px"
                             class="rounded-circle" />
<#--                        <div class="ms-3">-->
<#--                            <p class="fw-bold mb-1">Рахимов Джалил</p>-->
<#--                        </div>-->
                        <select class="form-select" aria-label="Default select example" name="userId">
                            <option value="0">No user</option>
                            <#list users as user>
                                <option value="${user.userId}">${user.lastname} ${user.firstname}</option>
                            </#list>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col">
                    <div class="d-flex align-items-center" style="margin-top:30px;">
                        <div class="p-2">Date start</div>
                        <input type="date" name="dateStart">
                    </div>
                </div>
                <div class="col">
                    <div class="d-flex align-items-center" style="margin-top:30px;">
                        <div class="p-2">Date end</div>
                        <input type="date" name="dateEnd">
                    </div>
                </div>
            </div>
            <div id="1">
                <button onclick="myFunction(1)" type="button" class="btn btn-outline-primary btn-rounded" data-mdb-ripple-color="dark">Create subtask</button>
            </div>
            <div id = "2">
                <button onclick="myFunction(2)" type="button" class="btn btn-outline-primary btn-rounded" data-mdb-ripple-color="dark">Create nextTask</button>
            </div>
                <!-- Submit button -->
                <a type="submit" onclick="" class="btn btn-primary btn-block mb-4" href="/api/v1/projects" style="margin-top: 40px">Create template</a>
        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function myFunction(id) {

        div1=document.createElement('div');
        div1.className = "form-outline mb-4";

        my_tb=document.createElement('INPUT');
        my_tb.type='TEXT';
        my_tb.name='name';
        my_tb.id = 'form6Example3';
        my_tb.className = "form-control";

        label1=document.createElement('label');
        label1.innerHTML = 'Name';
        label1.for='form6Example3';
        label1.className = "form-label";


        div2=document.createElement('div');
        div2.className = "form-outline mb-4";

        my_tb2=document.createElement('textarea');
        my_tb2.name='description';
        my_tb2.rows='4';
        my_tb2.id = 'form6Example3';
        my_tb2.className = "form-control";

        label2=document.createElement('label');
        label2.innerHTML = 'Description';
        label2.for='form6Example3';
        label2.className = "form-label";


        div3=document.createElement('div');
        div3.className = "row mb-4";

        div4=document.createElement('div');
        div4.className = "col";

        div5=document.createElement('div');
        div5.className = "d-flex align-items-center";
        div5.style = "margin-top:30px;";

        div6=document.createElement('div');
        div6.className = "p-2";
        div6.innerHTML = "Assignee";

        img1=document.createElement('img');
        img1.src = "http://cdn.onlinewebfonts.com/svg/img_415638.png";
        img1.alt = "";
        img1.style = "width: 45px; height: 45px";
        img1.className = "rounded-circle";

        div7=document.createElement('select');
        div7.id = "mySelect";
        var option = document.createElement("option");
        option.value = "0";
        option.text = "No user";
        div7.appendChild(option);

        my_form=document.createElement('FORM');
        my_form.name='myForm';
        my_form.method='GET';
        my_form.className='border-top';
        my_form.style='padding-top: 32px;';
        my_form.action='';

        p100=document.createElement('p');
        p100.style = "margin-top: 28px; margin-bottom: 0px;"
        if (String(id).substring(0, 1) == 1) {
            p100.innerHTML="Sub tasks";
        } else {
            p100.innerHTML="Next tasks";
        }


        div8=document.createElement('div');
        div8.className = "col";

        div9=document.createElement('div');
        div9.className = "d-flex align-items-center";
        div9.style = "margin-top:30px;";

        div10=document.createElement('div');
        div10.className = "p-2";
        div10.innerHTML = "Reporter";

        img2=document.createElement('img');
        img2.src = "http://cdn.onlinewebfonts.com/svg/img_415638.png";
        img2.alt = "";
        img2.style = "width: 45px; height: 45px";
        img2.className = "rounded-circle";

        div11=document.createElement('select');
        div11.id = "mySelect";
        var option = document.createElement("option");
        option.value = "0";
        option.text = "No user";
        div11.appendChild(option);


        div12=document.createElement('div');
        div12.className = "row mb-4";

        div13=document.createElement('div');
        div13.className = "col";

        div14=document.createElement('div');
        div14.className = "d-flex align-items-center";
        div14.style = "margin-top:30px;";

        div15=document.createElement('div');
        div15.className = "p-2";
        div15.innerHTML = "Date start";

        div16=document.createElement('input');
        div16.type = "date";
        div16.name = "datestart";

        div17=document.createElement('div');
        div17.className = "col";

        div18=document.createElement('div');
        div18.className = "d-flex align-items-center";
        div18.style = "margin-top:30px;";

        div19=document.createElement('div');
        div19.className = "p-2";
        div19.innerHTML = "Date end";

        div20=document.createElement('input');
        div20.type = "date";
        div20.name = "dateend";

        div23=document.createElement('div');
        div23.className = "row mb-4";

        var today = new Date();
        var ml = String(today.getMilliseconds()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        x = Math.random() * (yyyy - mm) + mm;
        x = parseInt(x, 10);

        today = 1 + '' + x + '' + ml;

        div21=document.createElement('div');
        div21.id = today;
        div21.className = "col";

        button1=document.createElement('button');
        button1.setAttribute("onclick", "myFunction(" + div21.id + ")");
        button1.type = "button";
        button1.className = "btn btn-outline-primary btn-rounded";
        button1.setAttribute("data-mdb-ripple-color", "dark");
        // button1.data-mdb-ripple-color = "dark";
        button1.style = "margin-left: 63px";
        button1.innerHTML = "Create sub task";

        var today = new Date();
        var ml = String(today.getMilliseconds()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        x = Math.random() * (yyyy - mm) + mm;
        x = parseInt(x, 10);

        today = 2 + '' + x + '' + ml;

        div22=document.createElement('div');
        div22.id = today;
        div22.className = "col";

        button2=document.createElement('button');
        button2.setAttribute("onclick", "myFunction(" + div22.id + ")");
        button2.type = "button";
        button2.className = "btn btn-outline-primary btn-rounded";
        button2.setAttribute("data-mdb-ripple-color", "dark");
        button2.style = "margin-left: 63px";
        button2.innerHTML = "Create next task";


        my_form.appendChild(div1);
        my_form.appendChild(div2);
        my_form.appendChild(div3);
        my_form.appendChild(div12);
        my_form.appendChild(div23);

        my_tb.appendChild(label1);

        div1.appendChild(my_tb);
        div1.appendChild(label1);

        my_tb2.appendChild(label2);

        div2.appendChild(my_tb2);
        div2.appendChild(label2);


        div3.appendChild(div4);
        div3.appendChild(div8);

        div4.appendChild(div5);

        div5.appendChild(div6);
        div5.appendChild(img1);
        div5.appendChild(div7);

        div8.appendChild(div9);

        div9.appendChild(div10);
        div9.appendChild(img2);
        div9.appendChild(div11);


        div12.appendChild(div13);
        div12.appendChild(div17);

        div13.appendChild(div14);

        div14.appendChild(div15);
        div14.appendChild(div16);

        div17.appendChild(div18);

        div18.appendChild(div19);
        div18.appendChild(div20);

        div21.appendChild(button1);

        div22.appendChild(button2);

        div23.appendChild(div21);
        div23.appendChild(div22);


        var a = document.getElementById(id);
        a.appendChild(p100);
        a.appendChild(my_form);
    }


    function myFunction2() {
    }
</script>
</body>

</html>