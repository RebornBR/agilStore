package com.aceleradora.agilStore.services;

import com.aceleradora.agilStore.model.dto.ProdutoResponseDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class GeradorJson {

    public void gerarJson(List<ProdutoResponseDTO> produtoResponseDTOS)throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escreverJson = new FileWriter("produtos.json");
        escreverJson.write(gson.toJson(produtoResponseDTOS));
        escreverJson.close();
    }
}
