
class LogInPO {
    visit() {
        // Define actions to visit the login page
        cy.visit("http://localhost:8080")
    }
    type(username, password) {
        // cy.get('#user-name').type(username)
        // cy.get('#password').type(password)
    }
    login() {
        // cy.get('#login-button').click()
    }



}
export default new LogInPO();