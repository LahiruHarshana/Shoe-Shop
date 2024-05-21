$(document).ready(function () {

    function initializeTable(selector) {
        $(selector).DataTable({
            "language": {
                "search": "Search Customer:",
                "lengthMenu": "Display count _MENU_",
                "info": "Showing _START_ to _END_ of _TOTAL_ records",
                "infoEmpty": "Showing 0 to 0 of 0 records",
                "infoFiltered": "(filtered from _MAX_ total records)"
            }
        });
    }

    function loadAllCustomers() {
        $.ajax({
            url: BASE_URL + 'api/v1/customers',
            type: 'GET',
            headers: {
                Authorization: 'Bearer ' + user.jwt
            },
            success: function (data) {
                console.log(data);
                let customers = data;
                let html = '';
                customers.forEach(customer => {
                    let deleteBtn = customer.totalPoints == null
                        ? `<button class="btn btn-sm btn-danger ms-2 btn-delete-customer"><i class="bi bi-person-x-fill"></i></button>`
                        : '';
                    html += `
                        <tr>
                            <td class="text-center">${customer.customerId}</td>
                            <td class="text-center">${customer.customerName}</td>
                            <td class="text-center">${customer.gender}</td>
                            <td class="text-center">${customer.registeredDate}</td>
                            <td class="text-center">${customer.dob}</td>
                            <td class="text-center">${customer.recentPurchaseDate}</td>
                            <td class="text-center">${customer.totalPoints}</td>
                            <td class="text-center">${customer.contact}</td>
                            <td class="text-center">${customer.level}</td>
                            <td class="text-center">${customer.email}</td>
                            <td class="text-center">${customer.address.lane},${customer.address.mainState},${customer.address.mainCity},${customer.address.postalCode}</td>
                            <td class="text-center">
                                <div class="d-flex">
                                    <button class="btn btn-sm btn-primary btn-edit-customer"><i class="bi bi-pencil-square"></i></button>
                                    ${deleteBtn}
                                </div>
                            </td>
                        </tr>`;
                });

                $('#tbl-customer-body').html(html);
                setEvent();
                initializeTable('#tbl-customer');
            },
            error: function (error) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.onmouseenter = Swal.stopTimer;
                        toast.onmouseleave = Swal.resumeTimer;
                    }
                });
                Toast.fire({
                    icon: "error",
                    title: 'Session expired'
                });
            }
        });
    }

    function setEvent() {
        $('.btn-edit-customer').on('click', function () {
            $('#btn-save-customer').text('Update Customer');
            $('#customer-modal').modal('show');
            let id = $(this).closest('tr').find('td:first-child').text();
            cusId = id;
            renderCustomer(id);
        });

        $('.btn-delete-customer').on('click', function () {
            let id = $(this).closest('tr').find('td:first-child').text();
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete Customer!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: BASE_URL + 'api/v1/customers/' + id,
                        type: 'DELETE',
                        headers: {
                            Authorization: 'Bearer ' + user.jwt
                        },
                        success: function (data) {
                            Swal.fire(
                                'Deleted!',
                                'Customer has been deleted.',
                                'success'
                            )
                            loadAllCustomers();
                        },
                        error: function (error) {
                            Swal.fire(
                                'Failed!',
                                'Customer has not been deleted.',
                                'error'
                            )
                        }
                    });
                }
            })
        });
    }

    function renderCustomer(id) {
        $.ajax({
            type: 'GET',
            url: BASE_URL + 'api/v1/customers/' + id,
            headers: {
                Authorization: 'Bearer ' + user.jwt
            },
            success: function (data) {
                $('#customer-name').val(data.customerName);
                $('#customer-gender').val(data.gender);
                $('#customer-contact').val(data.contact);
                $('#customer-email').val(data.email);
                $('#customer-dob').val(data.dob);
                $('#customer-address-lane').val(data.address.lane);
                $('#customer-address-city').val(data.address.mainCity);
                $('#customer-address-state').val(data.address.mainState);
                $('#customer-address-code').val(data.address.postalCode);
                $('#customer-address-country').val(data.address.mainCountry);
            },
            error: function (error) {
                alert('Customer not found!')
            }
        });
    }

    $('#btn-add-customer').on('click', function () {
        $('#btn-save-customer').text('Save Customer');
        $('#customer-modal').modal('show');
    });

    $('#btn-save-customer').on('click', function () {
        const customer = {
            userEmail: user.username,
            customerId: cusId,
            customerName: $('#customer-name').val(),
            gender: $('#customer-gender').val(),
            contact: $('#customer-contact').val(),
            email: $('#customer-email').val(),
            address: {
                lane: $('#customer-address-lane').val(),
                mainCountry: $('#customer-address-country').val(),
                mainCity: $('#customer-address-city').val(),
                mainState: $('#customer-address-state').val(),
                postalCode: $('#customer-address-code').val(),
            },
            dob: $('#customer-dob').val()
        }

        $.ajax({
            url: BASE_URL + 'api/v1/customers',
            type: $('#btn-save-customer').text() === 'Save Customer' ? 'POST' : 'PUT',
            data: JSON.stringify(customer),
            contentType: 'application/json',
            headers: {
                "Authorization": "Bearer " + user.jwt
            },
            success: function (data) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.onmouseenter = Swal.stopTimer;
                        toast.onmouseleave = Swal.resumeTimer;
                    }
                });
                Toast.fire({
                    icon: "success",
                    title: data
                });
                $('#customer-modal').modal('hide');
                loadAllCustomers();
                loadRegeularUserCustomers();
            },
            error: function (error) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.onmouseenter = Swal.stopTimer;
                        toast.onmouseleave = Swal.resumeTimer;
                    }
                });
                Toast.fire({
                    icon: "error",
                    title: 'Failed to save customer!'
                });
            }
        });
    });

    function loadRegeularUserCustomers() {
        $.ajax({
            url: BASE_URL + 'api/v1/customers',
            type: 'GET',
            headers: {
                Authorization: 'Bearer ' + user.jwt
            },
            success: function (data) {
                console.log(data);
                let customers = data;
                let html = '';
                customers.forEach(customer => {
                    html += `
                        <tr>
                            <td class="text-center">${customer.customerId}</td>
                            <td class="text-center">${customer.customerName}</td>
                            <td class="text-center">${customer.gender}</td>
                            <td class="text-center">${customer.registeredDate}</td>
                            <td class="text-center">${customer.dob}</td>
                            <td class="text-center">${customer.recentPurchaseDate}</td>
                            <td class="text-center">${customer.totalPoints}</td>
                            <td class="text-center">${customer.contact}</td>
                            <td class="text-center">${customer.level}</td>
                            <td class="text-center">${customer.email}</td>
                            <td class="text-center">${customer.address.lane},${customer.address.mainState},${customer.address.mainCity},${customer.address.postalCode}</td>
                        </tr>`;
                });

                $('#tbl-customer-regeular-body').html(html);
                initializeTable('#tbl-customer-regeular');
            },
            error: function (error) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.onmouseenter = Swal.stopTimer;
                        toast.onmouseleave = Swal.resumeTimer;
                    }
                });
                Toast.fire({
                    icon: "error",
                    title: 'Session expired'
                });
            }
        });
    }

    loadAllCustomers();
    loadRegeularUserCustomers();
});
