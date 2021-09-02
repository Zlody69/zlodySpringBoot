function deleteUser() {
    fetch("http://localhost:8080/admin/api/users/" + window.id1.value, {
        method: "DELETE"
    }).then(response => adminPaneler())
}