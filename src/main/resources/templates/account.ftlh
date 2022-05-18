<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Ваш аккаунт</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <style>
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
      .errors {
        color: red;
      }
    }
  </style>
  <link href="css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
<form action="/userPage" method="post">
  <@spring.bind path="userDto"/>
  <p class="errors">${spring.status.errorMessage}</p>

  <div class="container">
    <div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="images/logo.svg" alt="" width="100" height="100">
      <h3>Ваш аккаунт</h3>
    </div>


    <div class="col-md-8 order-md-1">
      <form class="needs-validation" novalidate>
        <div class="row">

          <div class="col-md-6 mb-3">
            <#assign i18Tooltip><@spring.message code="user.form.placeholder.firstName"/></#assign>
            <@spring.formInput "userDto.firstName" "placeholder=${i18Tooltip}"/>
            <@spring.showErrors "<br>" "errors"/>
            <br>
          </div>


          <div class="col-md-6 mb-3">
            <#assign i18Tooltip><@spring.message code="user.form.placeholder.lastName"/></#assign>
            <@spring.formInput "userDto.lastName" "placeholder=${i18Tooltip}"/>
            <@spring.showErrors "<br>" "errors"/>
            <br>
          </div>

          <div class="col-md-6 mb-3">
            <#assign i18Tooltip><@spring.message code="user.form.placeholder.password"/></#assign>
            <@spring.formPasswordInput "userDto.password" "placeholder=${i18Tooltip}"/>
            <@spring.showErrors "<br>" "errors"/>
            <br>
          </div>
        </div>
        <button class="btn btn-secondary btn-lg btn-block" type="submit" href = "/mainpage" >Save</button>
      </form>
    </div>
  </div>
</form>

<footer class="my-5 pt-5 text-muted text-center text-small">
  <p class="mb-1">&copy; 2022 Sofya Kurguskina</p>
  <ul class="list-inline">
    <li class="list-inline-item"><a href="#">Github</a></li>
  </ul>
</footer>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="form-validation.js"></script>

</body>
</html>