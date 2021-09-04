function postUser(){
    const formCreate = new FormData(document.getElementById("formCreateUser"))
    let createUserData = {roles:[]}
    formCreate.forEach((value, key) => {
        if(value==="ROLE_ADMIN"){
            createUserData.roles.push(value)
        }else if(value==="ROLE_USER"){
            createUserData.roles.push(value)
        }else {
            createUserData[key]=value}
    })
    fetch("http://localhost:8080/admin/api/users/",{
        method: 'POST',
        body: JSON.stringify(createUserData),
        headers: {'Content-type': 'application/json; charset=UTF-8'}
    })
        .then(response => adminPaneler())
}