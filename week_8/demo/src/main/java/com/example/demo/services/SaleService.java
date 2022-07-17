package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.exceptions.BookAlreadyExistException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.exceptions.SaleAlreadyExistException;
import com.example.demo.exceptions.SaleNotFoundException;
import com.example.demo.models.Book;
import com.example.demo.models.Sale;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.EmployeeRepo;
import com.example.demo.repositories.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    SaleRepo saleRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    public Sale addSale(SalesEntity sale, Long book_id, Long employee_id) {

        BookEntity book = bookRepo.findById(book_id).get();
        EmployeeEntity employee = employeeRepo.findById(employee_id).get();
        sale.setBook(book);
        sale.setEmployee(employee);
        saleRepo.save(sale);

        return Sale.toModel(sale);
    }

    public Sale getOne(Long id) throws SaleNotFoundException {
        SalesEntity sale = saleRepo.findById(id).get();
        if(sale == null){
            throw new SaleNotFoundException("This sale not found :(");
        }

        return Sale.toModel(sale);
    }

    public String delete(Long id) throws SaleNotFoundException {
        SalesEntity sale = saleRepo.findById(id).get();
        if(sale == null){
            throw new SaleNotFoundException("This sale not found :(");
        }
        saleRepo.deleteById(id);
        return "Sale has been deleted";
    }


    public Sale update(SalesEntity editedSale,
                       Long sale_id,
                       Long book_id, Long employee_id) throws SaleNotFoundException {

        SalesEntity sale = saleRepo.findById(sale_id).get();
        BookEntity book = bookRepo.findById(book_id).get();
        EmployeeEntity employee = employeeRepo.findById(employee_id).get();

        if(sale == null){
            throw new SaleNotFoundException("This sale not found :(");
        }

        sale.setDate(editedSale.getDate());
        sale.setBook(book);
        sale.setEmployee(employee);
        sale.setAmount(editedSale.getAmount());
        sale.setSum(editedSale.getSum());
        saleRepo.save(sale);

        return Sale.toModel(sale);
    }
}
