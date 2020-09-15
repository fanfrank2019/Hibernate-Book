package com.junfan.books;

public interface BookOperation {
	public void insert(Book b);
	public void retrieve(int id);
	public void update(int id);
	public void delete(int id);
	public void list();
}
