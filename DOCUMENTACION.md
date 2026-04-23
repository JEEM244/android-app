---
tags:
  - android
  - kotlin
  - proyecto
  - etapa4
  - programacion-movil
created: 2026-04-22
autor: Jesus Elias Escobedo Martinez
grupo: 4L1
especialidad: Técnico Desarrollador Web
---

# 📱 MI_APP_SOP_E4_EA_JEEM — Documentación del Proyecto

> **Alumno:** Jesus Elias Escobedo Martinez  
> **Grupo:** 4L1 · **Especialidad:** Técnico Desarrollador Web  
> **Entorno:** Android Studio · **Lenguaje:** Kotlin

---

## 🗂️ Índice

- [[#1. Descripción General]]
- [[#2. Tecnologías y Herramientas]]
- [[#3. Estructura del Proyecto]]
- [[#4. Conceptos Clave Investigados]]
- [[#5. Pantallas de la Aplicación]]
  - [[#5.1 Menú Principal — MainActivity]]
  - [[#5.2 Cuestionario PIA — QuizActivity]]
  - [[#5.3 Colores — ColorActivity]]
  - [[#5.4 Calculadora — CalculadoraActivity]]
- [[#6. Cronología del Desarrollo]]
- [[#7. Problemas Encontrados y Soluciones]]
- [[#8. Lecciones Aprendidas]]

---

## 1. Descripción General

Esta aplicación de Android fue desarrollada en **Kotlin** como proyecto académico de la materia de Sistemas Operativos / Programación Móvil. El objetivo fue aprender la arquitectura de una app Android, la navegación entre pantallas y el uso de componentes visuales (widgets).

La app tiene **4 pantallas principales**:

| Pantalla | Botón en menú | Función |
| --- | --- | --- |
| `MainActivity` | — | Menú de navegación principal |
| `QuizActivity` | **PIA** | Cuestionario de 12 preguntas de opción múltiple |
| `ColorActivity` | **Etapa 4 Evidencia** | Cambia el color de fondo de la pantalla |
| `CalculadoraActivity` | **Etapa 4 Dimensión 3** | Calculadora básica con 4 operaciones |

---

## 2. Tecnologías y Herramientas

| Herramienta | Uso |
| --- | --- |
| **Kotlin** | Lenguaje principal de programación |
| **Android Studio** | IDE de desarrollo |
| **Gradle (gradlew)** | Sistema de compilación y construcción del APK |
| **AndroidX / AppCompat** | Librería de compatibilidad de Google |
| **XML** | Diseño de los layouts de cada pantalla |

### Widgets (componentes visuales) utilizados

- `TextView` — Mostrar texto
- `EditText` — Campo de entrada del usuario
- `Button` — Botón presionable
- `RadioButton` / `RadioGroup` — Selección de opción única
- `LinearLayout` / `ScrollView` — Contenedores de diseño
- `Toast` — Mensaje emergente temporal

---

## 3. Estructura del Proyecto

```
MI_APP_SOP_E4_EA_JEEM/
│
├── DOCUMENTACION.md                 ← Este archivo
├── AndroidManifest.xml              ← Config central: registra todas las Activities
│
├── java/com/example/.../
│   ├── data/model/
│   │   └── Question.kt              ← Modelo de datos para las preguntas del quiz
│   └── ui/
│       ├── main/MainActivity.kt     ← Menú principal
│       ├── quiz/QuizActivity.kt     ← Cuestionario
│       ├── color/ColorActivity.kt   ← Pantalla de colores
│       └── calculadora/
│           └── CalculadoraActivity.kt ← Calculadora
│
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_quiz.xml
    │   ├── activity_color.xml
    │   └── activity_calculadora.xml
    └── values/
        ├── strings.xml              ← Todos los textos de la app
        ├── colors.xml               ← Paleta de colores
        └── themes.xml               ← Tema visual
```

> [!NOTE]
> En Android Studio los archivos `.kt` van dentro de la carpeta `java/` aunque el lenguaje sea Kotlin. Esto es normal.

---

## 4. Conceptos Clave Investigados

### 🔷 Activity
Una **Activity** es una pantalla de la app. Cada pantalla nueva es una Activity que hereda de `AppCompatActivity`.

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Conecta con su layout XML
    }
}
```

---

### 🔷 Intent — Navegar entre pantallas
Un **Intent** es el mecanismo para pasar de una pantalla a otra. Sin él, los botones del menú no harían nada.

```kotlin
val intent = Intent(this, QuizActivity::class.java)
startActivity(intent)
```

---

### 🔷 AndroidManifest.xml
Archivo de configuración central. **Toda Activity debe estar registrada aquí**, de lo contrario la app crashea.

```xml
<activity
    android:name=".ui.calculadora.CalculadoraActivity"
    android:label="@string/calculadora_title" />
```

> [!WARNING]
> Si creas una Activity nueva y NO la agregas al manifest, la app lanzará una `ActivityNotFoundException` y se cerrará abruptamente.

---

### 🔷 `findViewById`
Conecta el código Kotlin con los elementos visuales del XML. El `id` en el XML se accede desde Kotlin con `R.id.nombre`.

```kotlin
val btnGoToQuiz: Button = findViewById(R.id.btnGoToQuiz)
```

---

### 🔷 `lateinit var`
Declara una variable sin valor inicial, prometiendo que se asignará antes de usarla. Se usa mucho en Android porque los elementos de la UI no existen hasta que se ejecuta `setContentView()`.

```kotlin
private lateinit var btnCalcular: Button
// Más adelante en onCreate:
btnCalcular = findViewById(R.id.btnCalcular)
```

---

### 🔷 RadioButton y RadioGroup
`RadioButton` es una opción seleccionable circular. `RadioGroup` es el contenedor que garantiza que **solo uno pueda estar activo a la vez**.

---

### 🔷 `setOnClickListener`
Asigna una acción a un botón cuando el usuario lo presiona.

```kotlin
btnCalcular.setOnClickListener {
    calcular()
}
```

---

### 🔷 `setOnCheckedChangeListener`
Reacciona inmediatamente cuando el usuario selecciona un RadioButton, sin necesidad de un botón de confirmar.

```kotlin
rgColors.setOnCheckedChangeListener { _, checkedId ->
    // Cambiar color de fondo según la selección
}
```

---

### 🔷 Toast
Mensaje emergente corto que aparece en pantalla y desaparece solo.

```kotlin
Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
```

---

### 🔷 `strings.xml`
Archivo donde se centralizan todos los textos de la app. En lugar de escribir texto directamente en el XML, se referencia con `@string/nombre`. Permite cambiar textos desde un solo lugar.

---

## 5. Pantallas de la Aplicación

### 5.1 Menú Principal — MainActivity

**Archivos:** `activity_main.xml` · `MainActivity.kt`

Pantalla de inicio. Muestra el título y 3 botones para navegar a las demás Activities.

**Componentes:**
- `TextView` — Título "Menú de Actividades"
- 3 × `TextView` — Etiquetas descriptivas encima de cada botón (color gris)
- 3 × `Button` — PIA / Etapa 4 Evidencia / Etapa 4 Dimensión 3
- `TextView` — Pie de página con nombre y grupo

```kotlin
btnGoToQuiz.setOnClickListener {
    startActivity(Intent(this, QuizActivity::class.java))
}
btnGoToColors.setOnClickListener {
    startActivity(Intent(this, ColorActivity::class.java))
}
btnGoToCalculadora.setOnClickListener {
    startActivity(Intent(this, CalculadoraActivity::class.java))
}
```

---

### 5.2 Cuestionario PIA — QuizActivity

**Archivos:** `activity_quiz.xml` · `QuizActivity.kt` · `Question.kt`

Cuestionario de 12 preguntas de opción múltiple sobre conceptos de Android y programación. Al finalizar muestra el resultado con las preguntas falladas.

**Modelo de datos:**

```kotlin
data class Question(
    val text: String,           // Texto de la pregunta
    val options: List<String>,  // 4 opciones de respuesta
    val correctAnswerIndex: Int // Índice de la respuesta correcta (0-3)
)
```

**Flujo:**
1. Se muestra la pregunta con sus 4 opciones en RadioButtons
2. El usuario selecciona y presiona **"Siguiente"**
3. Si no seleccionó → Toast de advertencia y no avanza
4. Se compara el índice seleccionado con `correctAnswerIndex`
5. Al terminar la pregunta 12 → muestra el panel de resultados

**Las 12 preguntas:**

| # | Pregunta | Respuesta correcta |
| --- | --- | --- |
| 1 | ¿Qué significa CPU? | Central Processing Unit |
| 2 | ¿Cuál es el lenguaje oficial para Android? | Kotlin |
| 3 | ¿Qué componente se usa para la UI? | Activity |
| 4 | ¿Qué archivo define la configuración de la app? | AndroidManifest.xml |
| 5 | ¿Qué es Gradle? | Sistema de compilación |
| 6 | ¿Quién desarrolló Android? | Google |
| 7 | ¿Qué es un Intent? | Mensaje de comunicación |
| 8 | ¿Cuál es el IDE oficial? | Android Studio |
| 9 | ¿Qué extensión tienen los layouts? | .xml |
| 10 | ¿Qué es un RadioGroup? | Contenedor de botones |
| 11 | ¿Para qué sirve `findViewById`? | Enlazar vistas al código |
| 12 | ¿Qué es una Activity? | Una pantalla de la app |

---

### 5.3 Colores — ColorActivity

**Archivos:** `activity_color.xml` · `ColorActivity.kt`

Muestra 10 opciones de color en un `RadioGroup`. Al seleccionar uno, el fondo de la pantalla cambia instantáneamente.

**Colores:** Rojo · Azul · Verde · Amarillo · Negro · Blanco · Morado · Cyan · Magenta · Gris

**Concepto importante:** Se usa `ContextCompat.getColor()` para convertir el recurso de color al valor entero que necesita `setBackgroundColor()`.

```kotlin
rgColors.setOnCheckedChangeListener { _, checkedId ->
    val colorRes = when (checkedId) {
        R.id.rbRojo -> R.color.red
        R.id.rbAzul -> R.color.blue
        // ...
        else -> R.color.white
    }
    mainLayout.setBackgroundColor(ContextCompat.getColor(this, colorRes))
}
```

---

### 5.4 Calculadora — CalculadoraActivity

**Archivos:** `activity_calculadora.xml` · `CalculadoraActivity.kt`

Calculadora básica. El usuario ingresa 2 números, selecciona la operación con RadioButtons y presiona **"Calcular"**.

**Operaciones:** Suma · Resta · Multiplicación · División

**Validaciones:**

| Validación | Mensaje mostrado |
| --- | --- |
| Campos vacíos | "Por favor ingresa ambos números" |
| División entre cero | "No se puede dividir entre cero" |

**Detalle de formato:** Si el resultado es entero (ej. `4.0`), se muestra como `4` sin el `.0`.

```kotlin
val resultadoFormateado = if (resultado % 1 == 0.0) {
    resultado.toInt().toString()
} else {
    resultado.toString()
}
```

> [!NOTE]
> La lógica de RadioButtons para seleccionar la operación fue aprendida del video de YouTube referencia del proyecto (ID: `ZuhkYS5AEYM`).

---

## 6. Cronología del Desarrollo

```
Fase 1 ─── Configuración inicial + Menú Principal + Intents
    │
Fase 2 ─── QuizActivity: modelo de datos, lógica de preguntas, resultados
    │
Fase 3 ─── ColorActivity: RadioGroup con cambio dinámico de fondo
    │
Fase 4 ─── CalculadoraActivity: EditText, operaciones, validaciones
    │
Fase 5 ─── Rediseño del Menú Principal: nuevos textos y etiquetas descriptivas
    │
Fase 6 ─── Pie de página con datos del alumno en todas las pantallas
```

---

## 7. Problemas Encontrados y Soluciones

| # | Problema | Causa | Solución |
| --- | --- | --- | --- |
| 1 | App se cerraba al navegar a otra pantalla | Activity no registrada en `AndroidManifest.xml` | Agregar la etiqueta `<activity>` en el manifiesto |
| 2 | El color de fondo no cambiaba correctamente | `setBackgroundColor()` espera un `Int`, no `R.color.xxx` | Usar `ContextCompat.getColor(this, R.color.xxx)` |
| 3 | No sabía cómo pasar de una pantalla a otra | Desconocimiento de los `Intent` en Android | Investigar y usar `startActivity(Intent(...))` |
| 4 | El resultado mostraba `4.0` en vez de `4` | Operaciones `Double` siempre tienen decimal | Verificar `resultado % 1 == 0.0` y convertir a `Int` |
| 5 | No sabía conectar el XML con el código | Desconocimiento de `findViewById` | Aprender que los `id` del XML se usan con `R.id.nombre` |
| 6 | El RadioGroup no se deseleccionaba entre preguntas | Faltaba `radioGroup.clearCheck()` | Llamar a ese método dentro de `displayQuestion()` |

---

## 8. Lecciones Aprendidas

1. **Android ≠ Web.** En la web el flujo es HTML → CSS → JS. En Android hay arquitectura estricta: Activities, XML, Resources, Manifest. Cada cosa tiene su lugar.

2. **Logcat es esencial.** Cuando la app crashea, los errores en la pestaña "Logcat" de Android Studio dicen exactamente qué falló y en qué línea. Sin leerlo, es casi imposible depurar.

3. **Centralizar textos en `strings.xml`** permite cambiarlos desde un solo lugar y, en el futuro, traducir la app a otro idioma sin tocar el código.

4. **Kotlin es más limpio que Java.** Su sintaxis concisa (menos código, más legible) lo hizo más fácil de aprender comparado con ejemplos antiguos en Java.

5. **La estructura de carpetas importa.** Organizar las Activities en subcarpetas (`ui/main`, `ui/quiz`, etc.) hace el proyecto más mantenible cuando crece.

6. **Dispositivo físico requiere preparación.** Para probar en un teléfono real hay que: activar Opciones de Desarrollador → habilitar Depuración USB → seleccionar "Transferencia de archivos" al conectar el cable → autorizar la computadora en el teléfono.

---

*Documentación del proyecto MI_APP_SOP_E4_EA_JEEM — Etapa 4*  
*Jesus Elias Escobedo Martinez · Grupo 4L1 · Técnico Desarrollador Web*
