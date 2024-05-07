let suppId;

$(document).ready(function() {
    const isLoadedFromHomePage = localStorage.getItem('loadedFromHomePage');

    if (isLoadedFromHomePage === 'true') {
        $("#supplierTblForm").show();
    } else {
        $(".containerSec").hide();
    }
    viewSupplierAddForm = () => {
        $(".containerSec").hide();
        $("#addSupplierPopup").show();
    }

    viewSupplierTbl = () => {
        $(".containerSec").hide();
        $("#supplierTblForm").show();
    }

    viewSupplierView = () => {
        $(".containerSec").hide();
        $("#popUpSupplierView").show();
    }

    viewSupplierEdit = () => {
        $(".containerSec").hide();
        $("#supplierEdit").show();
    }
});


function saveSupplier() {

    const supplierData = {
        supplierId: suppId,
        supplierName: document.getElementById("supplier-name").value,
        supplierCategory: document.getElementById("supplier-category").value,
        contactNo1: document.getElementById("supplier-contact-1").value,
        contactNo2: document.getElementById("supplier-contact-2").value,
        email: document.getElementById("supplier-email").value,
        addressLine1: document.getElementById("address-line-1").value,
        addressLine2: document.getElementById("address-line-2").value,
        addressLine3: document.getElementById("address-line-3").value,
        addressLine4: document.getElementById("address-line-4").value,
        addressLine5: document.getElementById("address-line-5").value,
        addressLine6: document.getElementById("address-line-6").value
    }


    const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWhpcnUiLCJpYXQiOjE3MTQ2Njc4MTQsImV4cCI6MTcxNDc1NDIxNH0.ENeIH6C9HeVY4WnabZQ8XzPZBwS4-isOK_yfxi6BkQw";

    fetch('http://localhost:8081/app/api/v1/supplier', {
        method: document.getElementById("btn-save-supplier").textContent==='Update Supplier'?'PUT':'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(supplierData)
    })
        .then(response => response.json())
        .then(data => {
            alert('Supplier saved successfully');
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function openEditForm(supplier) {
    suppId = supplier.supplierId;
    document.getElementById("btn-save-supplier").textContent = "Update Supplier";
    document.getElementById('staticBackdropLabel').textContent = 'Edit Supplier';
    document.getElementById("supplier-name").value = supplier.supplierName;
    document.getElementById("supplier-category").value = supplier.supplierCategory;
    document.getElementById("supplier-contact-1").value = supplier.contactNo1;
    document.getElementById("supplier-contact-2").value = supplier.contactNo2;
    document.getElementById("supplier-email").value = supplier.email;
    document.getElementById("address-line-1").value = supplier.addressLine1;
    document.getElementById("address-line-2").value = supplier.addressLine2;
    document.getElementById("address-line-3").value = supplier.addressLine3;
    document.getElementById("address-line-4").value = supplier.addressLine4;
    document.getElementById("address-line-5").value = supplier.addressLine5;
    document.getElementById("address-line-6").value = supplier.addressLine6;
    document.getElementById("addSupplierPopup").style.display = "block";
}

function get() {
    const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWhpcnUiLCJpYXQiOjE3MTQ2Njc4MTQsImV4cCI6MTcxNDc1NDIxNH0.ENeIH6C9HeVY4WnabZQ8XzPZBwS4-isOK_yfxi6BkQw";

    fetch('http://localhost:8081/app/api/v1/supplier', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`

        }
    })
        .then(response => response.json())
        .then(data => {
            if (data && data.length > 0) {
                localStorage.setItem('suppliers', JSON.stringify(data));
                renderSuppliers(data);
            } else {
                console.log('No data received from the server.');
            }
        })
        .catch(error => console.error('Error fetching data:', error));

    function renderSuppliers(suppliers) {
        const supplierTableBody = document.getElementById('supplierTbl');
        supplierTableBody.innerHTML = '';

        suppliers.forEach(supplier => {
            const newRow = document.createElement('tr');
            const supplierIdCell = document.createElement('td');
            supplierIdCell.textContent = supplier.supplierId;
            newRow.appendChild(supplierIdCell);

            const supplierNameCell = document.createElement('td');
            supplierNameCell.textContent = supplier.supplierName;
            newRow.appendChild(supplierNameCell);

            const categoryCell = document.createElement('td');
            categoryCell.textContent = supplier.supplierCategory;
            newRow.appendChild(categoryCell);

            const contactNo1Cell = document.createElement('td');
            contactNo1Cell.textContent = supplier.contactNo1;
            newRow.appendChild(contactNo1Cell);

            const contactNo2Cell = document.createElement('td');
            contactNo2Cell.textContent = supplier.contactNo2;
            newRow.appendChild(contactNo2Cell);

            const emailCell = document.createElement('td');
            emailCell.textContent = supplier.email;
            newRow.appendChild(emailCell);

            const addressCell = document.createElement('td');
            addressCell.textContent = `${supplier.addressLine1}, ${supplier.addressLine2}, ${supplier.addressLine3}, ${supplier.addressLine4}, ${supplier.addressLine5}, ${supplier.addressLine6}`;
            newRow.appendChild(addressCell);

            const actionCell = document.createElement('td');
            const buttonGroup = document.createElement('div');
            buttonGroup.className = 'button-group d-flex flex-wrap align-items-center';

            const viewLink = document.createElement('a');
            viewLink.onclick = function() {
                openSupplierViewForm(supplier.supplierId);
            };
            viewLink.title = 'View';
            viewLink.innerHTML = '<img src="../assets/imgs/eye.png" alt="View">';
            buttonGroup.appendChild(viewLink);

            const editLink = document.createElement('a');
            editLink.href = '#';
            editLink.onclick = function() {
                openEditForm(supplier);
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
            supplierTableBody.appendChild(newRow);
        });
    }
}


function closeViewPopup() {
    document.getElementById('popUpSupplierView').style.display = 'none';
}

function loadSupplierData(supplier) {
    suppId = '';
    document.getElementById('supplierCode').textContent = supplier.supplierId;
    document.getElementById('supplierName').textContent = supplier.supplierName;
    document.getElementById('supplierCategory').textContent = supplier.supplierCategory;
    document.getElementById('supplierContact1').textContent = supplier.contactNo1;
    document.getElementById('supplierContact2').textContent = supplier.contactNo2;
    document.getElementById('supplierEmail').textContent = supplier.email;
    document.getElementById('supplierAddress').textContent = `${supplier.addressLine1}, ${supplier.addressLine2}, ${supplier.addressLine3}, ${supplier.addressLine4}, ${supplier.addressLine5}, ${supplier.addressLine6}`;
}

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    const results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

const supplierId = getUrlParameter('supplierId');

const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWhpcnUiLCJpYXQiOjE3MTQ2Njc4MTQsImV4cCI6MTcxNDc1NDIxNH0.ENeIH6C9HeVY4WnabZQ8XzPZBwS4-isOK_yfxi6BkQw";

fetch(`http://localhost:8081/app/api/v1/supplier/${supplierId}`, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
    }
})
    .then(response => response.json())
    .then(supplier => {
        loadSupplierData(supplier);
    })
    .catch(error => {
        console.error('Error fetching supplier data:', error);
    });


function openAddSupplierPopup() {
    document.getElementById("btn-save-supplier").textContent = "Add Supplier";
    document.getElementById("addSupplierPopup").style.display = "block";
    document.getElementById('staticBackdropLabel').textContent = 'Add Supplier';
    document.getElementById("supplier-name").value = '';
    document.getElementById("supplier-category").value = '';
    document.getElementById("supplier-contact-1").value = '';
    document.getElementById("supplier-contact-2").value = '';
    document.getElementById("supplier-email").value = '';
    document.getElementById("address-line-1").value = '';
    document.getElementById("address-line-2").value = '';
    document.getElementById("address-line-3").value = '';
    document.getElementById("address-line-4").value = '';
    document.getElementById("address-line-5").value = '';
    document.getElementById("address-line-6").value = '';
}

function getSupplierDetailsById(supplierId) {
    const suppliers = JSON.parse(localStorage.getItem('suppliers'));
    const supplier = suppliers.find(supplier => supplier.supplierId === supplierId);

    return supplier;
}

function openSupplierViewForm(supplierId) {

    const supplier = getSupplierDetailsById(supplierId);
    loadSupplierData(supplier);
    document.getElementById('popUpSupplierView').style.display = 'block';

}
function closeAddSupplierPopup() {
    document.getElementById("addSupplierPopup").style.display = "none";
}
