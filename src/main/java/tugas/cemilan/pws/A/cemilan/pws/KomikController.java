/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package tugas.cemilan.pws.A.cemilan.pws;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FADHIL
 */
@CrossOrigin
@RestController
@RequestMapping("/data")
public class KomikController {
    @Autowired
    private KomikRepository komik;
    
    @GetMapping("/komik")
    public List<Komik> getAllKomik(){
        return komik.findAll();
    }
    
    @GetMapping ("/komik/{idkomik}")
    public Komik getKomikById(@PathVariable String idkomik){
        return komik.findById(idkomik).get();
    }
    
    @PostMapping ("/komik")
    public Komik saveKomikDetails(@RequestBody Komik s){
        return komik.save(s);
    }
    
    @PutMapping("/komik")
    public Komik updateKomik(@RequestBody Komik s){
        return komik.save(s);
    }
    
    @DeleteMapping("/komik/{idkomik}")
    public ResponseEntity<HttpStatus> deleteKomikById(@PathVariable String idkomik){
        komik.deleteById(idkomik);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
