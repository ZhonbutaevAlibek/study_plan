package com.example.demo.rest;

import com.example.demo.entities.SalesEntity;
import com.example.demo.exceptions.SaleNotFoundException;
import com.example.demo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity addSale(@RequestBody SalesEntity sale,
                                  @RequestParam Long book_id,
                                  @RequestParam Long employee_id){
        try{
            saleService.addSale(sale, book_id, employee_id);
            return ResponseEntity.ok(saleService.addSale(sale, book_id, employee_id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error!!!");
        }
    }

    @GetMapping
    public ResponseEntity getOneSale(@RequestParam Long id){
        try{
            return ResponseEntity.ok(saleService.getOne(id));
        } catch (SaleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!!!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSale(@PathVariable Long id){
        try{
            return ResponseEntity.ok(saleService.delete(id));
        } catch (SaleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!!!");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody SalesEntity sale,
                                     @RequestParam Long sale_id,
                                     @RequestParam Long book_id,
                                     @RequestParam Long employee_id){
        try{
            return ResponseEntity.ok(saleService.update(sale, sale_id, book_id, employee_id));
        }catch(SaleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
