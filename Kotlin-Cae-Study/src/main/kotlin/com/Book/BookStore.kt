package com.Book

class BookStore {

    var dbConnection = dbConnection()
    var connection = dbConnection.connect()
    var books=mutableListOf<Book>()
    //Book Add
    fun BookAdd(book:Book){
        val prepareStmt=connection.prepareStatement("insert into Book values(?,?,?,?,?)")
        prepareStmt.setString(1,book.bookId)
        prepareStmt.setString(2,book.title)
        prepareStmt.setString(3,book.author)
        prepareStmt.setString(4,book.category)
        prepareStmt.setFloat(5,book.price)

        val result =prepareStmt.executeUpdate()

        if (result>0){
            println("Book details added Successfully!!!!")
        }
        else{
            println("..not Added...")
        }
    }
    //Search By Book Title.....
    fun searchByTitle(title:String){
        val prepare = connection.prepareStatement("select * from Book where title=(?)")
        prepare.setString(1,title)
        val res = prepare.executeQuery()
        while (res.next()) {
            val bookId = res.getString("bookId")
            val title=res.getString("title")
            val author = res.getString("author")
            val category = res.getString("category")
            val price = res.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
            }
        for (book in books) {
            println(book)
        }
    }
    //Search By Book Author...
    fun searchByAuthor(author:String){
        val prepare = connection.prepareStatement("select * from Book where author=(?)")
        prepare.setString(1,author)
        val res = prepare.executeQuery()
        while (res.next()) {
            val bookId = res.getString("bookId")
            val title=res.getString("title")
            val author = res.getString("author")
            val category = res.getString("category")
            val price = res.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        for (book in books) {
            println(book)
        }
    }
    //search By Title and Author
    fun searchByAuthorTitle(author:String,title:String){
        val prepare = connection.prepareStatement("select * from Book where author=(?) and title=(?)")
        prepare.setString(1,author)
        prepare.setString(2,title)
        val res = prepare.executeQuery()
        while (res.next()) {
            val bookId = res.getString("bookId")
            val title=res.getString("title")
            val author = res.getString("author")
            val category = res.getString("category")
            val price = res.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        for (book in books) {
            println(book)
        }
    }
    //Display All Book Details..
    fun DisplayAllBooks() {
        val query = connection.prepareStatement("select * from Book")
        val res = query.executeQuery()
        while (res.next()) {
            val bookId = res.getString("bookId")
            val title=res.getString("title")
            val author = res.getString("author")
            val category = res.getString("category")
            val price = res.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        for (book in books) {
            println(book)
        }
    }
    //Modify Book Details by Enter Bookid
    fun UpdateBookDetails(book:Book,title:String){
        val prepareStmt = connection.prepareStatement("update Book set bookId=?,title=?,author=?,category=?,price=? where title=?")
        prepareStmt.setString(1,book.bookId)
        prepareStmt.setString(2,book.title)
        prepareStmt.setString(3,book.author)
        prepareStmt.setString(4,book.category)
        prepareStmt.setFloat(5,book.price)
        prepareStmt.setString(6,title)
        val result =prepareStmt.executeUpdate()

        if (result>0){
            println("Book details Updated Successfully!!!!")
        }
        else{
            println("..not Updated...")
        }

    }

    //Delete Book Details By BookId
    fun DeleteBook(bookId: String) {
        val stmt = connection.createStatement()
        var res = stmt.executeUpdate("delete from Book where bookId=bookId")
        if (res > 0) {
            println("successfully Deleted record in Book Table!!!")
        } else {
            println("Update Not sucessful")
        }
    }
    //Display Specific Book detals
    fun DisplaySpecific(bookId:String){
        val query = connection.prepareStatement("select * from Book where bookId=(?)")
        query.setString(1,bookId)
        val res = query.executeQuery()
        while (res.next()) {
            val bookId = res.getString("bookId")
            val title=res.getString("title")
            val author = res.getString("author")
            val category = res.getString("category")
            val price = res.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        for (book in books) {
            println(book)
        }
    }
    }

