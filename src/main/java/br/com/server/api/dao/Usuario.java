package br.com.server.api.dao;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;

@Data // ← ESTA anotação vem em cima da classe
@Document(collection = "cadastro")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;

}
