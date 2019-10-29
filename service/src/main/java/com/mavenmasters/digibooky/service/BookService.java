package com.mavenmasters.digibooky.service;


import com.mavenmasters.digibooky.domain.book.Book;
import com.mavenmasters.digibooky.domain.db.BookDB;
import com.mavenmasters.digibooky.service.dto.BookDtoForMembers;
import com.mavenmasters.digibooky.service.dto.BookDtoForUsers;
import com.mavenmasters.digibooky.service.dto.BookMapper;
import com.mavenmasters.digibooky.service.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class BookService {
    private final BookDB bookDB;
    private final BookLoanService bookLoanDB;
    private final MemberService memberService;

    @Autowired
    public BookService(BookLoanService bookLoanDB, MemberService memberService) {
        this.bookDB = new BookDB();
        this.bookLoanDB = bookLoanDB;
        this.memberService = memberService;
    }

    public BookDtoForUsers getDetailsOfBookForUsers(UUID uuid) {
        return BookMapper.mapToDto(this.bookDB.getById(uuid));
    }

    public BookDtoForUsers getBookByTitle(String title) {
        return BookMapper.mapToDto(this.bookDB.getByTitle(title));
    }

    public BookDtoForUsers getBookByISBN(String isbn) {
        return BookMapper.mapToDto(this.bookDB.getByISBN(isbn));
    }

    public BookDtoForUsers getBookByAuthor(String name) {
        return BookMapper.mapToDto(this.bookDB.getByAuthor(name));
    }

    public List<BookDtoForUsers> getAllBooks() {
        return this.bookDB.getAll()
                .values()
                .stream()
                .map(BookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public BookDtoForUsers addBook(BookDtoForUsers book) {
        return BookMapper.mapToDto(
                this.bookDB.addBook(
                        BookMapper.mapDtoToBook(book)));
    }

    public BookDtoForUsers deleteBook(UUID uuid) {
        return BookMapper.mapToDto(this.bookDB.deleteBook(uuid));
    }

    public BookDtoForUsers updateBook(Book book) {
        return BookMapper.mapToDto(this.bookDB.updateBook(book));
    }

    public BookDtoForMembers getDetailsOfBookForMembers(UUID bookUuid) {
        Book book = this.bookDB.getById(bookUuid);
        MemberDto member = memberService.getMemberById(bookLoanDB.getNonReturnedBookLoanByBookUuid(book.getId()).getMemberId());

        return BookMapper.mapToDtoForMember(book, book.isAvailable(), member);
    }

}
