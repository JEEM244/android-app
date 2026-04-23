---
tags: [android, pantalla, colores, radiogroup]
related: "[[INICIO]]"
---

# Pantalla - ColorActivity

> <- Volver a [[INICIO]]

## Datos Generales

| Campo | Valor |
|---|---|
| Clase | `ColorActivity.kt` |
| Layout | `activity_color.xml` |
| Paquete | `ui/color/` |
| Boton en menu | Etapa 4 Evidencia |
| Funcion | Cambia el color de fondo de la pantalla |

## Descripcion

Muestra 10 opciones de color en un RadioGroup. Al seleccionar cualquiera de ellos, el fondo de toda la pantalla cambia instantaneamente al color elegido.

## Colores Disponibles

| Color | ID del RadioButton |
|---|---|
| Rojo | `rbRojo` |
| Azul | `rbAzul` |
| Verde | `rbVerde` |
| Amarillo | `rbAmarillo` |
| Negro | `rbNegro` |
| Blanco | `rbBlanco` |
| Morado | `rbMorado` |
| Cyan | `rbCyan` |
| Magenta | `rbMagenta` |
| Gris | `rbGris` |

## Codigo — ColorActivity.kt

```kotlin
rgColors.setOnCheckedChangeListener { _, checkedId ->
    val colorRes = when (checkedId) {
        R.id.rbRojo    -> R.color.red
        R.id.rbAzul    -> R.color.blue
        R.id.rbVerde   -> R.color.green
        R.id.rbAmarillo-> R.color.yellow
        R.id.rbNegro   -> R.color.black
        R.id.rbBlanco  -> R.color.white
        R.id.rbMorado  -> R.color.purple
        R.id.rbCyan    -> R.color.cyan
        R.id.rbMagenta -> R.color.magenta
        R.id.rbGris    -> R.color.gray
        else           -> R.color.white
    }
    mainLayout.setBackgroundColor(ContextCompat.getColor(this, colorRes))
}
```

> [!NOTE]
> A diferencia del Quiz, aqui el cambio es inmediato al tocar el RadioButton, sin necesitar un boton de "Confirmar". Esto se logra con `setOnCheckedChangeListener`.

## Problema Encontrado

Usar `R.color.red` directamente en `setBackgroundColor()` no funcionaba correctamente porque ese metodo necesita un valor entero de color, no un recurso.

Solucion: `ContextCompat.getColor(this, R.color.red)` → Ver [[07 - Problemas y Soluciones]] (Problema #2)

## Conceptos Usados

- [[04 - Conceptos Clave#RadioButton y RadioGroup|RadioButton y RadioGroup]]
- [[04 - Conceptos Clave#`setOnCheckedChangeListener`|setOnCheckedChangeListener]]
- [[04 - Conceptos Clave#`ContextCompat.getColor()`|ContextCompat.getColor]]
