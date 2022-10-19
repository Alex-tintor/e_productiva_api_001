package com.sena.eproductiva.manager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fichas")
public class FichasController {

    /*
     * @Autowired
     * private FichasService fichasService;
     * 
     * @GetMapping("/")
     * public @ResponseBody ResponseEntity<List<FichaDto>> getAllFichas() {
     * List<FichaDto> response = fichasService.getAllFichaDtos();
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @GetMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> getFichasById(@PathVariable("id") long
     * id) {
     * Optional<FichaEntity> response = fichasService.getFichaById(id);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @PutMapping("/")
     * public @ResponseBody ResponseEntity<?> updateFichas(@RequestBody FichaEntity
     * fichasEntity) {
     * FichaEntity response = fichasService.createFicha(fichasEntity);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @PostMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> createFicha(@RequestBody FichaEntity
     * fichasEntity,
     * 
     * @PathVariable("id") long id) {
     * FichaEntity response = fichasService.createFicha(fichasEntity);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @DeleteMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> deleteFichaById(@PathVariable("id")
     * long id) {
     * fichasService.deleteFichaById(id);
     * return new ResponseEntity<>("ficha Inhabilitada con exito",
     * HttpStatus.ACCEPTED);
     * }
     */

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}