package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

 //  private static List<Book> list=new ArrayList<>();

    /*static{
         list.add(new Book(12,"Spring Boot","Durgesh"));
        list.add(new Book(143,"React Frontend","Tanay "));
        list.add(new Book(12,"My Sql","Microsoft"));

    }*/
    //get All Books
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;

    }
    //get Single Book by id
    public Book getBookBYId(int id){
        Book book=null;
        try{
      // book= list.stream().filter(e->e.getId()==id).findFirst().get();
      book=this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return book;

    }
    //adding the book
    public Book addBook(Book b){
     Book Result=  bookRepository.save(b);
        return Result;

    }
    //Deleting Book
    public void deleteBook(int bid){
     // list=  list.stream().filter(book->book.getId()!=bid)
     // .collect(Collectors.toList());
     bookRepository.deleteById(bid);
    }
    //Updating Book
    public void updateBook(Book book,int bookId){
     /*  list=  list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }

        
        return b;
    }).collect(Collectors.toList());
    }*/

    book.setId(bookId);
    bookRepository.save(book);

    
}
}
