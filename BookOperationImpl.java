package com.junfan.books;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class BookOperationImpl implements BookOperation{
	
	private SessionFactory fact;
	private Session ses;
	private Transaction tx;
	private Scanner sc;
	
	public BookOperationImpl() {
		fact = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
				.addAnnotatedClass(SEBook.class).addAnnotatedClass(INBook.class).buildSessionFactory();
		ses = fact.openSession();
		sc = new Scanner(System.in);
	}
	
	public void insert(Book b) {
		tx = ses.beginTransaction();
		ses.save(b);
		tx.commit();	
	}

	public void retrieve(int id) {
		
		Book b = ses.get(Book.class, id);
		System.out.println(b.toString());
	}

	public void update(int id) {
		tx = ses.beginTransaction();
		Book b = ses.get(Book.class, id);
		System.out.println("Update book title: ");
		b.setBook_title(sc.next());
		System.out.println("Update book author: ");
		b.setAuthor(sc.next());
		System.out.println("Update book cost: ");
		b.setCost(sc.nextDouble());
		tx.commit();
	}

	public void delete(int id) {
		tx = ses.beginTransaction();
		Book b = ses.get(Book.class, id);
		ses.delete(b);
		tx.commit();
	}

	public void list() {
		//tx = ses.beginTransaction();
		Query q = ses.createQuery("from Book");
		List<Book> l = q.list();
		for(Book b : l) {
			System.out.println(b.toString());
		}
	}
	
}
