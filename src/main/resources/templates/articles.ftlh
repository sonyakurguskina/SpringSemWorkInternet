<!doctype html>
<html lang="en" xmlns:margin-left="http://www.w3.org/1999/xhtml" xmlns:margin-right="http://www.w3.org/1999/xhtml"
      xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>Atrticle</title>
    <link href="css/blog.css" rel="stylesheet" type="text/css">
    <#import "/spring.ftl" as spring/>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style type = "text/css">
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

            a{
                text-decoration: none;
            }

            @media (min-width: 1200px) {
                .container {
                    width: 1170px
                }
            }
        }
    </style>
    <#import "spring.ftl" as spring/>
    <script src="<@spring.url "/js/jquery-3.3.1.min.js"/>"></script>
    <script src="<@spring.url "/js/articles.js"/>"></script>
</head>
<div>
    <div class="container">
        <header class="blog-header py-1">
            <div class="row flex-nowrap justify-content-between align-items-center">
                <div class="d-flex justify-content-center">
                    <a class="blog-header-logo text-dark" href="/blogauth">United Internet</a>
                </div>
            </div>
        </header>
        <body>

        </body>

        <div class="nav-scroller">
            <nav class="d-flex justify-content-start">
                <a class="p-2 text-muted" href="articles.html">Статьи</a>
                <a class="p-2 text-muted" href="videos.html">Видео</a>

            </nav>
        </div>


        <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark">
            <div class="col">
                <section class="blog-section spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="search-flex">
                                    <p><input type="search" name="q" class="search-field" placeholder="Поиск по сайту"
                                              onkeyup="showResult(this.value)">
                                        <input type="submit" class="searchButton" value="Найти"></p>
                                </div>
                            </div>

                            <div class="content">

                                <table id="articles_table">

                                </table>

                                <div class="article_content">

                                    <div class="articles">
                                        <h1>Статьи в нашем блоге</h1>
                                        <#if articles?has_content>
                                            <#list articles as article>
                                                <div class="article">
                                                    <a href="/articles/${article.id}"><h5>${article.title}</h5></a>
                                                    <p>${article.text}</p>
                                                    <p>Автор статьи: ${article.userId}</p>
                                                </div>
                                            </#list>
                                        <#else>
                                            <p>Статьи</p>
                                        </#if>
                                    </div>

                                    <div class="addArticle">
                                        <form action="/articles/add" method="post">
                                            <input type="text" name="title" placeholder="Название">
                                            <input type="text" name="text" placeholder="Содержание">
                                            <button type="submit">Добавить</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
            <script>
                function showResult(title) {
                    const xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (this.readyState === 4 && this.status === 200) {
                            let html =
                                '<thead>' +
                                '<th>Название</th>' +
                                '<th>Содержание</th>' +
                                '<th>Автор</th>' +
                                '</thead>'

                            let response = JSON.parse(this.response);

                            for (let i = 0; i < response.length; i++) {
                                html += '<tr>';
                                html += '<td>' + response[i]['title'] + '</td>';
                                html += '<td>' + response[i]['text'] + '</td>';
                                html += '<td>' + response[i]['userName'] + '</td>';
                                html += '</tr>';
                            }
                            document.getElementById('articles_table').innerHTML = html;
                        }
                    }
                    xmlhttp.open("GET", "/articles/" + title, true);
                    xmlhttp.send();
                }
            </script>



            <footer class="blog-footer">
                <p>Made by Sonya Kurguskina 2021</p>
            </footer>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
            </body>
</html>