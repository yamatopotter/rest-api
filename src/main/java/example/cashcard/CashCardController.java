package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    private ICashCardRepository cashCardRepository;

    public CashCardController(ICashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository;
    }
    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById(@PathVariable Long requestedId){
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);

        if(cashCardOptional.isPresent()){
            return ResponseEntity.ok(cashCardOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
