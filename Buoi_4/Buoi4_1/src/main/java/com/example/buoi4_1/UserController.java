package com.example.buoi4_1;


import com.example.buoi4_1.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping
    public ResponseEntity<?> getUser(@RequestBody UserDTO userDTO) {
        // lưu vào db
        // Query data ==> trả về

        if(userDTO.getUsername().equals("")){
            throw new NotFoundException("user rỗng");
        }
        return ResponseEntity.status(200).body(userDTO);
    }
}
