class User {
    constructor(username, password, jwt, profilePic, role) {
        this.username = username;
        this.password = password;
        this.jwt = jwt;
        this.profilePic = profilePic;
        this.role = role;
    }
}

$(document).ready(function() {
    $('#loginBtn').on('click', function (event) {
        event.preventDefault();
        var username = $('#usrName').val();
        var password = $('#txtPswd').val();
        var data = {
            username: username,
            password: password
        };

        console.log('Data to be sent:', data);

        $.ajax({
            url: BASE_URL + 'api/auth/login',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                console.log('Response from server:', res);
                localStorage.setItem('user', JSON.stringify(res));
                let user = JSON.parse(localStorage.getItem('user'));
                console.log('JWT:', user.jwt);
                console.log('ProfilePic:', user.profilePic);
                console.log('Role:', user.role);
                console.log('Username:', user.username);

                let timerInterval;
                Swal.fire({
                    title: "Login Successful! Please Wait...",
                    html: "I will close in <b></b> milliseconds.",
                    timer: 2000,
                    timerProgressBar: true,
                    didOpen: () => {
                        Swal.showLoading();
                        const timer = Swal.getPopup().querySelector("b");
                        timerInterval = setInterval(() => {
                            timer.textContent = `${Swal.getTimerLeft()}`;
                        }, 100);
                    },
                    willClose: () => {
                        clearInterval(timerInterval);
                    }
                }).then((result) => {
                    if (result.dismiss === Swal.DismissReason.timer) {
                        if (user.role === 'ADMIN' || user.role === 'SUPER_ADMIN') {
                            console.log('Redirecting to admin page');
                            window.location.href = "page/admin/";
                        } else if (user.role === 'USER') {
                            console.log('Redirecting to user page');
                            window.location.href = 'page/regular/regular-user-order.html';
                        } else {
                            alert('Invalid role!');
                        }
                    }
                });
            },
            error: function (res) {
                console.log('Error response from server:', res);
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Invalid username or password!"
                });
            }
        });
    });
});
