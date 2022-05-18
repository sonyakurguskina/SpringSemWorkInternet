<!doctype html>
<html lang="en" xmlns:margin-left="http://www.w3.org/1999/xhtml" xmlns:margin-right="http://www.w3.org/1999/xhtml"
      xmlns:width="http://www.w3.org/1999/xhtml">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="utf-8">
    <title>Аккаунты сайта</title>
    <link href="css/blog.css" rel="stylesheet" type="text/css">
    <#--    <script src="js/jquery.dataTables.min.css" type="text/javascript"></script>&ndash;&gt;-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <#--    <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>-->
    <#--    <script src="js/accounts.js"></script>-->

    <#--    <script>$(document).ready(function () {-->
    <#--            $.noConflict();-->
    <#--            var table = $('#users').DataTable();-->
    <#--        });</script>-->

    <#--    &lt;#&ndash;-->

    <#--        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> --#>-->
    <style type="text/css">
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }

            .container {
                padding-right: 15px;
                padding-left: 15px;
                padding-bottom: 15px;
                margin-right: auto;
                margin-left: auto;
            }

            a {
                text-decoration: none;
            }

            @media (min-width: 1200px) {
                .container {
                    width: 1170px
                }
            }
        }
    </style>


    <#--    <script src="<@spring.url "/js/articles.js"/>"></script>-->
