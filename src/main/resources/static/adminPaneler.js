const userSpanEmail = document.getElementById("spanUserEmail")
const userSpanRoles = document.getElementById("spanUserRoles")
const userTbody = document.getElementById("userTbody")
const userButtonEdit = document.getElementById("buttonUserEditId")
const userButtonDelete = document.getElementById("buttonUserDeleteId")
const allUserBox = document.getElementById("users")
const newUserBox = document.getElementById("newUser")
const abouUserBox = document.getElementById("myTabContent")

adminPaneler()

function adminPaneler() {
    const url = "http://localhost:8080/admin/api/users/"
    fetch(url)
        .then(jFetch => jFetch.json())
        .then(jdata => {
            allUserBox.style.display = "block"
            newUserBox.style.display = "none"
            abouUserBox.style.display = "none"
            let dateTable = ''
            jdata.forEach(data => {
                dateTable += '<tr>'
                dateTable += '<td>' + data.id + '</td>'
                dateTable += '<td>' + data.name + '</td>'
                dateTable += '<td>' + data.age + '</td>'
                dateTable += '<td>' + data.email + '</td>'
                dateTable += '<td>' + data.rolesString + '</td>'

                window.usersTableButton.setAttribute("class", "nav-link active")
                window.newUserButton.setAttribute("class", "nav-link")
                window.adminBut.setAttribute("class", "list-group-item active")
                window.userBut.setAttribute("class", "list-group-item")

                userButtonEdit.setAttribute('onclick', 'editUserModal(' + data.id + ')')//editUserModal(data)
                dateTable += '<td>' + userButtonEdit.outerHTML + '</td>'
                userButtonDelete.setAttribute('onclick', 'deleteUserModal(' + data.id + ')')
                dateTable += '<td>' + userButtonDelete.outerHTML + '</td>'

                dateTable += '</tr>'


            })
            userTbody.innerHTML = dateTable

        })

}

function userInfo() {
    window.adminBut.setAttribute("class", "list-group-item")
    window.userBut.setAttribute("class", "list-group-item active")
    allUserBox.style.display = "none"
    newUserBox.style.display = "none"
    abouUserBox.style.display = "block"

}