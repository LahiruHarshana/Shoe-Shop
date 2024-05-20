class User {
    constructor(username, password, jwt, profilePic, role) {
        this.username = username;
        this.password = password;
        this.jwt = jwt;
        this.profilePic = profilePic;
        this.role = role;
    }
}

$('#loginBtn').on('click', function () {
    console.log('clicked');
    var username = $('#usrName').val();
    var password = $('#txtPswd').val();
    var data = {
        username: username,
        password: password
    };

    console.log(data);

    $.ajax({
        url: BASE_URL + 'api/auth/login',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (res) {
            console.log(res);
            localStorage.setItem('user', JSON.stringify(res));
            const user = JSON.parse(localStorage.getItem('user'));

            console.log(user.jwt);
            console.log(user.profilePic);
            console.log(user.role);
            console.log(user.username);

            let timerInterval;
            Swal.fire({
                title: '<strong style="color: #449dd1; font-size: 1.5em;">Login Successful!</strong>',
                html: '<div style="font-size: 1.2em; color: #555;">Redirecting in <b></b> milliseconds.</div><br><br>' +
                    '<div class="spinner-border text-primary" role="status">' +
                    '  <span class="visually-hidden">Loading...</span>' +
                    '</div>',
                timer: 2000,
                timerProgressBar: true,
                showConfirmButton: false,
                background: '#fefefe',
                customClass: {
                    popup: 'animate__animated animate__fadeInDown animate__faster',
                },
                didOpen: () => {
                    Swal.showLoading();
                    const timer = Swal.getHtmlContainer().querySelector('b');
                    timerInterval = setInterval(() => {
                        timer.textContent = Swal.getTimerLeft();
                    }, 100);
                },
                willClose: () => {
                    clearInterval(timerInterval);
                }
            }).then((result) => {
                if (result.dismiss === Swal.DismissReason.timer) {
                    if (user.role === 'ADMIN' || user.role === 'SUPER_ADMIN') {
                        window.location.href = "page/admin/";
                    } else if (user.role === 'USER') {
                        window.location.href = 'page/regular/regular-user-order.html';
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Invalid Role',
                            text: 'You have an invalid user role!'
                        });
                    }
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Cancelled',
                        text: 'Login process was cancelled!'
                    });
                }
            });
        },
        error: function () {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Invalid username or password!"
            });
        }
    });
});
