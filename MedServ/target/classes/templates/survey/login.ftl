<head>

</head>
<@base.base title="Login">
    <form class="form-signin" action="/login" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Вход</h1>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Логин" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Пароль" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить меня
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</@base.base>