<head>
</head>
<@base.base title="Reg">
    <form class="form-signin" action="/login" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Регистрация</h1>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Логин" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Пароль" required>
        <label for="inputPassword2" class="sr-only">Password2</label>
        <input type="password" id="inputPassword2" name="password2" class="form-control" placeholder="Пароль" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Регистрация</button>
    </form>
</@base.base>