document.addEventListener("DOMContentLoaded", function() {
    const loginButton = document.querySelector('#loginBtn');

    loginButton.addEventListener("click", function() {
        const usrName = document.getElementById('usrName').value;
        console.log(usrName);
        const password = document.getElementById('txtPswd').value;

        const requestBody = {
            username: usrName,
            password: password
        };

        fetch('http://localhost:8081/app/auth/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error('Login failed');
                }
            })
            .then(token => {
                localStorage.setItem('token', token);
                window.location.href = 'home.html';
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});
