function deleteUserModal(id) {
    fetch("http://localhost:8080/admin/api/users/" + id)
        .then(jData => jData.json())
        .then(data => {
            window.id1.value = data.id
            window.name1.value = data.name
            window.age1.value = data.age
            window.roleId1Del.checked = false
            window.roleId0Del.checked = false
            data.roles.forEach(role => {
                if (role.name === "ROLE_ADMIN") {
                    window.roleId0Del.checked = true
                }
                if (role.name === "ROLE_USER") {
                    window.roleId1Del.checked = true
                }
            })

        })
}