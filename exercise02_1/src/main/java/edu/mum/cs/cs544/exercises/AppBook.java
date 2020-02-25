package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class AppBook {

	
	private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;
 // Hibernate placeholders
   static Session session = null;
   static Transaction tx = null;
    
    
	    static {
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                configuration.getProperties()).build();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    }
	    
	    static void RetrieveAllBooks() {
	    	
	    	try {
	            session = sessionFactory.openSession();
	            tx = session.beginTransaction();

	            // retieve all Books
	            @SuppressWarnings("unchecked")
	            List<Book> bookList = session.createQuery("from Book").list();
	            for (Book book : bookList) {
	                System.out.println("Tittle= " + book.getTitle() + ", ISBN= "
	                        + book.getISBN() + ", Author= " + book.getAuthor()+", price= " + book.getPrice()+", Publish_date= " + book.getPublish_date());
	            }
	            tx.commit();

	        } catch (HibernateException e) {
	            if (tx != null) {
	                System.err.println("Rolling back: " + e.getMessage());
	                tx.rollback();
	            }
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	    	
	    }
	    
	    
	    

	    public static void main(String[] args) throws ParseException {
	        
	    	
	        try {
	            session = sessionFactory.openSession();
	            tx = session.beginTransaction();
	            
	            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
	           
	            // Create new instance of Book1 and set values in it
	            Book book1=new Book("enginnering", "1234", "Nelson", 5000.10, df.parse("07/15/2000"));
	            session.persist(book1);
	            
	            // Create new instance of Book2 and set values in it
	            Book book2=new Book("Animal_farm", "1678", "George", 6000.7, df.parse("04/9/1998"));
	            // save the Book2
	            session.persist(book2);
	            
	         // Create new instance of Book3 and set values in it
	            Book book3=new Book("Eclipse", "3000", "Meyer", 7889.66, df.parse("14/12/1980"));
	            // save the Book2
	            session.persist(book3);

	            tx.commit();

	        } catch (HibernateException e) {
	            if (tx != null) {
	                System.err.println("Rolling back: " + e.getMessage());
	                tx.rollback();
	            }
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }

	        RetrieveAllBooks();
	        
	        try {
	            session = sessionFactory.openSession();
	            tx = session.beginTransaction();

	            // retrieve a Book
	            @SuppressWarnings("unchecked")
	         Book book11 = (Book) session.get(Book.class,1);
	            book11.setTitle("Amazing_Race");
	            book11.setPrice(700.7);
	            Book book12 = (Book) session.load(Book.class,2);
	            session.delete(book12);
	            
	            tx.commit();

	        } catch (HibernateException e) {
	            if (tx != null) {
	                System.err.println("Rolling back: " + e.getMessage());
	                tx.rollback();
	            }
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	        
	        RetrieveAllBooks();
	        
	        // Close the SessionFactory (not mandatory)
	        sessionFactory.close();
	        System.exit(0);
	    }
	}


