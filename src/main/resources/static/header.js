fetch("http://localhost:8080/admin/api/user/")
    .then(data => data.json())
    .then(jdata => {
        window.spanUserEmail.textContent = jdata.email
        window.spanUserRoles.textContent = jdata.rolesString
        window.textUserId.textContent = jdata.id
        window.textUserName.textContent = jdata.name
        window.textUserAge.textContent = jdata.age
        window.textUserEmail.textContent = jdata.email
        window.textUserRoles.textContent = jdata.rolesString

    })