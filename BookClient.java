package com.junfan.books;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookClient {
	public static void main(String [] args) {
		
		String command = "";
		Scanner sc = new Scanner(System.in);
		BookOperationImpl bo = new BookOperationImpl();
		
		while(!command.contentEquals("quit")) {
			System.out.println("insert/retrieve/update/delete");
			command = sc.next();
			if(command.contentEquals("insert")) {
				System.out.println("Normal Book(n)/SE Book(s)/IN Book(i)");
				String prompt = sc.next();
				if(prompt.equals("n")) {
					Book book = new Book();
					System.out.println("Enter Book id: ");
					book.setBook_id(sc.nextInt());
					System.out.println("Enter book title: ");
					book.setBook_title(sc.next());
					System.out.println("Enter book author: ");
					book.setAuthor(sc.next());
					System.out.println("Enter book cost: ");
					book.setCost(sc.nextDouble());
					bo.insert(book);
					
				}else if(prompt.equals("s")) {
					SEBook book = new SEBook();
					System.out.println("Enter Book id: ");
					book.setBook_id(sc.nextInt());
					System.out.println("Enter book title: ");
					book.setBook_title(sc.next());
					System.out.println("Enter book author: ");
					book.setAuthor(sc.next());
					System.out.println("Enter book cost: ");
					book.setCost(sc.nextDouble());
					System.out.println("Enter book special feature: ");
					book.setSpecial_feature(sc.next());
					bo.insert(book);
				}else if(prompt.equals("i")){
					INBook book = new INBook();
					System.out.println("Enter Book id: ");
					book.setBook_id(sc.nextInt());
					System.out.println("Enter book title: ");
					book.setBook_title(sc.next());
					System.out.println("Enter book author: ");
					book.setAuthor(sc.next());
					System.out.println("Enter book cost: ");
					book.setCost(sc.nextDouble());
					System.out.println("Enter book Language: ");
					book.setLanguage(sc.next());
					bo.insert(book);
				}
			}else if(command.contentEquals("delete")) {
				System.out.println("Enter the id you want to delete: ");
				bo.delete(sc.nextInt());
			}else if(command.contentEquals("update")) {
				System.out.println("Enter the id you want to update: ");
				bo.update(sc.nextInt());
			}else if(command.contentEquals("retrieve")){
				System.out.println("Enter the id you want to retrieve: ");
				bo.retrieve(sc.nextInt());
			}else {
				System.out.println("Command not correct");
			}
		}
	}
}
