package com.personal.Literalura.ui;

import com.personal.Literalura.model.Book;
import com.personal.Literalura.service.AuthorService;
import com.personal.Literalura.service.BookService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInterface {
    private final Scanner scanner;
    private final BookService bookService;
    private final AuthorService authorService;

    public UserInterface(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("--------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("1- Buscar livro pelo título");
        System.out.println("2- Listar livros registrados");
        System.out.println("3- Listar autores registrados");
        System.out.println("4- Listar autores vivos em um determinado ano");
        System.out.println("5- Listar livros em um determinado idioma");
        System.out.println("0- Sair");

        int option = Integer.parseInt(this.scanner.nextLine());

        switch (option) {
            case 1:
                System.out.print("Digite o nome do livro: ");
                String bookName = this.scanner.nextLine();
                Book book = this.bookService.getBookByName(bookName);
                System.out.println(book);
                break;
            case 2:
                this.bookService.listBooks().forEach(System.out::println);
                break;
            case 3:
                this.authorService.listAuthors().forEach(author -> System.out.println(author.getName()));
                break;
            case 4:
                System.out.print("Digite o ano: ");
                int year = Integer.parseInt(this.scanner.nextLine());
                this.authorService.listAuthorsAliveIn(year).forEach(author -> System.out.println(author.getName()));
                break;
            case 5:
                System.out.print("Digite o idioma: ");
                String language = this.scanner.nextLine();
                this.bookService.listBooksByLanguage(language).forEach(System.out::println);
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}
