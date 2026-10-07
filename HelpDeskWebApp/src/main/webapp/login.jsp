<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Login</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="login-page">

    <div class="login-box">

        <div class="login-logo">
            Smart Help Desk
        </div>

        <p class="login-subtitle">
            Ticket Management System
        </p>

        <%
            String error = request.getParameter("error");

            if ("invalid".equals(error)) {
        %>

            <p class="error">
                Invalid username or password
            </p>

        <%
            } else if ("role".equals(error)) {
        %>

            <p class="error">
                Invalid user role
            </p>

        <%
            }
        %>

        <form action="login" method="post">

            <label>Username</label>

            <input type="text"
                   name="username"
                   placeholder="Enter your username"
                   required>

            <label>Password</label>

            <input type="password"
                   name="password"
                   placeholder="Enter your password"
                   required>

            <button type="submit"
                    class="login-button">
                Login
            </button>

        </form>

    </div>

</div>

</body>
</html>