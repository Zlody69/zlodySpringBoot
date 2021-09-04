function putUser() {
    const form = new FormData(document.getElementById("formEditUser"))
    let userData = {roles: []}
    form.forEach((value, key) => {
        if(value==="ROLE_ADMIN"){
            userData.roles.push(value)
        }else if(value==="ROLE_USER"){
            userData.roles.push(value)
        }else {
            userData[key]=value}
    })
    console.log(userData)

    fetch("http://localhost:8080/admin/api/users/", {
        method: 'PUT',
        body: JSON.stringify(userData),
        headers: {'Content-type': 'application/json; charset=UTF-8'}
    })
        .then(response => adminPaneler())

}
