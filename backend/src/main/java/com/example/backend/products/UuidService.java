package com.example.backend.products;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@NoArgsConstructor
public class UuidService {

    public String getRandomId(){
        return UUID.randomUUID().toString();
    }

}
