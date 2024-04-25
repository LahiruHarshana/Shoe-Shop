document.getElementById("saveBtn").addEventListener("click", function() {
    console.log('Save button clicked');
    var now = new Date();
    var formData = {
        customerId: document.getElementById("cus_idTxt").value,
        customerName: document.getElementById("inputEmail4").value,
        userId: '1',
        gender: document.getElementById("gender").value,
        joinDate: document.getElementById("joinDate").value,
        level: document.getElementById("level").value,
        totalPoints: document.getElementById("points").value,
        dob: document.getElementById("inputPassword4").value,
        addressLine1: document.getElementById("buildingNumber").value,
        addressLine2: document.getElementById("laneName").value,
        addressLine3: document.getElementById("city").value,
        addressLine4: document.getElementById("state").value,
        addressLine5: document.getElementById("postalCode").value,
        contactNo: document.getElementById("contact").value,
        email: 'lharshana2002@gmail.com',
        recentPurchaseDateTime: now.toISOString(),
        createBy: '',
        modifyBy: '',
        isActive: true
    };
    var jsonData = JSON.stringify(formData);

    fetch('http://localhost:8081/app/api/v1/customer', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});