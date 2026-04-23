---
tags: [android, pantalla, calculadora, validacion]
related: "[[INICIO]]"
---

# Pantalla - CalculadoraActivity

> <- Volver a [[INICIO]]

## Datos Generales

| Campo | Valor |
|---|---|
| Clase | `CalculadoraActivity.kt` |
| Layout | `activity_calculadora.xml` |
| Paquete | `ui/calculadora/` |
| Boton en menu | Etapa 4 Dimension 3 |
| Funcion | Calculadora basica con 4 operaciones |

## Descripcion

El usuario ingresa dos numeros en campos de texto, selecciona una operacion con RadioButtons y presiona "Calcular" para obtener el resultado.

Referencia usada para aprender la logica: Video de YouTube ID `ZuhkYS5AEYM` (uso de RadioButtons en Android).

## Operaciones Disponibles

| Operacion | RadioButton ID |
|---|---|
| Suma | `rbSuma` (seleccionado por defecto) |
| Resta | `rbResta` |
| Multiplicacion | `rbMultiplicacion` |
| Division | `rbDivision` |

## Validaciones

| Situacion | Mensaje mostrado |
|---|---|
| Uno o ambos campos vacios | "Por favor ingresa ambos numeros" |
| Division entre cero | "No se puede dividir entre cero" |

## Logica Principal — CalculadoraActivity.kt

```kotlin
private fun calcular() {
    val num1Str = etNum1.text.toString()
    val num2Str = etNum2.text.toString()

    // Validacion 1: campos vacios
    if (num1Str.isEmpty() || num2Str.isEmpty()) {
        Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show()
        return
    }

    val num1 = num1Str.toDouble()
    val num2 = num2Str.toDouble()

    // Validacion 2: division entre cero
    if (rbDivision.isChecked && num2 == 0.0) {
        Toast.makeText(this, getString(R.string.error_div_zero), Toast.LENGTH_SHORT).show()
        return
    }

    // Calculo segun la operacion seleccionada
    val resultado = when {
        rbSuma.isChecked           -> num1 + num2
        rbResta.isChecked          -> num1 - num2
        rbMultiplicacion.isChecked -> num1 * num2
        rbDivision.isChecked       -> num1 / num2
        else                       -> 0.0
    }

    // Formato: evitar mostrar "4.0" cuando el resultado es entero
    val resultadoFormateado = if (resultado % 1 == 0.0) {
        resultado.toInt().toString()
    } else {
        resultado.toString()
    }

    tvResultado.text = "Resultado: $resultadoFormateado"
}
```

## Conceptos Usados

- [[04 - Conceptos Clave#RadioButton y RadioGroup|RadioButton y RadioGroup]]
- [[04 - Conceptos Clave#`setOnClickListener`|setOnClickListener]]
- [[04 - Conceptos Clave#Toast|Toast]]
- [[04 - Conceptos Clave#`lateinit var`|lateinit var]]
