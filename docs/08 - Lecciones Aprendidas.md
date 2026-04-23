---
tags: [android, reflexion, aprendizaje]
related: "[[INICIO]]"
---

# Lecciones Aprendidas

> <- Volver a [[INICIO]]

## Reflexiones del Proyecto

### Android es diferente a programar web

En la web el flujo es mas lineal: HTML para estructura, CSS para estilos, JavaScript para logica. En Android la arquitectura es mas estricta: cada pantalla es una clase (Activity), el diseno es XML separado del codigo, los textos van en `strings.xml`, los colores en `colors.xml`, y todo lo que exista debe estar declarado en el `AndroidManifest.xml`.

### El Logcat es esencial para depurar

Cuando la app crashea, la pestaña "Logcat" de Android Studio muestra exactamente que salio mal y en que linea. Sin leer el Logcat es casi imposible resolver errores. Fue clave para detectar el `ActivityNotFoundException` del [[07 - Problemas y Soluciones|Problema #1]].

### Los recursos van en archivos dedicados

Al principio queria escribir el texto directo en el XML del layout. Se aprendio que es mejor practica usar `strings.xml` para textos y `colors.xml` para colores, porque permite cambiarlos desde un solo lugar sin tocar cada archivo de layout.

### Kotlin es mas limpio que Java

La sintaxis concisa de Kotlin (menos codigo, mas legible) lo hizo mas accesible para aprenderlo desde cero. Caracteristicas como `data class`, `lateinit`, el operador `when` y las lambdas simplifican mucho el codigo comparado con Java.

### La estructura de carpetas importa

Organizar las Activities en subcarpetas (`ui/main`, `ui/quiz`, `ui/color`, `ui/calculadora`) en lugar de poner todo en el mismo paquete hace el proyecto mucho mas facil de entender y mantener cuando crece.

### Probar en dispositivo fisico requiere configuracion

Para correr la app en un telefono real es necesario:
1. Activar las **Opciones de Desarrollador** (tocar 7 veces "Numero de compilacion")
2. Habilitar la **Depuracion por USB**
3. Al conectar el cable, seleccionar **"Transferencia de archivos"** (no "Solo cargar")
4. Autorizar la computadora en el telefono cuando aparezca el dialogo

### Separar logica en funciones

En el QuizActivity, separar la logica en funciones especificas (`initViews()`, `displayQuestion()`, `handleNextButtonClick()`, `showResults()`) hace el codigo mucho mas claro que escribir todo dentro de `onCreate()`.

---

## Relaciones con otras notas

- [[04 - Conceptos Clave]] — Los conceptos nuevos que se tuvieron que aprender
- [[07 - Problemas y Soluciones]] — Los errores concretos y como se resolvieron
- [[06 - Cronologia]] — El proceso completo de construccion

---

*Jesus Elias Escobedo Martinez — Grupo 4L1 — Tecnico Desarrollador Web*
