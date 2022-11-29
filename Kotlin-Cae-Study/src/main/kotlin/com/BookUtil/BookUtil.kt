package com.BookUtil
import com.Book1.Exception.InvalidBookException
import  java.util.Scanner
import com.Book.Book
import com.Book.BookStore

fun main(args:Array<String>) {
    println("1.Add" + "\t" + "2.Search By Other" + "\t" + "3.Search By Title" + "\t" + "4.Search By title & author" + "\t" + "5.Display Specific " + "\t" + "6.Delete" + "\t" + "7.Modify" + "\t" + "8.Display All" + "\t" + "9.Exit")
    var Bookstore = BookStore()
    for (i in 1..3) {
        var scanner = Scanner(System.`in`)
        println("Enter the " + "$i" + " Book Details: ")
        print("BookId:")
        var bookId = scanner.next()
        //Validation Chaeck BookId
        try{
        if (bookId.get(0) != 'B' || (bookId.length < 4) || (bookId.length > 4)) {
            throw InvalidBookException("InvalidBookException")
        }}catch(e:Exception){
            println("...Book Id Should Maintain Starts with B and length 4...")
        }
        print("Title:")
        var title = scanner.next()
        print("Author:")
        var author = scanner.next()
        print("Category:")
        //Validation Check Category
        var category = scanner.next();
        var sc: String = "Science"
        var ot: String = "Others"
        var fc: String = "Fiction"
        var te: String = "Technology"
        try{
        if (category == sc || category == ot || category == fc || category == te) {
            category = category
        } else {
            throw InvalidBookException("InvalidBookException")
        }}catch(e:Exception){
            println("...Category must conatin Science or Others or Fiction or Technology..")
        }
        print("Price:");
        var price = scanner.nextFloat()
        //Validation check price
        try{
        if (price < 0) {
            throw InvalidBookException("InvalidBookException")
        }}catch(e:Exception){
            println("...Price should contain Greater then 0...")
        }
        var Book = Book(bookId, title, author, category, price)
        Bookstore.BookAdd(Book)
    }
    var scanner = Scanner(System.`in`)
    println("Enter The which Option You want: ")
    var op = scanner.nextInt()
    when (op) {
        //Search the book by Author

        2 -> {
            println("=======Search the book by Author=======")
            print("Author:")
            var author = scanner.next()
            Bookstore.searchByAuthor(author)
        }

        3 -> {//Search the book by Title
            println("=======Search the book by Title=======")
            print("Title:")
            var title = scanner.next()
            Bookstore.searchByTitle(title)
        }

        4 -> {//Search the book by Title and author
            println("=====Search the book by author and Title====")
            print("Author:")
            var Author = scanner.next()
            print("Title:")
            var Title = scanner.next()
            Bookstore.searchByAuthorTitle(Author, Title)
        }

        5 -> { //Display specific book details
            println("=====Display specific book details by Bookid====");
            var bookId = scanner.next()
            Bookstore.DisplaySpecific(bookId)
        }

        6 -> {//Delete the Book Details
            println("======Delete the Book details by bookid======")
            var bookId = scanner.next()
            Bookstore.DeleteBook(bookId)
        }

        7 -> {//Modify book details
            println("===Enter the title for modifying the book Id ===")
            print("Enter title Where Updated All bookDetails:")
            var title1 = scanner.next()
            print("BookId:")
            var bookId = scanner.next()
            print("title:")
            var title = scanner.next()
            print("author:")
            var author = scanner.next()
            print("category:")
            var category = scanner.next()
            print("price:")
            var price = scanner.nextFloat()
            var Book = Book(bookId, title, author, category, price)
            Bookstore.UpdateBookDetails(Book,title1)
        }

        8 -> {
            Bookstore.DisplayAllBooks()
        }

        9 -> {
            println("...Program Ended...")
            System.exit(0)
        }
    }
}

