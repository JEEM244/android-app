---
tags: [android, conceptos, aprendizaje, kotlin]
related: "[[INICIO]]"
---

# Conceptos Clave Investigados

> <- Volver a [[INICIO]]  
> Conceptos que tuve que investigar porque no sabia programar en Android.

---

## Activity

Una **Activity** es una pantalla de la app. Cada pantalla nueva es una Activity que hereda de `AppCompatActivity`.

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Une esta clase con su XML
    }
}
```

Usado en: [[Pantalla - MainActivity]] · [[Pantalla - QuizActivity]] · [[Pantalla - ColorActivity]] · [[Pantalla - CalculadoraActivity]]

---

## Intent — Navegar entre pantallas

Un **Intent** es el mecanismo para pasar de una pantalla a otra. Es como un mensaje que le dice al sistema "abre esta Activity".

```kotlin
val intent = Intent(this, QuizActivity::class.java)
startActivity(intent)
```

> [!WARNING]
> Sin un Intent configurado correctamente, el boton del menu no hace nada al presionarse.

Usado en: [[Pantalla - MainActivity]]

---

## AndroidManifest.xml

Archivo de configuracion central. Toda Activity debe declararse aqui, de lo contrario la app crashea con `ActivityNotFoundException`.

```xml
<activity
    android:name=".ui.calculadora.CalculadoraActivity"
    android:label="@string/calculadora_title" />
```

Ver el error relacionado: [[07 - Problemas y Soluciones]] (Problema #1)

---

## `findViewById`

Conecta el codigo Kotlin con los elementos del layout XML. Si en el XML tienes `android:id="@+id/btnGoToQuiz"`, lo obtienes con:

```kotlin
val btnGoToQuiz: Button = findViewById(R.id.btnGoToQuiz)
```

---

## `lateinit var`

Declara una variable sin asignarle valor todavia, pero prometes que tendra uno antes de usarla. Muy comun en Android porque los widgets no existen hasta que se llama `setContentView()`.

```kotlin
private lateinit var btnCalcular: Button
// Mas adelante, dentro de onCreate:
btnCalcular = findViewById(R.id.btnCalcular)
```

---

## RadioButton y RadioGroup

`RadioButton` es una opcion circular seleccionable.  
`RadioGroup` es el contenedor que garantiza que **solo uno pueda estar activo a la vez**.

Usado en: [[Pantalla - QuizActivity]] · [[Pantalla - ColorActivity]] · [[Pantalla - CalculadoraActivity]]

---

## `setOnClickListener`

Define que pasa cuando el usuario presiona un boton.

```kotlin
btnCalcular.setOnClickListener {
    calcular() // Se ejecuta al presionar
}
```

---

## `setOnCheckedChangeListener`

Reacciona **inmediatamente** cuando el usuario selecciona un RadioButton, sin necesitar un boton de confirmar.

```kotlin
rgColors.setOnCheckedChangeListener { _, checkedId ->
    // Se ejecuta en cuanto cambia la seleccion
}
```

Usado en: [[Pantalla - ColorActivity]]

---

## Toast

Mensaje emergente corto que aparece en pantalla y desaparece solo.

```kotlin
Toast.makeText(this, "Error: campos vacios", Toast.LENGTH_SHORT).show()
```

Usado en: [[Pantalla - QuizActivity]] · [[Pantalla - CalculadoraActivity]]

---

## `strings.xml`

Archivo donde se centralizan todos los textos de la app. En vez de escribir el texto directo en el XML, se referencia con `@string/nombre`. Facilita cambiar textos desde un solo lugar.

---

## `ContextCompat.getColor()`

Convierte un recurso de color (`R.color.red`) al valor entero que necesita `setBackgroundColor()`.

```kotlin
mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
```

Ver error relacionado: [[07 - Problemas y Soluciones]] (Problema #2)

---

## `data class` en Kotlin

Clase simplificada para almacenar datos. Kotlin genera automaticamente `equals()`, `hashCode()` y `toString()`.

```kotlin
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
```

Usado en: [[Pantalla - QuizActivity]]
