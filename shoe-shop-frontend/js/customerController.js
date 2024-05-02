$(document).ready(function() {
    const isLoadedFromHomePage = localStorage.getItem('loadedFromHomePage');

    if (isLoadedFromHomePage === 'true') {
        $("#customerTblForm").show();
    } else {
        $(".containerSec").hide();
    }
    viewCustomerAddForm = () => {
        $(".containerSec").hide();
        $("#customerAddForm").show();
    }

    viewCustomreTbl = () => {
        $(".containerSec").hide();
        $("#customerTblForm").show();
    }

    viewCustomerView = () => {
        $(".containerSec").hide();
        $("#customerView").show();
    }

    viewCustomerEdit = () => {
        $(".containerSec").hide();
        $("#customerEdit").show();
    }
});



function saveCustomer() {


    console.log('Save Customer ha i haijai ');
    // const now = new Date();
    // const customerId = document.getElementById('customerId').value;
    // const customerName = document.getElementById('customerName').value;
    // const userId = document.getElementById('userId').value;
    // const gender = document.getElementById('gender').value;
    // const joinDate = formatDate(document.getElementById('joinDate').value);
    // const dob = formatDate(document.getElementById('dob').value);
    // const level = document.getElementById('level').value;
    // const totalPoints = document.getElementById('totalPoints').value;
    // const addressLine1 = document.getElementById('addressLine1').value;
    // const addressLine2 = document.getElementById('addressLine2').value;
    // const addressLine3 = document.getElementById('addressLine3').value;
    // const addressLine4 = document.getElementById('addressLine4').value;
    // const addressLine5 = document.getElementById('addressLine5').value;
    // const contactNo = document.getElementById('conNo').value;
    // const isActive = document.getElementById('isActive').checked;

    const customerData = {
        "customerId": "2",
        "customerName": "John Doe",
        "userId": "1",
        "gender": "MALE",
        "joinDate": "2024-04-26",
        "level": "GOLD",
        "totalPoints": 100,
        "dob": "1990-01-01",
        "addressLine1": "123 Main St",
        "addressLine2": "Apt 101",
        "addressLine3": "City",
        "addressLine4": "State",
        "addressLine5": "12345",
        "contactNo": "1234567890",
        "email": "john.doe@example.com",
        "recentPurchaseDateTime": "2024-04-26T14:00:00",
        "createBy": "admin",
        "modifyBy": "admin",
        "isActive": true
    };


    const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWhpcnUiLCJpYXQiOjE3MTQ2Njc4MTQsImV4cCI6MTcxNDc1NDIxNH0.ENeIH6C9HeVY4WnabZQ8XzPZBwS4-isOK_yfxi6BkQw";

    fetch('http://localhost:8081/app/api/v1/customer', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(customerData)
    })
        .then(response => response.json())
        .then(data => {
            alert('Customer saved successfully');
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function openEditForm(customer) {
    document.getElementById('staticBackdropLabel').textContent = 'Edit Customer';
    document.getElementById("customer-name").value = customer.customerName;
    document.getElementById("customer-gender").value = customer.gender;
    document.getElementById("customer-contact").value = customer.contactNo;
    document.getElementById("customer-email").value = customer.email;
    document.getElementById("customer-dob").value = customer.dob;
    document.getElementById("customer-address-lane").value = customer.addressLine1;
    document.getElementById("customer-address-state").value = customer.addressLine2;
    document.getElementById("customer-address-country").value = customer.addressLine3;
    document.getElementById("customer-address-city").value = customer.addressLine4;
    document.getElementById("customer-address-code").value = customer.addressLine5;
    document.getElementById("addCustomerPopup").style.display = "block";
}

function get() {
    const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWhpcnUiLCJpYXQiOjE3MTQ2Njc4MTQsImV4cCI6MTcxNDc1NDIxNH0.ENeIH6C9HeVY4WnabZQ8XzPZBwS4-isOK_yfxi6BkQw";

    fetch('http://localhost:8081/app/api/v1/customer', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`

        }
    })
        .then(response => response.json())
        .then(data => {
            if (data && data.length > 0) {
                localStorage.setItem('customers', JSON.stringify(data));
                renderCustomers(data);
            } else {
                console.log('No data received from the server.');
            }
        })
        .catch(error => console.error('Error fetching data:', error));

    // JavaScript function to open the popup window

    function renderCustomers(customers) {
        const customerTableBody = document.getElementById('customerTbl');
        customerTableBody.innerHTML = '';

        customers.forEach(customer => {
            const newRow = document.createElement('tr');
            const customerIdCell = document.createElement('td');
            customerIdCell.textContent = customer.customerId;
            newRow.appendChild(customerIdCell);

            const customerNameCell = document.createElement('td');
            customerNameCell.textContent = customer.customerName;
            newRow.appendChild(customerNameCell);

            const levelCell = document.createElement('td');
            levelCell.textContent = customer.level;
            newRow.appendChild(levelCell);

            const totalPointsCell = document.createElement('td');
            totalPointsCell.textContent = customer.totalPoints;
            newRow.appendChild(totalPointsCell);

            const contactNoCell = document.createElement('td');
            contactNoCell.textContent = customer.contactNo;
            newRow.appendChild(contactNoCell);

            const emailCell = document.createElement('td');
            emailCell.textContent = customer.email;
            newRow.appendChild(emailCell);

            const addressCell = document.createElement('td');
            addressCell.textContent = `${customer.addressLine1}, ${customer.addressLine2}, ${customer.addressLine3}, ${customer.addressLine4}, ${customer.addressLine5}`;
            newRow.appendChild(addressCell);

            const actionCell = document.createElement('td');
            const buttonGroup = document.createElement('div');
            buttonGroup.className = 'button-group d-flex flex-wrap align-items-center';

            const viewLink = document.createElement('a');
            // viewLink.href = `customerView.html?customerId=${customer.customerId}`;
            viewLink.onclick = function() {
                openCustomerViewForm(customer.customerId);
            };
            viewLink.title = 'View';
            viewLink.innerHTML = '<img src="../assets/imgs/eye.png" alt="View">';
            buttonGroup.appendChild(viewLink);

            const editLink = document.createElement('a');
            editLink.href = '#';
            editLink.onclick = function() {
                openEditForm(customer);
            };
            editLink.title = 'Edit';
            editLink.innerHTML = '<img src="../assets/imgs/edit.png" alt="Edit">';
            buttonGroup.appendChild(editLink);

            const deleteLink = document.createElement('a');
            deleteLink.className = 'delete-btn';
            deleteLink.setAttribute('data-bs-toggle', 'offcanvas');
            deleteLink.href = '#';
            deleteLink.role = 'button';
            deleteLink.setAttribute('aria-controls', 'deletePopup');
            deleteLink.innerHTML = '<img src="../assets/imgs/delete.png" alt="Delete">';
            buttonGroup.appendChild(deleteLink);

            actionCell.appendChild(buttonGroup);
            newRow.appendChild(actionCell);
            customerTableBody.appendChild(newRow);
        });
    }
}


function closeViewPopup() {
    document.getElementById('popUpCustomerView').style.display = 'none';
}

function loadCustomerData(customer) {
    document.getElementById('customerIdView').textContent = customer.customerId;
    document.getElementById('customerNameView').textContent = customer.customerName;
    document.getElementById('userIdView').textContent = customer.userId;
    document.getElementById('genderView').textContent = customer.gender ? customer.gender : '';
    document.getElementById('joinDateView').textContent = formatDate(customer.joinDate);
    document.getElementById('loyaltyLevelView').textContent = customer.level ? customer.level : '';
    document.getElementById('totalPointsView').textContent = customer.totalPoints ? customer.totalPoints : '';
    document.getElementById('dobView').textContent = formatDate(customer.dob);
    document.getElementById('addressView').textContent = `${customer.addressLine1}, ${customer.addressLine2}, ${customer.addressLine3}, ${customer.addressLine4}, ${customer.addressLine5}`;
    document.getElementById('contactNoView').textContent = customer.contactNo;
    document.getElementById('emailView').textContent = customer.email;
    document.getElementById('recentPurchaseDateTimeView').textContent = formatDate(customer.recentPurchaseDateTime);
    document.getElementById('createByView').textContent = customer.createBy;
    document.getElementById('modifyByView').textContent = customer.modifyBy;
    document.getElementById('isActiveView').textContent = customer.isActive ? 'Yes' : 'No';
}

function formatDate(dateString) {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toLocaleDateString();
}
function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    const results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

const customerId = getUrlParameter('customerId');

const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWhpcnUiLCJpYXQiOjE3MTQ2Njc4MTQsImV4cCI6MTcxNDc1NDIxNH0.ENeIH6C9HeVY4WnabZQ8XzPZBwS4-isOK_yfxi6BkQw";

fetch(`http://localhost:8081/app/api/v1/customer/${customerId}`, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
    }
})
    .then(response => response.json())
    .then(customer => {
        loadCustomerData(customer);
    })
    .catch(error => {
        console.error('Error fetching customer data:', error);
    });


function openAddCustomerPopup() {
    document.getElementById("addCustomerPopup").style.display = "block";
    document.getElementById('staticBackdropLabel').textContent = 'Add Customer';
    document.getElementById("customer-name").value = '';
    document.getElementById("customer-address-city").value = '';
    document.getElementById("customer-address-code").value = '';
    document.getElementById("customer-address-country").value = '';
    document.getElementById("customer-address-lane").value = '';
    document.getElementById("customer-address-state").value = '';
    document.getElementById("customer-contact").value = '';
    document.getElementById("customer-dob").value = '';
    document.getElementById("customer-email").value = '';
}

function getCustomerDetailsById(customerId) {
    const customers = JSON.parse(localStorage.getItem('customers'));
    const customer = customers.find(customer => customer.customerId === customerId);

    return customer;
}

function openCustomerViewForm(customerId) {

    const customer = getCustomerDetailsById(customerId);
    document.getElementById('customerId').textContent = customer.customerId;
    document.getElementById('customerName').textContent = customer.customerName;
    document.getElementById('userId').textContent = customer.userId;
    document.getElementById('gender').textContent = customer.gender;
    document.getElementById('joinDate').textContent = customer.joinDate;
    document.getElementById('loyaltyLevel').textContent = customer.level;
    document.getElementById('totalPoints').textContent = customer.totalPoints;
    document.getElementById('dob').textContent = customer.dob;
    document.getElementById('address').textContent = customer.addressLine1 + ', ' + customer.addressLine2 + ', ' + customer.addressLine3 + ', ' + customer.addressLine4 + ', ' + customer.addressLine5;
    document.getElementById('contactNo').textContent = customer.contactNo;
    document.getElementById('email').textContent = customer.email;
    document.getElementById('recentPurchaseDateTime').textContent = customer.recentPurchaseDateTime;
    document.getElementById('createBy').textContent = customer.createBy;
    document.getElementById('modifyBy').textContent = customer.modifyBy;
    document.getElementById('isActive').textContent = customer.isActive;

    document.getElementById('popUpCustomerView').style.display = 'block';

}
function closeAddCustomerPopup() {
    document.getElementById("addCustomerPopup").style.display = "none";
}