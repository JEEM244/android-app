---
tags: [android, pantalla, menu, navegacion]
related: "[[INICIO]]"
---

# Pantalla - MainActivity

> <- Volver a [[INICIO]]

## Datos Generales

| Campo | Valor |
|---|---|
| Clase | `MainActivity.kt` |
| Layout | `activity_main.xml` |
| Paquete | `ui/main/` |
| Función | Menu de navegacion principal |

## Descripcion

Es la pantalla de inicio de la aplicacion. Muestra el titulo y tres botones que abren las demas pantallas usando Intents.

## Componentes Visuales

- `TextView` — Titulo "Menu de Actividades"
- `TextView` — Etiqueta gris "Cuestionario de conocimientos" (encima del boton PIA)
- `Button` — **PIA** → abre [[Pantalla - QuizActivity]]
- `TextView` — Etiqueta gris "Seleccion de colores" (encima del boton Evidencia)
- `Button` — **Etapa 4 Evidencia** → abre [[Pantalla - ColorActivity]]
- `TextView` — Etiqueta gris "Calculadora basica" (encima del boton Dimension)
- `Button` — **Etapa 4 Dimension 3** → abre [[Pantalla - CalculadoraActivity]]
- `TextView` — Pie de pagina con nombre y grupo

## Codigo — MainActivity.kt

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToQuiz: Button = findViewById(R.id.btnGoToQuiz)
        val btnGoToColors: Button = findViewById(R.id.btnGoToColors)
        val btnGoToCalculadora: Button = findViewById(R.id.btnGoToCalculadora)

        btnGoToQuiz.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
        btnGoToColors.setOnClickListener {
            startActivity(Intent(this, ColorActivity::class.java))
        }
        btnGoToCalculadora.setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
    }
}
```

## Conceptos Usados

- [[04 - Conceptos Clave#Intent — Navegar entre pantallas|Intent]]
- [[04 - Conceptos Clave#`setOnClickListener`|setOnClickListener]]
- [[04 - Conceptos Clave#`findViewById`|findViewById]]
