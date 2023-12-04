package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {


    @Test
    void testFindById(){
        BookRepository bookRepositoryMock = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        when(bookRepositoryMock.findById("1")).thenReturn(new Book("1","Title1","Author1"));

        Book result = bookService.findBookById("1");

        verify(bookRepositoryMock).findById("1");
        assertThat(result.getTitle()).isEqualTo("Title1");
    }

    @Test
    void testFindAllBooks(){
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        when(bookRepositoryMock.findAll()).thenReturn(Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")));

        List<Book> allBooks = bookService.findAllBooks();

        verify(bookRepositoryMock, times(1)).findAll();
        assertThat(allBooks.size()).isEqualTo(2);
    }

}