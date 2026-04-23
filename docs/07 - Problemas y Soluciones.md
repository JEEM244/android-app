---
tags: [android, errores, debug, soluciones]
related: "[[INICIO]]"
---

# Problemas Encontrados y Soluciones

> <- Volver a [[INICIO]]

Durante el desarrollo se presentaron varios errores. Aqui se documentan con su causa y la forma en que se resolvieron.

---

## Problema 1 — App se cerraba al navegar a otra pantalla

**Pantalla afectada:** [[Pantalla - MainActivity]]  
**Error en Logcat:** `ActivityNotFoundException`

**Causa:** La Activity destino no estaba registrada en `AndroidManifest.xml`. Android no sabia que esa clase existia.

**Solucion:**
```xml
<!-- Agregar esto dentro de <application> en AndroidManifest.xml -->
<activity
    android:name=".ui.calculadora.CalculadoraActivity"
    android:label="@string/calculadora_title" />
```

> [!WARNING]
> Toda Activity nueva debe declararse en el manifest antes de intentar abrirla con un Intent.

---

## Problema 2 — El color de fondo no cambiaba correctamente

**Pantalla afectada:** [[Pantalla - ColorActivity]]

**Causa:** `setBackgroundColor()` espera un valor entero de color (como `0xFFFF0000`), no un ID de recurso como `R.color.red`. Al pasar `R.color.red` directamente, el color resultante era incorrecto.

**Solucion:**
```kotlin
// Incorrecto:
mainLayout.setBackgroundColor(R.color.red)

// Correcto:
mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
```

`ContextCompat.getColor()` resuelve el recurso y devuelve el valor entero correcto.

---

## Problema 3 — No sabia como pasar de una pantalla a otra

**Pantalla afectada:** [[Pantalla - MainActivity]]

**Causa:** Desconocimiento del concepto de `Intent` en Android.

**Solucion:**
```kotlin
val intent = Intent(this, QuizActivity::class.java)
startActivity(intent)
```

Ver explicacion completa: [[04 - Conceptos Clave#Intent — Navegar entre pantallas|Concepto de Intent]]

---

## Problema 4 — El resultado mostraba "4.0" en vez de "4"

**Pantalla afectada:** [[Pantalla - CalculadoraActivity]]

**Causa:** Las operaciones con `Double` siempre incluyen decimales, incluso cuando el resultado es un numero entero.

**Solucion:**
```kotlin
val resultadoFormateado = if (resultado % 1 == 0.0) {
    resultado.toInt().toString()  // Muestra "4"
} else {
    resultado.toString()           // Muestra "4.5"
}
```

---

## Problema 5 — No sabia conectar el XML con el codigo

**Causa:** Desconocimiento de `findViewById` y el sistema de IDs en Android.

**Solucion:** Aprender que los `id` definidos en el XML con `android:id="@+id/nombreBoton"` se acceden en Kotlin con `R.id.nombreBoton`:

```kotlin
val btnGoToQuiz: Button = findViewById(R.id.btnGoToQuiz)
```

Ver explicacion: [[04 - Conceptos Clave#`findViewById`|Concepto de findViewById]]

---

## Problema 6 — El RadioGroup no se deseleccionaba entre preguntas

**Pantalla afectada:** [[Pantalla - QuizActivity]]

**Causa:** Al pasar a la siguiente pregunta, la respuesta anterior permanecia seleccionada. Faltaba llamar a `radioGroup.clearCheck()`.

**Solucion:**
```kotlin
private fun displayQuestion() {
    // ... cargar texto de pregunta y opciones ...
    radioGroup.clearCheck()  // Limpia la seleccion anterior
}
```

---

## Resumen

| # | Problema | Causa | Estado |
|---|---|---|---|
| 1 | App crasheaba al navegar | Activity no registrada en manifest | Resuelto |
| 2 | Color no cambiaba correctamente | Tipo de dato incorrecto en setBackgroundColor | Resuelto |
| 3 | No sabia navegar entre pantallas | Desconocimiento de Intent | Resuelto |
| 4 | Resultado mostraba "4.0" | Operaciones Double con decimal | Resuelto |
| 5 | No sabia conectar XML con codigo | Desconocimiento de findViewById | Resuelto |
| 6 | RadioGroup no se limpiaba | Faltaba clearCheck() | Resuelto |
