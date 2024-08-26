package br.com.emanuelcosta.barbershop.resources;

import br.com.emanuelcosta.barbershop.entities.Client;
import br.com.emanuelcosta.barbershop.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = clientService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client obj){
        obj = clientService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj){

        obj = clientService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete ( @PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
