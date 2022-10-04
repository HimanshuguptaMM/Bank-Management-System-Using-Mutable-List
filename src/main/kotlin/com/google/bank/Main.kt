package com.google.bank


import java.util.Scanner

val bankUser = mutableListOf<BankUser>()
fun createUser() {
    val scanner = Scanner(System.`in`)
    println("enter the User Name")
    val ownerName = scanner.nextLine()
    println("$ownerName ,please enter the AccountName")
    val accountName = scanner.nextLine()
    println("enter recent amount")
    val recentAmount = scanner.nextDouble()
    println("Your Recent Amount $recentAmount")
    var depositAmount = scanner.nextDouble()
    println("Deposited Amount $depositAmount")
    var totalAmount =recentAmount+depositAmount
    println("Total Amount is $totalAmount")
    val employeeList = mutableListOf<Employee>()
    bankUser.add(BankUser(ownerName, totalAmount, mutableListOf(Account(accountName, recentAmount, totalAmount))))


}

fun getUser() {
    bankUser.forEach {
        println(it)
    }
}

fun createAccountForUser() {
    val systemIn = Scanner(System.`in`)
    println("ask for the UserName")
    val ownerName = systemIn.nextLine()
    val findUser = bankUser.find {
        it.ownername == ownerName
    }

    var totalAmount: Double = 0.0
    findUser?.accounts?.forEach {
        totalAmount = (totalAmount + it.Amount)
    }
    if (findUser != null) {
        println(ownerName)
    } else {
        println("Username Not found!")
    }
    val accountName = Scanner(System.`in`).nextLine()
    println("Account Name is $accountName ")

    val TotalAmount = Scanner(System.`in`).nextDouble()

    println("Total amount is $TotalAmount")
    val account = mutableListOf<Account>()
    account.add(Account(accountName, 10.9, 0.0))

}

fun disableAccount() {
    val systemIn = Scanner(System.`in`)
    println("choose the account which you want disable")
    for (bankUser in bankUser) {
        println("do you want disable")
        val yes = systemIn.nextBoolean()
        if (yes) {
            println("disable account")
            break
        }
    }
}

fun main() {
    askUserAgain()
}

object MyConstent {
    const val CreateUser = 1
    const val GetUser = 2
    const val CreateAccount = 3
    const val disableAccount = 4
}

fun askUserAgain() {
    showOptions()
    val scannerInput = Scanner(System.`in`)
    processOption(scannerInput.nextInt())
}

fun processOption(optionThatUserChoose: Int) {
    when (optionThatUserChoose) {
        MyConstent.CreateUser -> {
            createUser()
        }

        MyConstent.GetUser -> {
            getUser()
        }

        MyConstent.CreateAccount -> {
            createAccountForUser()
        }

        MyConstent.disableAccount -> {
            disableAccount()
        }
    }
    askUserAgain()
}


fun showOptions() {
    println("Hello!Welcome to bank")

    println("${MyConstent.CreateUser}. Create User")
    Thread.sleep(500)
    println("${MyConstent.GetUser}. GetUser")
    Thread.sleep(500)
    println("${MyConstent.CreateAccount}. Create Account")
    Thread.sleep(500)
    println("${MyConstent.disableAccount}. Disable Account")
}


data class BankUser(var ownername: String, val TotalAmount: Double, var accounts: MutableList<Account>)
data class Employee(var BankName: String, var ifscCode: String)
data class Account(var AccountName: String, var Amount: Double, var depositedAmount: Double)