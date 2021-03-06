# daily-kotlin
[![Build Status](https://travis-ci.org/Genxas/daily-kotlin.svg?branch=master)](https://travis-ci.org/Genxas/daily-kotlin) [![](https://jitpack.io/v/Genxas/daily-kotlin.svg)](https://jitpack.io/#Genxas/daily-kotlin)

Kotlin Utilities which use in daily life

# Installation

```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.genxas:daily-kotlin:0.1.3'
}
```

# JSON extension

Single object

```kotlin
"{\"name\": \"john doe\"}".toObject<User>()
```

Multiple objects

```kotlin
"[{\"name\": \"john doe\"}, {\"name\": \"jane doe\"}]".toObjects<User>()
```

# Number extension

Show number with comma format

```kotlin
1000.1.thousands() // 1,000.1
```
