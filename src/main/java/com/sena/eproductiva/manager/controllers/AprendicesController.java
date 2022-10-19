package com.sena.eproductiva.manager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aprendices")
public class AprendicesController {
    /*
     * 
     * @Autowired
     * private AprendicesService aprendicesService;
     * 
     * @GetMapping()
     * public @ResponseBody ResponseEntity<List<AprendizDto>> getAllAprendices() {
     * List<AprendizDto> response = aprendicesService.getAllAprendizDtos();
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @GetMapping("/{id}")
     * public @ResponseBody ResponseEntity<List<AprendizDto>>
     * getAprendicesById(@PathVariable("id") long id) {
     * List<AprendizDto> response = aprendicesService.getAprendizDtoById(id);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @PutMapping("/")
     * public @ResponseBody ResponseEntity<?> updateAprendices(@RequestBody Aprendiz
     * aprendicesEntity) {
     * Aprendiz response = aprendicesService.updateAprendiz(aprendicesEntity);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @PostMapping("/")
     * public @ResponseBody ResponseEntity<?> createAprendiz(@RequestBody Aprendiz
     * aprendicesEntity) {
     * Aprendiz response = aprendicesService.createAprendiz(aprendicesEntity);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @DeleteMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> dropAprendiz(@PathVariable("id") long
     * id) {
     * aprendicesService.deleteAprendiz(id);
     * return new ResponseEntity<>("centro inhabilitado con exito",
     * HttpStatus.ACCEPTED);
     * }
     */

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}