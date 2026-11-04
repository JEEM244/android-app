<p align="center">
  <img src=".github/assets/cover.svg" alt="Aplicación Android con menú, quiz, selector de colores y calculadora" width="100%">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-Android-7F52FF?style=flat-square&logo=kotlin&logoColor=white">
  <img src="https://img.shields.io/badge/Android-Studio-3DDC84?style=flat-square&logo=android&logoColor=white">
  <img src="https://img.shields.io/badge/XML-layouts-E34F26?style=flat-square&logo=androidstudio&logoColor=white">
  <img src="https://img.shields.io/badge/Estado-proyecto%20acad%C3%A9mico-477F94?style=flat-square">
</p>

<h1 align="center">Aplicación Android · 4 actividades</h1>
<p align="center">Un proyecto académico para practicar pantallas, navegación y componentes de Android.</p>

<p align="center">
  <a href="#recorrido-de-la-app">Recorrido</a> ·
  <a href="#pantallas">Pantallas</a> ·
  <a href="#tecnologías">Tecnologías</a> ·
  <a href="#cómo-ejecutar">Ejecutar</a>
</p>

Esta aplicación Android está desarrollada en Kotlin. Contiene cuatro pantallas con funcionalidades distintas y navegación mediante Intents.

## Recorrido de la app

```mermaid
flowchart TD
    A["Menú principal"] --> B["Cuestionario"]
    A --> C["Selector de colores"]
    A --> D["Calculadora"]
    B --> E["Resultado del quiz"]
    C --> F["Cambio de fondo"]
    D --> G["Operación y resultado"]
```

## Pantallas

| Pantalla | Qué hace |
|---|---|
| **MainActivity** | Menú para abrir las demás actividades |
| **QuizActivity** | Cuestionario de 12 preguntas de opción múltiple |
| **ColorActivity** | Permite elegir entre 10 colores para cambiar el fondo |
| **CalculadoraActivity** | Suma, resta, multiplicación y división de dos números |

### Cuestionario

El quiz trata conceptos de Android y programación: CPU, Kotlin, Activity, AndroidManifest, Gradle, Intents, layouts XML y componentes de interfaz.

### Selector de colores

Muestra 10 opciones dentro de un `RadioGroup`. Al seleccionar una, el fondo cambia inmediatamente.

### Calculadora

Permite ingresar dos números, seleccionar una operación y mostrar el resultado. Incluye validaciones para campos vacíos y división entre cero.

## Organización del proyecto

```text
app/src/main/
├── AndroidManifest.xml
├── java/com/example/mi_app_sop_e4_ea_jeem/
│   ├── data/model/Question.kt
│   └── ui/
│       ├── main/MainActivity.kt
│       ├── quiz/QuizActivity.kt
│       ├── color/ColorActivity.kt
│       └── calculadora/CalculadoraActivity.kt
└── res/
    ├── layout/
    └── values/
```

## Tecnologías

| Tecnología | Uso |
|---|---|
| Kotlin | Lógica de las actividades |
| Android Studio | Entorno de desarrollo |
| Gradle | Compilación |
| AndroidX / AppCompat | Compatibilidad |
| XML | Diseño de las pantallas |

## Conceptos practicados

Activities, Intents, AndroidManifest, `findViewById`, `RadioButton`, `RadioGroup`, `Toast` y validación de entradas.

## Cómo ejecutar

### Requisitos

- Android Studio y SDK de Android.
- Emulador o dispositivo Android.

### Desde Android Studio

1. Abre la carpeta del proyecto.
2. Selecciona un emulador o conecta un teléfono de prueba.
3. Ejecuta la aplicación con **Run**.

### Desde PowerShell

```powershell
.\gradlew.bat installDebug
```

<p align="center"><sub>Proyecto académico · Cuatro actividades para practicar la estructura básica de una app Android.</sub></p>
