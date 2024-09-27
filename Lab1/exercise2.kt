open class Person(val name: String, val age: Int, val email: String) {
    open fun displayInfo() {
        println("Name: $name, Age: $age, Email: $email")
    }
}

class Employee(name: String, age: Int, email: String, val salary: Double) : Person(name, age, email) {
    override fun displayInfo() {
        println("Name: $name, Age: $age, Email: $email, Salary: $salary")
    }
}

class BankAccount(private var balance: Double) {
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited: $$amount, new balance: $$balance")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrawn: $$amount, New Balance: $$balance")
        } else { 
            println("Not enough balance or incorrect amount")
        }
    }

    fun getBalance() = balance
}

fun main() {
    val person = Person("Temirlan", 22, "test@nowhere.com")
    person.displayInfo()

    val employee = Employee("Temirlan2", 18, "test2@nowhere.com", 50000.0)
    employee.displayInfo()
    
    val account = BankAccount(500.0)

    account.deposit(500.0)
    account.withdraw(100.0)
    account.withdraw(1000.0)

    println("Balance: ${account.getBalance()}")
}