</head>
<div>

    <div class="container">
        <header class="blog-header py-1">
            <div class="row flex-nowrap justify-content-between align-items-center">
                <div class="d-flex justify-content-center">
                    <a class="blog-header-logo text-dark" href="">United Internet</a>
                </div>
            </div>
            <div class="d-flex justify-content-end">
                <a class="text-muted" href="#" aria-label="Search">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor"
                         stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
                         viewBox="0 0 24 24" focusable="false"><title>Search</title>
                        <circle cx="10.5" cy="10.5" r="7.5"/>
                        <path d="M21 21l-5.2-5.2"/>
                    </svg>
                </a>
                <a class="btn btn-sm btn-outline-secondary" href="/userPage">Account</a>
            </div>
        </header>

        </nav>
    </div>

    <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark">
        <div class="col">
            <h1 class="display-6 font-italic">Пользователи сайта</h1>
            <div class="d-flex justify-content-end">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <table id="users_table">
                                <#if accounts?has_content>
                                    <#list accounts as account>
                                        <tr>
                                            <td>
                                                <form method="post" action="/accounts/${account.id}/delete">
                                                    <input type="submit" value="Удалить">
                                                </form>
                                            </td>
                                            <td>${account.id}</td>
                                            <td>${account.firstName}</td>
                                            <td>${account.email}</td>
                                            <td></td>
                                        </tr>
                                    </#list>
                                <#else>
                                    <p>Пока пользователей нет</p>
                                </#if>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <#--            <div class = "container">-->
    <#--                <div class="row">-->
    <#--                    <div class ="col-sm-4">-->
    <#--                        <form id ="frmUser" name="frmUser">-->

    <#--                            <div class="form-group" align ="left">-->
    <#--                                <label>Email</label>-->
    <#--                                <input type="text" id="email" placeholder="email" class="form-control" required>-->
    <#--                            </div>-->

    <#--                            <div class="form-group" align="left">-->
    <#--                                <label>Имя</label>-->
    <#--                                <input type="text" id="firstName" name="'firstName" placeholder="firstName" class = "form-control" required>-->
    <#--                            </div>-->

    <#--                            <div class="form-group" align="left">-->
    <#--                                <button onclick="addUser()">Add</button>-->
    <#--                                &lt;#&ndash;                                        <button type="button" class="btn btn-varning" id="rest" onclick="reSet()">Reset</button>&ndash;&gt;-->
    <#--                            </div>-->

    <#--                        </form>-->
    <#--                    </div>-->

    <#--                    <div class="col-sm-8">-->
    <#--                        <div class="panel-body">-->
    <#--                            <table id="users" class="table table-bordered" cellpadding="0" cellspacing="0" width="100%">-->
    <#--                                <thead>-->
    <#--                                <tr><th>Email</th><th>Имя</th><th>Delete</th></tr>-->
    <#--                                </thead>-->
    <#--                            </table>-->
    <#--                        </div>-->
    <#--                    </div>-->



    <#--        &lt;#&ndash;                    <script src="js/jquery.validate.min.js" type="text/javascript"></script>&ndash;&gt;-->
    <#--        &lt;#&ndash;                    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>&ndash;&gt;-->
    <#--&lt;#&ndash;        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>&ndash;&gt;-->
    <#--        <body>-->
    <#--        <script>-->
    <#--            var isNew = true;-->
    <#--            var userId = null;-->
    <#--            // getall();-->


    <#--            function addUser() {-->
    <#--                if ($("#frmUser").valid()) {-->
    <#--                    var url = "";-->
    <#--                    var data = "";-->
    <#--                    var method;-->

    <#--                    if (isNew == true) {-->
    <#--                        url = '/accounts/save';-->
    <#--                        data = $("#frmUser").serialize();-->
    <#--                        method = 'POST'-->
    <#--                    } else {-->
    <#--                        url = '/accounts';-->
    <#--                        data = $("#frmUser").serialize() + "&userId" + userId;-->
    <#--                        method = 'Post'-->
    <#--                    }-->

    <#--                    $.ajax({-->
    <#--                            type: method,-->
    <#--                            url: url,-->
    <#--                            dataType: "JSON",-->
    <#--                            data: data,-->

    <#--                            success: function (data) {-->
    <#--                                $('#email').val("");-->
    <#--                                $('#firsName').val("");-->
    <#--                                console.log(data);-->
    <#--                                getall();-->

    <#--                                if (data.status == "success") {-->
    <#--                                    alert("Record Added");-->
    <#--                                } else {-->
    <#--                                    alert("Error");-->
    <#--                                }-->
    <#--                            }-->
    <#--                        }-->
    <#--                    );-->
    <#--                }-->


    <#--                function getall($) {-->

    <#--                    ($('#users')).dataTable().Destroy();-->
    <#--                    $.ajax({-->
    <#--                        url: "accounts/list",-->
    <#--                        type: "GET",-->
    <#--                        dataType: "JSON",-->
    <#--                        success: function (data) {-->
    <#--                            $("users").dataTable({-->
    <#--                                "data": data,-->
    <#--                                "columns": [-->
    <#--                                    {data: 'email'},-->
    <#--                                    {data: 'firstName'},-->
    <#--                                    // {-->
    <#--                                    //     data: null,-->
    <#--                                    //     render: function (data, type, full, meta) {-->
    <#--                                    //         return $("#btn btn-success").attr("onclick","").click(function(){-->
    <#--                                    //             edit(data.id);-->
    <#--                                    //         });-->
    <#--                                    //         // '<button class = "btn btn-success" ="get_details(' + data.id + ')">Edit<button>';-->
    <#--                                    //     }-->
    <#--                                    // },-->
    <#--                                    {-->
    <#--                                        data: null,-->
    <#--                                        render: function (data, type, full, meta) {-->
    <#--                                            return $("#btn btn-danger").attr("onclick", "").click(function () {-->
    <#--                                                delete (data.id);-->
    <#--                                            });-->
    <#--                                            // '<button class = "btn btn-danger" on="get_Delete(' + data.id + ')">Delete<button>';-->
    <#--                                        }-->
    <#--                                    }-->
    <#--                                ]-->
    <#--                            });-->
    <#--                        }-->
    <#--                    })-->
    <#--                }-->
    <#--            }-->
    <#--        </script>-->
</div>
</div>
</div>
</body>


<footer class="blog-footer">
    <p>Made by Sonya Kurguskina 2021</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
