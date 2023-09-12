package com.example.musculacion.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/musculacion")
public class MControllers {

    @GetMapping("/{nombre}")
    public String nombre(@PathVariable String nombre) {
        return "Hola " + nombre + ":" + "\nBienvenido a la calculadora de musculación, si quieres saber esta informacion escribelas en la url despues de musculacion: \n" +
                "1. /imc -> Para saber tu imc, \n" +
                "2. /proteina -> Para saber la cantidad de proteinas que necesitas, \n" +
                "3. /calorias -> Para saber las calorias que necesitas. \n" +
                "4. /apuntarse -> Para apuntarte al gimnasio. \n";
    }

    @PostMapping("/imc")
    public String imc(@RequestParam int peso, @RequestParam float altura) {

        float imc = peso / (altura * altura);
        String mensaje = "";

        Map<String, Float> categorias = new LinkedHashMap<>() {{
            put("Estas bajo de peso. Tu indice de masa corporal es: ", 18.5f);
            put("Estas en tu peso ideal. Tu indice de masa corporal es: ", 24.9f);
            put("Tienes sobrepeso. Tu indice de masa corporal es: ", 29.9f);
            put("Tienes obesidad tipo 1. Tu indice de masa corporal es: ", 34.9f);
            put("Tienes obesidad tipo 2. Tu indice de masa corporal es: ", 39.9f);
            put("Tienes obesidad tipo 3. Tu indice de masa corporal es: ", Float.MAX_VALUE);
        }};

        for (Map.Entry<String, Float> entry : categorias.entrySet()) {
            if (imc <= entry.getValue()) {
                mensaje = entry.getKey() + imc;
                break;
            }
        }

        return mensaje;
    }

    @PostMapping("proteina")
    public String proteina(@RequestParam int peso, @RequestParam String actividad) {

        Map<String, Float> actividadProteina = Map.of(
                "sedentario", 0.8f,
                "ligera", 1.3f,
                "moderada", 1.6f,
                "intensa", 1.8f,
                "muy intensa", 2f
        );

        float proteina = 0;
        if (actividadProteina.containsKey(actividad)) {
            proteina = peso * actividadProteina.get(actividad);
        } else {
            return "Actividad inválida";
        }

        return "La cantidad de proteina que debes consumir es: " + proteina;
    }

    @PostMapping("calorias")
    public String calorias(@RequestParam int peso, @RequestParam float altura, @RequestParam int edad, @RequestParam String sexo, @RequestParam String actividad) {

        if (!sexo.equals("hombre") && !sexo.equals("mujer")) {
            return "Sexo inválido";
        }

        Map<String, Float> actividadMultiplicador = Map.of(
                "sedentario", 1.2f,
                "ligera", 1.375f,
                "moderada", 1.55f,
                "intensa", 1.725f,
                "muy intensa", 1.9f
        );

        float calorias = 0;
        if (sexo.equals("hombre")) {
            calorias = (float) ((10 * peso) + (6.25 * altura) - (5 * edad) + 5);
        } else {
            calorias = (float) ((10 * peso) + (6.25 * altura) - (5 * edad) - 161);
        }

        if (actividadMultiplicador.containsKey(actividad)) {
            calorias *= actividadMultiplicador.get(actividad);
        } else {
            return "Actividad inválida";
        }

        return "La cantidad de calorias que debes consumir es: " + calorias;
    }

    @PostMapping("apuntarse")
    public String apuntarse(@RequestParam String nombre, @RequestParam String apellidos, @RequestParam String email, @RequestParam String telefono, @RequestParam String direccion, @RequestParam String edad, @RequestParam String sexo, @RequestParam String actividad) {

        // Verifica si algún campo está vacío
        if (nombre.equals("") || apellidos.equals("") || email.equals("") || telefono.equals("") || direccion.equals("") || edad.equals("") || sexo.equals("") || actividad.equals("")) {
            return "Faltan datos";
        }

        // Verifica la validez del sexo
        if (!sexo.equals("hombre") && !sexo.equals("mujer")) {
            return "Sexo inválido";
        }

        // Verifica la validez de la actividad
        if (!actividad.equals("sedentario") && !actividad.equals("ligera") && !actividad.equals("moderada") && !actividad.equals("intensa") && !actividad.equals("muy intensa")) {
            return "Actividad inválida";
        }

        // Si todo es correcto, devuelve la confirmación
        return "Nombre: " + nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Email: " + email + "\n" +
                "Telefono: " + telefono + "\n" +
                "Direccion: " + direccion + "\n" +
                "Edad: " + edad + "\n" +
                "Sexo: " + sexo + "\n" +
                "Actividad: " + actividad + "\n" +
                "Te has apuntado correctamente";
    }
}