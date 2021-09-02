function createUser() {
    abouUserBox.style.display = "none"
    allUserBox.style.display = "none"
    newUserBox.style.display = "block"
    window.usersTableButton.setAttribute("class", "nav-link")
    window.newUserButton.setAttribute("class", "nav-link active")
    window.usersTableButton.value = ""
    window.newUserButton.value = ""
    window.nameCr.value = ""
    window.ageCr.value = ""
    window.emailCr.value = ""
    window.passwordCr.value = ""
    window.roleId0c.checked = false
    window.roleId1c.checked = false

}
