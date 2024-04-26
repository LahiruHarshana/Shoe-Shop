let token = '';

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
                if (!response.ok) {
                    throw new Error('Login failed');
                }
                return response.text();
            })
            .then(data => {
                token = data;
                document.getElementById("jwtToken").value = data;
                console.log('Token received:', data);
                window.location.href = "Home/home.html";
            })
            .catch(error => console.error('Error:', error));
    });
});