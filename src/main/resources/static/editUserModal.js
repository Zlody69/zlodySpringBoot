function editUserModal(id) {
    fetch("http://localhost:8080/admin/api/users/" + id)
        .then(jData => jData.json())
        .then(data => {
            window.id0.value = data.id
            window.name0.value = data.name
            window.age0.value = data.age
            window.email0.value = data.email
            window.password0.value = data.password
            window.roleId0.checked = false
            window.roleId1.checked = false
            data.roles.forEach(role => {
                if (role.name === "ROLE_ADMIN") {
                    window.roleId0.checked = true
                }
                if (role.name === "ROLE_USER") {
                    window.roleId1.checked = true
                }
            })

        })
}

