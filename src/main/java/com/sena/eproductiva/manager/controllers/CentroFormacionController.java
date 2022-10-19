package com.sena.eproductiva.manager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centros")
public class CentroFormacionController {
    /*
     * @Autowired
     * private CentroFormacionService centroFormacionService;
     * 
     * @GetMapping()
     * public @ResponseBody ResponseEntity<List<CentroFormacionDto>>
     * getAllCentroFormacion() {
     * List<CentroFormacionDto> response =
     * centroFormacionService.getAllCentroFormacionDtos();
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @GetMapping("/{id}")
     * public @ResponseBody ResponseEntity<?>
     * getCentroFormacionById(@PathVariable("id") long id) {
     * Optional<CentroFormacionEntity> response =
     * centroFormacionService.getCentroFormacionById(id);
     * return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
     * }
     * 
     * @PutMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> updateCentroFormacion(@RequestBody
     * CentroFormacionEntity centroEntity) {
     * CentroFormacionEntity response =
     * centroFormacionService.updateCentro(centroEntity);
     * return new ResponseEntity<>(response, HttpStatus.OK);
     * }
     * 
     * @PostMapping("/{centroEntity}")
     * public @ResponseBody ResponseEntity<?> createCentroFormacion(@RequestBody
     * CentroFormacionEntity centroEntity){
     * CentroFormacionEntity response =
     * centroFormacionService.createCentro(centroEntity);
     * return new ResponseEntity<>(response, HttpStatus.CREATED);
     * }
     * 
     * @DeleteMapping("/{id}")
     * public @ResponseBody ResponseEntity<?>
     * dropCentroFormacion(@PathVariable("id") Long id) {
     * centroFormacionService.deleteCentro(id);
     * return new ResponseEntity<>("centro inhabilitado con exito",
     * HttpStatus.ACCEPTED);
     * }
     */

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}