package huy.bai911.controllor;

import huy.bai911.module.Product;
import huy.bai911.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class Controller {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllTrainer() {
        List<Product> customers = productService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Product> findTrainerById(@PathVariable Long id){
        Optional<Product> trainerOptional=productService.findById(id);
        if(!trainerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainerOptional.get(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> createTrainer(@RequestBody Product trainer){
        return new ResponseEntity<>(productService.save(trainer), HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/edit/{id}")
    public ResponseEntity<Product> editTrain(@PathVariable Long id, @RequestBody Product trainer) {
        Optional<Product> playerOptional = productService.findById(id);
        if (!playerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        trainer.setId(id);
        productService.save(trainer);
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }
}
